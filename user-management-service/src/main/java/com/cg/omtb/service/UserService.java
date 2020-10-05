package com.cg.omtb.service;

import com.cg.omtb.exception.UserException;
import com.cg.omtb.model.UserModel;

public interface UserService {
	
	public UserModel userRegistration(UserModel user)  throws UserException;
	public UserModel userLogin(String email, String password)  throws UserException;

}
