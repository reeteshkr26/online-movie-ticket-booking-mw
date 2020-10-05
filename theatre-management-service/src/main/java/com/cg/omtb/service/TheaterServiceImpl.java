/**********************************************************************************************************************************
 -File Name         :   TheatreServiceImpl
 -Author            :   Sanjeev Kumar Yaduwanshi
 -Creation Date     :   24-09-2020
 -Description       :   The implementation of the TheaterService class
 **********************************************************************************************************************************/

package com.cg.omtb.service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.omtb.entity.TheaterEntity;
import com.cg.omtb.exception.TheaterException;
import com.cg.omtb.model.TheaterModel;
import com.cg.omtb.dao.TheaterRepository;

@Service
public class TheaterServiceImpl implements TheaterService {

	@Autowired
	private TheaterRepository repo;
	
	
	/*
	 *	Conversion method to convert TheaterModel into TheaterEntity 
	 */

	@Override
	public TheaterEntity of(TheaterModel source) {

		TheaterEntity result = null;
		if (source != null) {
			result = new TheaterEntity();
			result.setTheaterId(source.getTheaterId());
			result.setTheaterName(source.getTheaterName());
			result.setTheaterCity(source.getTheaterCity());
			result.setManagerName(source.getManagerName());
			result.setManagerContact(source.getManagerContact());
		}
		return result;
	}

	
	/*
	 * Conversion method to convert TheaterEntity into TheaterModel
	 */
	
	@Override
	public TheaterModel of(TheaterEntity source) {

		TheaterModel result = null;
		if (source != null) {
			result = new TheaterModel();
			result.setTheaterId(source.getTheaterId());
			result.setTheaterName(source.getTheaterName());
			result.setTheaterCity(source.getTheaterCity());
			result.setManagerName(source.getManagerName());
			result.setManagerContact(source.getManagerContact());
		}
		return result;
	}

	
	/*
	 * PostMapping method to Insert an entry into the table
	 */
	
	@Override
	public TheaterModel addTheater(TheaterEntity theater) throws TheaterException {

		if (theater == null) {
			throw new TheaterException("Theater should not be null...");
		}

		if (repo.findByTheaterId(theater.getTheaterId()) != null) {
			throw new TheaterException("Theater already exists...");
		}
		return of(repo.save(theater));
	}

	
	/*
	 * DeleteMapping method to delete an entry from the table by its theaterId
	 */
	
	@Override
	public void deleteTheater(int theaterId) throws TheaterException {

		if (!repo.existsById(theaterId)) {
			throw new TheaterException("Theater does not exist...");
		}
		repo.deleteById(theaterId);

	}

	
	/*
	 * GetMapping method to search an entry from the table by its theaterId
	 */
	
	@Override
	public TheaterModel findTheater(int theaterId) throws TheaterException {

		TheaterModel model = of(repo.findByTheaterId(theaterId));
		if (model == null) {
			throw new TheaterException("Theater does not exist...");
		}

		return model;
	}
	
	
	
	@Override
	public List<TheaterModel> getAllTheatersList() {
		
		return repo.findAll().stream().map(theaterEntity -> of(theaterEntity)).collect(Collectors.toList());
	}

	
	/*
	 * GetMapping method to search list of theaters from the table by theaterCity
	 */
	
	@Override
	public List<TheaterModel> getTheatersByCity(String theaterCity) throws TheaterException {
		List<TheaterModel> modelList=null;
		List<TheaterEntity> entityList=repo.findAllByTheaterCity(theaterCity);
		if(entityList==null)
		{
			throw new TheaterException("No Theater Present...");
		}
		else {
			modelList=entityList.stream().map(theaterEntity -> of(theaterEntity)).collect(Collectors.toList());
		}
		return modelList; 
	}
	
	
	/*
	 * Method to Auto generate Theater Id starting with 2 and of 4 digits only
	 */

	@Override
	public Integer generateTheaterId() {
		int m = (int) Math.pow(10, 2);
	    return (2000 + new Random().nextInt(9 * m));	
	}


	
	
	

}
