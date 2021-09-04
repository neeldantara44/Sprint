package com.cg.main.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.main.beans.User;
import com.cg.main.exception.UserNotFoundException;
import com.cg.main.service.IUserService;

@RestController
public class UserController {

	@Autowired
	private IUserService service;

	@PostMapping("/addUser")
	public ResponseEntity<User> addUser(@RequestBody User user){
		User u = service.addUser(user);
		return new ResponseEntity<User>(u,HttpStatus.OK);
	}
	
	@DeleteMapping("/removeUser/{id}")
	public ResponseEntity<User> removeUser(@PathVariable int id) throws UserNotFoundException{
		User users=service.removeUser(id);
		return new ResponseEntity<User>(users,HttpStatus.OK);
   }

	@GetMapping("/login/{id}")
	public ResponseEntity<User> loginUser(@PathVariable int id){
		User temp = service.signin(id);
		return new ResponseEntity<User>(temp,HttpStatus.OK);
	}
	
	@GetMapping("/logout")
	public ResponseEntity<String> logoutUser(){
		String temp = service.signout();
		return new ResponseEntity<String>(temp,HttpStatus.OK);
	}
	
	@PostMapping("/changePassword/{id}/{password}")
	public User changePassword( @PathVariable("id") Integer id , @PathVariable("password") String newPwd ){
		User adminUser = null;
		try {
			adminUser =  service.changePassword(id,newPwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return adminUser;
	}

	
	 @ResponseStatus(HttpStatus.BAD_REQUEST)
	    @ExceptionHandler(MethodArgumentNotValidException.class)
	    public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
	        Map<String, String> errors = new HashMap<>();
	    
	        ex.getBindingResult().getFieldErrors().forEach(error ->
	            errors.put(error.getField(), error.getDefaultMessage()));   
	        return errors;
	    }
}
