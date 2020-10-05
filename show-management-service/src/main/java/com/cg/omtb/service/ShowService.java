package com.cg.omtb.service;

import java.util.List;

import com.cg.omtb.entity.ShowEntity;
import com.cg.omtb.exception.ShowException;
import com.cg.omtb.model.ShowModel;

public interface ShowService {
		
		ShowModel addShow(ShowModel show) throws ShowException;
		
		List<ShowModel> getAllShows() throws ShowException;
		
		void deleteShow(Integer id) throws ShowException;
		
		ShowModel findShow(Integer id) throws ShowException;

		List<ShowModel> findShowInTheater(Integer theaterId) throws ShowException;
		
		public ShowModel of(ShowEntity source);
		public ShowEntity of(ShowModel source);
		public Integer generateShowId();
}

