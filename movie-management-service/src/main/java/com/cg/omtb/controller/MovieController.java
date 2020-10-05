/**********************************************************************************************************************************
 -File Name         :   Movie Controller
 -Author            :   Reetesh Kumar Mandal
 -Creation Date     :   23-09-2020
 -Description       :   Controller to produce the Movie Management Service.
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

import com.cg.omtb.entity.MovieEntity;
import com.cg.omtb.exception.MovieException;
import com.cg.omtb.model.MovieModel;
import com.cg.omtb.service.MovieService;

@RestController
@RequestMapping("/api/movies")
@CrossOrigin
public class MovieController {

	@Autowired
	private MovieService movieService;

	
	/**********************************************************************************************************************************
	 -Method Name       :   createMovie
	 -Input Parameters  :   MovieModel model
	 -Return Type       :	ResponseEntity<MovieModel>
	 -Description       :   Method to add new Movie to movie_table.
	 **********************************************************************************************************************************/
	@PostMapping
	public ResponseEntity<MovieModel> createMovie(@Valid @RequestBody MovieModel movieModel) throws MovieException{
		MovieEntity movieEntity=movieService.of(movieModel);
		movieEntity.setMovieId(movieService.generateMovieId());
		movieModel=movieService.addMovie(movieEntity);
		if(movieModel!=null) {
			return new ResponseEntity<>(movieModel,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	/**********************************************************************************************************************************
	 -Method Name       :   findMovieById
	 -Input Parameters  :   Integer movieId
	 -Return Type       :	ResponseEntity<MovieModel>
	 -Description       :   Method to find movie from movie_table by movie id.
	 **********************************************************************************************************************************/
	@GetMapping("/{movieId}")
	public ResponseEntity<MovieModel> findhMovieById(@PathVariable("movieId") Integer movieId) throws MovieException {
		ResponseEntity<MovieModel> response = null;

		MovieModel movie = movieService.findMovieById(movieId);

		if (movie == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			response = new ResponseEntity<>(movie, HttpStatus.OK);
		}

		return response;
	}
	
	/**********************************************************************************************************************************
	 -Method Name       :   findMovieByName
	 -Input Parameters  :   String movieName
	 -Return Type       :	ResponseEntity<MovieModel>
	 -Description       :   Method to find movie from movie_table by movie name.
	 **********************************************************************************************************************************/
	@GetMapping("/movieName/{movieName}")
	public ResponseEntity<MovieModel> findMovieByName(@PathVariable("movieName") String movieName) throws MovieException {
		ResponseEntity<MovieModel> response = null;

		MovieModel movie = movieService.findMovie(movieName);

		if (movie == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			response = new ResponseEntity<>(movie, HttpStatus.OK);
		}

		return response;
	}
	
	/**********************************************************************************************************************************
	 -Method Name       :   getAllMovieList
	 -Input Parameters  :   void
	 -Return Type       :	ResponseEntity<List<MovieModel>>
	 -Description       :   Method to return all movie from movie_table.
	 **********************************************************************************************************************************/
	@GetMapping
	public ResponseEntity<List<MovieModel>> getAllMovieList()  {
		ResponseEntity<List<MovieModel>> response = null;

		List<MovieModel> movieList = movieService.getAllMovieList();

		if (movieList == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			response = new ResponseEntity<>(movieList, HttpStatus.OK);
		}

		return response;
	}
	
	/**********************************************************************************************************************************
	 -Method Name       :   deleteMovieById
	 -Input Parameters  :   Integer movieId
	 -Return Type       :	ResponseEntity<String>
	 -Description       :   Method to delete movie from movie_table by movie id.
	 **********************************************************************************************************************************/
	@DeleteMapping("/{movieId}")
	public ResponseEntity<?> deleteMovieById(@PathVariable("movieId") Integer movieId) throws MovieException {

		movieService.deleteMovie(movieId);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
