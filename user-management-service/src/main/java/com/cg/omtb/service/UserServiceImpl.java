package com.cg.omtb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.omtb.dao.UserRepo;
import com.cg.omtb.entity.UserEntity;
import com.cg.omtb.exception.UserException;
import com.cg.omtb.model.UserModel;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepo userRepo;
	
	private UserModel of(UserEntity source) {
		UserModel result=null;
		if(source!=null) {
			result=new UserModel();
			result.setUserId(source.getUserId());
			result.setPassword(source.getPassword());
			result.setEmail(source.getEmail());
			result.setPhoneNo(source.getPhoneNo());
			result.setUserRole(source.getUserRole());
			result.setLoginToken(source.getLoginToken());
			result.setUserName(source.getUserName());
		}
		return result;
	}
	private UserEntity of(UserModel source) {
		UserEntity result=null;
		if(source!=null) {
			result=new UserEntity();
			result.setUserId(source.getUserId());
			result.setPassword(source.getPassword());
			result.setEmail(source.getEmail());
			result.setPhoneNo(source.getPhoneNo());
			result.setUserRole(source.getUserRole());
			result.setLoginToken(source.getLoginToken());
			result.setUserName(source.getUserName());
		}
		return result;
	}
	
	@Override
	public UserModel userRegistration(UserModel user) throws UserException{
		if(user!=null) {
			if(userRepo.existsById(user.getUserId())) {
				throw new UserException("User have already registered !");
			}
			else if(userRepo.existsByEmail(user.getEmail())) {
				throw new UserException("Email already have already registered !");
			}
			else if(userRepo.existsByPhoneNo(user.getPhoneNo())) {
				throw new UserException("Phone Number have already registered !");
			}
			else {
				user=of(userRepo.save(of(user)));
			}
		}
	
		return user;
	}

	@Override
	public UserModel userLogin(String email, String password)  throws UserException{
		UserEntity user=userRepo.getUser(email, password);
		if(user!=null) {
			return of(user);
		}
		else {
			return null;
		}
		
	}

}
