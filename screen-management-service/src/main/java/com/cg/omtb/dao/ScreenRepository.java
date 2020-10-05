package com.cg.omtb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.omtb.entity.ScreenEntity;

@Repository
public interface ScreenRepository extends JpaRepository<ScreenEntity, Integer> {
	
	public ScreenEntity findByTheaterId(Integer theaterId);
	public void deleteByTheaterId(Integer theaterId);


}
