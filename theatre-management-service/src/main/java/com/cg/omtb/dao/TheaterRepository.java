

/**********************************************************************************************************************************
-File Name         :   Theater Repository Interface
-Author            :   Sanjeev Kumar Yaduwanshi
-Creation Date     :   23-09-2020
-Description       :   Repository interface used to connect to the database 
**********************************************************************************************************************************/
package com.cg.omtb.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.omtb.entity.TheaterEntity;

@Repository
public interface TheaterRepository extends JpaRepository<TheaterEntity, Integer>{
	 
	
	/**********************************************************************************************************************************
	 -Method Name       :   findByTheaterName
	 -Input Parameters  :   String theaterName
	 -Return Type       :	TheaterEntity
	 -Description       :   Method to get a instance TheaterEntity by theaterName
	 **********************************************************************************************************************************/
	
	/*
	 * public TheaterEntity findByTheaterName(String theaterName);
	 */

	/**********************************************************************************************************************************
	 -Method Name       :   findByTheaterId
	 -Input Parameters  :   int theaterId
	 -Return Type       :	TheaterEntity
	 -Description       :   Method to get a instance of TheaterEntity by theaterId
	 **********************************************************************************************************************************/

	public TheaterEntity findByTheaterId(int theaterId);
	
	
	/**********************************************************************************************************************************
	 -Method Name       :   findAllByTheaterCity
	 -Input Parameters  :   String theaterCity
	 -Return Type       :	List<TheaterEntity>
	 -Description       :   Method to get a List of TheaterEntity by theaterCity
	 **********************************************************************************************************************************/
	
	public List<TheaterEntity> findAllByTheaterCity(String theaterCity);

}
