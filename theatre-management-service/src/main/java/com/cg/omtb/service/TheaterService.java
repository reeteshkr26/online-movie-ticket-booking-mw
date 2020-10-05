/**********************************************************************************************************************************
 -File Name         :   Theater Service Interface
 -Author            :   Sanjeev Kumar Yaduwanshi
 -Creation Date     :   24-09-2020
 -Description       :   The Theater Service interface for Theater Services
 **********************************************************************************************************************************/


package com.cg.omtb.service;

import java.util.List;

import com.cg.omtb.entity.TheaterEntity;
import com.cg.omtb.exception.TheaterException;
import com.cg.omtb.model.TheaterModel;

public interface TheaterService {
	
	/****************************************************************************************************************************
	 - Method Name      : addTheatre
	 - Input Parameters : TheaterEntity entity
	 - Return type      : TheatreModel
	 - Description      : Add a Theater
	 * @throws TheaterException("Theater already exists").
	  ****************************************************************************************************************************/ 
	
	public TheaterModel addTheater(TheaterEntity entity) throws TheaterException;

	/****************************************************************************************************************************
	 - Method Name      : deleteTheatre
	 - Input Parameters : int theaterId
	 - Return type      : void
	 - Description      : Delete a specific Theater
	 * @throws TheaterException("Theater does not exists").
	  ****************************************************************************************************************************/ 
	
	public void deleteTheater(int theaterId) throws TheaterException;

	/****************************************************************************************************************************
	 - Method Name      : findTheatre
	 - Input Parameters : int theaterId
	 - Return type      : TheaterModel
	 - Description      : finds a specific Theater.
	 * @throws TheaterException("Theater does not exists").
	  ****************************************************************************************************************************/ 
	
	public TheaterModel findTheater(int theaterId) throws TheaterException;
	
	/****************************************************************************************************************************
	 - Method Name      : of
	 - Input Parameters : TheaterModel source
	 - Return type      : TheaterEntity
	 - Description      : convert TheaterModel to TheaterEntity.
	  ****************************************************************************************************************************/ 
	
	public TheaterEntity of(TheaterModel source);
	
	/****************************************************************************************************************************
	 - Method Name      : of
	 - Input Parameters : TheaterEntity source
	 - Return type      : void
	 - Description      : convert TheaterEntity to TheaterModel
	  ****************************************************************************************************************************/ 
	
	public TheaterModel of(TheaterEntity source);
	
	public List<TheaterModel> getAllTheatersList();
	
	public List<TheaterModel> getTheatersByCity(String theaterCity) throws TheaterException;
	
	public Integer generateTheaterId();

}
