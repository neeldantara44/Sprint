package com.cg.main.service;

import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.main.repository.UserRepository;
import com.cg.main.beans.User;
import com.cg.main.exception.*;
import java.util.List;

@Transactional
@Service
public class IUserServiceImpl implements IUserService{

	@Autowired
	UserRepository repository;
	
	User user = new User();

	@Override
	public User addUser(User user) {	
		return repository.saveAndFlush(user);
	}

	@Override
	public User removeUser(Integer id) {
		User deletedUser=null;
			try {
				deletedUser=repository.findById(id).orElseThrow(()-> new UserNotFoundException("User not found"));
				repository.delete(deletedUser);
			} catch (UserNotFoundException e) {
				System.out.println(e.toString());
				//e.printStackTrace();
			}
		return deletedUser;
	}

	@Override
	public User signin(Integer id) {
		System.out.println("userId : "+id);
		return repository.findById(id).get();
	}

	@Override
	public String signout() {
		user = null;
		return "Logged out";
	}
	
	@Override
	public User changePassword(Integer id,String newPwd)  {
		Optional<User> aUser = repository.findById(id);
		if(aUser.isPresent()) {
			aUser.get().setPassword(newPwd);	
		}else {
			System.out.println(" Object is empty");
		    System.out.println("Invalid Credentials");
		}
		return null;
	}
}
