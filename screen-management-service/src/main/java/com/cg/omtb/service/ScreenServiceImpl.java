package com.cg.omtb.service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.omtb.dao.ScreenRepository;
import com.cg.omtb.entity.ScreenEntity;
import com.cg.omtb.exception.ScreenException;
import com.cg.omtb.model.ScreenModel;
import com.cg.omtb.model.TheaterModel;

@Service
public class ScreenServiceImpl implements ScreenService{

	@Autowired
	private ScreenRepository screenRepo;
	
	@Autowired
	private TheaterProxyService theaterProxy;
	
	@Override
	public ScreenModel addScreen(ScreenModel screen) throws ScreenException {
		if(screen==null) {
			throw new ScreenException("Screen Object Should not be null");
		}
		if(screenRepo.existsById(screen.getScreenId()) ){
			throw new ScreenException("Screen already exist");
		}
		if(screenRepo.findByTheaterId(screen.getTheaterId())!=null){
			throw new ScreenException("Screen already exist in this theatre !");
		}
		return of(screenRepo.save(of(screen)));
		
	}

	@Override
	public List<ScreenModel> getAllScreen() {
		
		return screenRepo.findAll().stream().map(entity->of(entity)).collect(Collectors.toList());
	}

	@Override
	public ScreenModel getScreenById(Integer screenId) throws ScreenException{
		
		if(screenRepo.findById(screenId).isPresent()) {
			return of(screenRepo.findById(screenId).get());
		}
		else {
			throw new ScreenException("Screen does not exist..!");
		}
		
	}

	@Override
	public ScreenModel updateAvialbleSeats(ScreenModel screen) throws ScreenException {
		if(screen!=null) {
			ScreenModel oldscreen=of(screenRepo.findById(screen.getScreenId()).orElse(null));
			if(oldscreen==null) {
				throw new ScreenException("There does not exists a screen with the given ID");
			}
			else {
				screen=of(screenRepo.save(of(screen)));

			}
		}
		return screen;
	}

	@Override
	public ScreenModel getScreenByTheatreId(Integer theatreId) throws ScreenException {
		ScreenModel screen=of(screenRepo.findByTheaterId(theatreId));
		if(screen==null) {
			throw new ScreenException("Screen does not exist..!");
		}
		return screen;
	}

	@Override
	public void deleteScreen(Integer screenId) throws ScreenException {
		if(!screenRepo.existsById(screenId)) {
			throw new ScreenException("Screen does not exist..!");
		}
		screenRepo.deleteById(screenId);
		
	}

	@Override
	public void deleteScreenByTheatreId(Integer theatreId) throws ScreenException {

		if(screenRepo.findByTheaterId(theatreId)==null) {
			throw new ScreenException("Screen does not exist..!");
		}
		screenRepo.delete(screenRepo.findByTheaterId(theatreId));
		
	}

	@Override
	public ScreenModel of(ScreenEntity source) {
		ScreenModel result=null;
		if(source!=null) {
			result=new ScreenModel();
			result.setScreenId(source.getScreenId());
			result.setScreenName(source.getScreenName());
			result.setCity(source.getCity());
			result.setAvailableSeats(source.getAvailableSeats());
			result.setTotalSeats(source.getTotalSeats());
			TheaterModel model=theaterProxy.getTheatre(source.getTheaterId());
			if(model!=null) {
				result.setTheaterName(model.getTheaterName());
				result.setTheaterId(model.getTheaterId());
			}
		}
		return result;
	}

	@Override
	public ScreenEntity of(ScreenModel source) {
		ScreenEntity result=null;
		if(source!=null) {
			result=new ScreenEntity();
			result.setScreenId(source.getScreenId());
			result.setScreenName(source.getScreenName());
			result.setCity(source.getCity());
			result.setAvailableSeats(source.getAvailableSeats());
			result.setTotalSeats(source.getTotalSeats());
			result.setTheaterId(source.getTheaterId());
		}
		return result;
	}
	
	@Override
	public Integer generateScreenId() {
		int m = (int) Math.pow(10, 4);
	    return (4000 + new Random().nextInt(9 * m));
	}

}
