/**********************************************************************************************************************************
 -File Name         :   Movie Repository Interface
 -Author            :   Reetesh Kumar Mandal
 -Creation Date     :   23-09-2020
 -Description       :   Repository interface used to connect to the database 
 **********************************************************************************************************************************/
package com.cg.omtb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.omtb.entity.MovieEntity;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Integer>{

	/**********************************************************************************************************************************
	 -Method Name       :   findByMovieName
	 -Input Parameters  :   String movieName
	 -Return Type       :	MovieEntity
	 -Description       :   Method to get a instance MovieEntity by movieName
	 **********************************************************************************************************************************/
	public MovieEntity findByMovieName(String movieName);
	
	
	/**********************************************************************************************************************************
	 -Method Name       :   findByMovieId
	 -Input Parameters  :   Integer movieId
	 -Return Type       :	MovieEntity
	 -Description       :   Method to get a instance MovieEntity by movieId
	 **********************************************************************************************************************************/
	public MovieEntity findByMovieId(Integer movieId);
}
