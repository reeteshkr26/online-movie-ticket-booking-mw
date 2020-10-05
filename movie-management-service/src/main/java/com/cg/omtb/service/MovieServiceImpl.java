
/**********************************************************************************************************************************
 -File Name         :   MovieServiceImpl.Class
 -Author            :   Reetesh Kumar Mandal
 -Creation Date     :   23-09-2020
 -Description       :   The implementation of the MovieService interface and to write business logic in this class
 **********************************************************************************************************************************/
package com.cg.omtb.service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.omtb.dao.MovieRepository;
import com.cg.omtb.entity.MovieEntity;
import com.cg.omtb.exception.MovieException;
import com.cg.omtb.model.MovieModel;

@Service
public class MovieServiceImpl implements MovieService{

	@Autowired
	private MovieRepository movieRepo;
	
	/*
	 *convert MovieModel into MovieEntity*
	 */
	@Override
	public MovieEntity of(MovieModel source) {
		
		MovieEntity result=null;
		if(source!=null) {
			result=new MovieEntity();
			result.setMovieId(source.getMovieId());
			result.setMovieName(source.getMovieName());
			result.setMovieDirector(source.getMovieDirector());
			result.setReleasedDate(source.getReleasedDate());
			result.setMovieLanguage(source.getMovieLanguage());
			result.setMovieLength(source.getMovieLength());
			result.setMovieRating(source.getMovieRating());
			result.setMovieActor(source.getMovieActor());
			result.setMovieActress(source.getMovieActress());
			result.setMovieType(source.getMovieType());
			
		}
		return result;
	}
	
	/*
	 * convert MovieEntity into MovieModel
	 */
	@Override
	public MovieModel of(MovieEntity source) {
		
		MovieModel result=null;
		if(source!=null) {
			result=new MovieModel();
			result.setMovieId(source.getMovieId());
			result.setMovieName(source.getMovieName());
			result.setMovieDirector(source.getMovieDirector());
			result.setReleasedDate(source.getReleasedDate());
			result.setMovieLanguage(source.getMovieLanguage());
			result.setMovieLength(source.getMovieLength());
			result.setMovieRating(source.getMovieRating());
			result.setMovieActor(source.getMovieActor());
			result.setMovieActress(source.getMovieActress());
			result.setMovieType(source.getMovieType());
			
		}
		return result;
	}
	
	/*
	 * To save movie into database table(movie_table)
	 */
	@Override
	public MovieModel addMovie(MovieEntity movie) throws MovieException{
	
		if(movie==null) {
			throw new MovieException("Movie Should not be null");
		}
		if(movieRepo.findByMovieName(movie.getMovieName())!=null){
			throw new MovieException("This Movie already exist");
		}
		return of(movieRepo.save(movie));
	}
	
	/*
	 * To find movie from database table by Movie Name and return Movie
	 */
	@Override
	public MovieModel findMovie(String movieName) throws MovieException{
		if(movieName==null) {
			throw new MovieException("Movie name should not be empty");
		}
		MovieEntity entity=movieRepo.findByMovieName(movieName);
		if(entity==null) {
			throw new MovieException("Movie Not found");	
		}
		return of(entity);
	}
	
	/*
	 * To delete movie from database table by Movie Id
	 */
	@Override
	public void deleteMovie(Integer movieId) throws MovieException{
		if(movieId==null) {
			throw new MovieException("Movie id should not be null");
		}
		if(!movieRepo.existsById(movieId)) {
			throw new MovieException("Movie Id is not exist!");
		}
		movieRepo.deleteById(movieId);
	}
	
	/*
	 * To find movie from database table by Movie Id and return Movie
	 */
	@Override
	public MovieModel findMovieById(Integer movieId) throws MovieException {
		if(movieId==null) {
			throw new MovieException("Movie id should not be null");
		}
		MovieEntity entity=movieRepo.findByMovieId(movieId);
		if(entity==null) {
			throw new MovieException("Movie Not found");	
		}
		return of(entity);
		
	}

	/*
	 * To find all movie and return list of movie
	 */
	@Override
	public List<MovieModel> getAllMovieList() {
		
		return movieRepo.findAll().stream().map(entity->of(entity)).collect(Collectors.toList());
	}

	/*
	 * To generate random id for movie id
	 */
	@Override
	public Integer generateMovieId() {
	
			int m = (int) Math.pow(10, 4-1);
		    return (3000 + new Random().nextInt(9 * m));	
	
	}

	
	

}
