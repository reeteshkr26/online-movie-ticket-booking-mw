package com.cg.omtb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.omtb.entity.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity,Integer> {
	
	boolean existsByEmail(String email);
	boolean existsByPhoneNo(String phoneNo);
	
	@Query("SELECT u FROM UserEntity u WHERE u.email=:email AND u.password=:pass")
	public UserEntity getUser(@Param("email") String userId,@Param("pass") String password);

}
