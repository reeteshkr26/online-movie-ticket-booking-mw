package com.cg.omtb.service;

import java.util.List;

import com.cg.omtb.entity.ScreenEntity;
import com.cg.omtb.exception.ScreenException;
import com.cg.omtb.model.ScreenModel;

public interface ScreenService {
	
	public ScreenModel addScreen(ScreenModel screen) throws ScreenException;
	public List<ScreenModel> getAllScreen();
	public ScreenModel getScreenById(Integer screenId) throws ScreenException;
	public ScreenModel updateAvialbleSeats(ScreenModel screen) throws ScreenException;
	public ScreenModel getScreenByTheatreId(Integer theatreId) throws ScreenException;
	public void deleteScreen(Integer screenId) throws ScreenException;
	public void deleteScreenByTheatreId(Integer theatreId) throws ScreenException;
	
	public ScreenModel of(ScreenEntity source);
	public ScreenEntity of(ScreenModel source);
	public Integer generateScreenId();

}
