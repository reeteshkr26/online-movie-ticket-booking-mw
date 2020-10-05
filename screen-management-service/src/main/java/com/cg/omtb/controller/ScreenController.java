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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.omtb.exception.ScreenException;
import com.cg.omtb.model.ScreenModel;
import com.cg.omtb.service.ScreenService;

@RestController
@RequestMapping("/api/screens")
@CrossOrigin(origins="*")
public class ScreenController {
	
	@Autowired
	private ScreenService service;
	
	@PostMapping("/addScreen")
	public ResponseEntity<ScreenModel> addScreen(@Valid @RequestBody ScreenModel model) throws ScreenException{
			
			model.setScreenId(service.generateScreenId());
			model=service.addScreen(model);
			return new ResponseEntity<>(model,HttpStatus.OK);
		
	}
	
	@PutMapping("/updateScreen")
	public ResponseEntity<ScreenModel> updateScreen(@Valid @RequestBody ScreenModel screen) throws ScreenException{
	
			return new ResponseEntity<>(service.updateAvialbleSeats(screen),HttpStatus.OK);
		
	}
	@GetMapping
	public ResponseEntity<List<ScreenModel>> getAllScreenList()  {
		ResponseEntity<List<ScreenModel>> response = null;

		List<ScreenModel> screenList = service.getAllScreen();

		if (screenList == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			response = new ResponseEntity<>(screenList, HttpStatus.OK);
		}

		return response;
	}
	
	@GetMapping("/{screenId}")
	public ResponseEntity<ScreenModel> findScreenById(@PathVariable("screenId") Integer screenId) throws ScreenException {
		ResponseEntity<ScreenModel> response = null;

		ScreenModel screen = service.getScreenById(screenId);
		if (screen == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			response = new ResponseEntity<>(screen, HttpStatus.OK);
		}

		return response;
	}
	@GetMapping("/getByTheaterId/{theatreId}")
	public ResponseEntity<ScreenModel> findScreenByTheatreId(@PathVariable("theatreId") Integer theatreId) throws ScreenException {
		ResponseEntity<ScreenModel> response = null;

		ScreenModel screen = service.getScreenByTheatreId(theatreId);
		if (screen == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			response = new ResponseEntity<>(screen, HttpStatus.OK);
		}

		return response;
	}
	
	@DeleteMapping("/deleteByTheatreId/{theaterId}")
	public ResponseEntity<Boolean> deleteByTheaterId(@PathVariable("theaterId") Integer theaterId) throws ScreenException{
		
			service.deleteScreenByTheatreId(theaterId);;
			return new ResponseEntity<>(true,HttpStatus.OK);

	}
	@DeleteMapping("/deleteByScreenId/{screenId}")
	public ResponseEntity<Boolean> deleteTheater(@PathVariable("screenId") Integer screenId) throws ScreenException{
		
			service.deleteScreen(screenId);
			return new ResponseEntity<>(true,HttpStatus.OK);

	}

}
