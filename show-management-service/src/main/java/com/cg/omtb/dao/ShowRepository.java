package com.cg.omtb.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.omtb.entity.ShowEntity;

@Repository
public interface ShowRepository  extends JpaRepository<ShowEntity, Integer>{
	public List<ShowEntity> findByTheaterId(Integer theaterId);
	public ShowEntity findByShowId(Integer showId);
	
	@Query("Select s FROM ShowEntity s WHERE s.theaterId= :tId and s.startTime=:sTime")
	public ShowEntity getShow(Integer tId,String sTime);
}
