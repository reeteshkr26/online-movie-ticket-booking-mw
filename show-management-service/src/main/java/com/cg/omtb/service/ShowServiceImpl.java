package com.cg.omtb.service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.omtb.dao.ShowRepository;
import com.cg.omtb.entity.ShowEntity;
import com.cg.omtb.exception.ShowException;
import com.cg.omtb.model.MovieModel;
import com.cg.omtb.model.ScreenModel;
import com.cg.omtb.model.ShowModel;
import com.cg.omtb.model.TheaterModel;

@Service
public class ShowServiceImpl implements ShowService {

	@Autowired
	private ShowRepository repo;
	@Autowired 
	private TheaterProxyService theaterProxyService;
	@Autowired 
	private MovieProxyService movieProxyService;
	@Autowired 
	private ScreenProxyService screenProxyService;
	
	@Override
	public ShowModel addShow(ShowModel show) throws ShowException {
		if(show==null) {
			throw new ShowException("Show should not be null !");
		}
		if(repo.existsById(show.getShowId())) {
			throw new ShowException("Show Alredy exist by this id");
		}
		if(repo.getShow(show.getTheaterId(), show.getStartTime())!=null) {
			throw new ShowException("Show Alredy exist in this theater at this time");
		}
		return of(repo.save(of(show)));
	}

	@Override
	public List<ShowModel> getAllShows() throws ShowException {
	
		return repo.findAll().stream().map(entity->of(entity)).collect(Collectors.toList());
	}

	@Override
	public void deleteShow(Integer id) throws ShowException {
		
		if(!repo.existsById(id)) {
			throw new ShowException("show does not exists");
		}
		
		repo.deleteById(id);
		
	}

	@Override
	public ShowModel findShow(Integer id) throws ShowException {
		ShowEntity show = repo.findById(id).orElse(null);
		if(show == null) {
			throw new ShowException("this showId doesnt exists");
		}
		return of(show);
	}

	@Override
	public List<ShowModel> findShowInTheater(Integer theaterId) throws ShowException {
		
		return repo.findByTheaterId(theaterId).stream().map(entity->of(entity)).collect(Collectors.toList());
	}

	@Override
	public ShowModel of(ShowEntity source) {
		ShowModel result=null;
		if(source!=null) {
			result=new ShowModel();
			result.setShowId(source.getShowId());
			result.setShowName(source.getShowName());
			result.setStartTime(source.getStartTime());
			result.setEndTime(source.getEndTime());
			MovieModel movie=movieProxyService.getMovie(source.getMovieId());
			if(movie!=null) {
				result.setMovieId(movie.getMovieId());
				result.setMovieName(movie.getMovieName());
			}
			TheaterModel theater=theaterProxyService.getTheatre(source.getTheaterId());
			if(theater!=null) {
				result.setTheaterId(theater.getTheaterId());
				result.setTheaterName(theater.getTheaterName());
			}
			ScreenModel screen=screenProxyService.getScreen(source.getScreenId());
			if(screen!=null) {
				result.setScreenId(screen.getScreenId());
				result.setScreenName(screen.getScreenName());
			}
		}
		return result;
	}

	@Override
	public ShowEntity of(ShowModel source) {
		ShowEntity result=null;
		if(source!=null) {
			result=new ShowEntity();
			result.setShowId(source.getShowId());
			result.setShowName(source.getShowName());
			result.setStartTime(source.getStartTime());
			result.setEndTime(source.getEndTime());
			result.setMovieId(source.getMovieId());
			result.setScreenId(source.getScreenId());
			result.setTheaterId(source.getTheaterId());
		}
		return result;
	}

	@Override
	public Integer generateShowId() {
		int m = (int) Math.pow(10, 5);
	    return (5000 + new Random().nextInt(9 * m));
	}
}
