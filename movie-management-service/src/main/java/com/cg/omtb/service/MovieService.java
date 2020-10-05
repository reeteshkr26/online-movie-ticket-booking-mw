/**********************************************************************************************************************************
 -File Name         :   Movie Service
 -Author            :   Reetesh Kumar Mandal
 -Creation Date     :   23-09-2020
 -Description       :   Service interface here declare all methods of service implementation class
 **********************************************************************************************************************************/
package com.cg.omtb.service;

import java.util.List;

import com.cg.omtb.entity.MovieEntity;
import com.cg.omtb.exception.MovieException;
import com.cg.omtb.model.MovieModel;

public interface MovieService {

	
	public MovieModel addMovie(MovieEntity movie)throws MovieException;
	public MovieModel findMovie(String movieName) throws MovieException;
	public MovieModel findMovieById(Integer movieId) throws MovieException;
	public void deleteMovie(Integer movieId) throws MovieException;
	public List<MovieModel> getAllMovieList();
	
	public MovieEntity of(MovieModel source);
	public MovieModel of(MovieEntity source);
	public Integer generateMovieId();
}
