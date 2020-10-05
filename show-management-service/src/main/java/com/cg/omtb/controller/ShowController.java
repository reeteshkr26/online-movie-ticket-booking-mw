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

import com.cg.omtb.exception.ShowException;
import com.cg.omtb.model.ShowModel;
import com.cg.omtb.service.ShowService;

@RestController
@RequestMapping("/api/shows")
@CrossOrigin(origins = "http://localhost:4200")
public class ShowController {

	@Autowired
	private ShowService showService;

	// this function add a show
	@PostMapping("/addShow")
	public ResponseEntity<ShowModel> addShow(@Valid @RequestBody ShowModel show) throws ShowException {
		
		show.setShowId(showService.generateShowId());
	
		System.out.println(show);
		show=showService.addShow(show);
		return new ResponseEntity<>(show, HttpStatus.CREATED);

	}

	// this function returns a show based on showId provided
	@GetMapping("/getshow/{showId}")
	public ResponseEntity<ShowModel> findShow(@PathVariable Integer showId) throws ShowException {

		return new ResponseEntity<>(showService.findShow(showId), HttpStatus.OK);
	}

	// this function returns all shows based on thaterId provided
	@GetMapping("/showsInTheater/{theaterId}")
	public ResponseEntity<List<ShowModel>> findShowsInTheater(@PathVariable Integer theaterId) throws ShowException {
		return new ResponseEntity<>(showService.findShowInTheater(theaterId), HttpStatus.OK);
	}

	// this function returns list of all shows
	@GetMapping
	public ResponseEntity<List<ShowModel>> getAllShows() throws ShowException {

		return new ResponseEntity<>(showService.getAllShows(), HttpStatus.OK);
	}
	
	//this function delete a show based on showId provided
	@DeleteMapping("/{showId}")
	public ResponseEntity<List<ShowModel>> deleteShow(@PathVariable Integer showId) throws ShowException {
		showService.deleteShow(showId);
	    return new ResponseEntity<>(showService.getAllShows(),HttpStatus.OK);
		
	}
}
