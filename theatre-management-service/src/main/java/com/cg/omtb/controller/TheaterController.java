/**********************************************************************************************************************************
 -File Name         :   Theater Controller
 -Author            :   Sanjeev Kumar Yaduwanshi
 -Creation Date     :   24-09-2020
 -Description       :   Controller to produce the Theater Management Service.
 **********************************************************************************************************************************/


package com.cg.omtb.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.omtb.entity.TheaterEntity;
import com.cg.omtb.exception.TheaterException;
import com.cg.omtb.model.TheaterModel;
import com.cg.omtb.service.TheaterService;

@RestController
@RequestMapping("/api/theaters")
@CrossOrigin(origins="*")
public class TheaterController {
	
	@Autowired
	public TheaterService service;
	
	
	/**********************************************************************************************************************************
	 -Method Name       :   addTheater
	 -Input Parameters  :   TheaterModel model
	 -Return Type       :	ResponseEntity<TheaterModel>
	 -Description       :   Method to add new Theater to theater_table.
	 **********************************************************************************************************************************/
	
	@PostMapping("/addTheater")
	public ResponseEntity<TheaterModel> addTheater(@Valid @RequestBody TheaterModel model) throws TheaterException{
		
		TheaterEntity theaterEntity=service.of(model);
		
		theaterEntity.setTheaterId(service.generateTheaterId());

		model=service.addTheater(theaterEntity);
		
		return new ResponseEntity<>(model,HttpStatus.OK);
		
	}
	
	/**********************************************************************************************************************************
	 -Method Name       :   deleteTheater
	 -Input Parameters  :   Integer theaterId
	 -Return Type       :	ResponseEntity<String>
	 -Description       :   Method to delete specific Theater from theater_table.
	 **********************************************************************************************************************************/
	
	@DeleteMapping("/{theaterId}")
	public ResponseEntity<Boolean> deleteTheater(@PathVariable("theaterId") Integer theaterId) throws TheaterException{
		
			service.deleteTheater(theaterId);
			return new ResponseEntity<>(true,HttpStatus.OK);
//			return new ResponseEntity<>("Theater deleted Successfully...", HttpStatus.OK);
	}
	
	/**********************************************************************************************************************************
	 -Method Name       :   findTheaterById
	 -Input Parameters  :   Integer theaterId
	 -Return Type       :	ResponseEntity<TheaterModel>
	 -Description       :   Method to find Theater by theaterId from theater_table.
	 **********************************************************************************************************************************/
	
	@GetMapping("/{theaterId}")
	public ResponseEntity<TheaterModel> findTheaterById(@PathVariable("theaterId") Integer theaterId) throws TheaterException{
		
		    TheaterModel model=service.findTheater(theaterId);
		
		    return new ResponseEntity<>(model,HttpStatus.OK);
	}
	
	
	@GetMapping
	public ResponseEntity<List<TheaterModel>> findAllTheaters() {
		
		ResponseEntity<List<TheaterModel>> response=null;
		
		List<TheaterModel> theaterList= service.getAllTheatersList();
		if (theaterList == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			response = new ResponseEntity<>(theaterList, HttpStatus.OK);
		}

		return response;
	}
	
	@GetMapping("/city/{theaterCity}")
	public ResponseEntity<List<TheaterModel>> findTheatersByTheaterCity(@PathVariable("theaterCity") String theaterCity) throws TheaterException{
		List<TheaterModel> model= service.getTheatersByCity(theaterCity);
		
		return new ResponseEntity<>(model,HttpStatus.OK);
	}
	
	
}
