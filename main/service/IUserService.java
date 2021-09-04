package com.cg.main.service;

import java.util.Optional;

import com.cg.main.beans.User;
import com.cg.main.exception.*;

public interface IUserService {
	public User addUser(User user);
	public User removeUser(Integer id) throws UserNotFoundException;
	public User signin(Integer id);
	public String signout();
	public User changePassword(Integer id, String newPwd) throws Exception;
	//public Object removeUser(String userId);
	





}


