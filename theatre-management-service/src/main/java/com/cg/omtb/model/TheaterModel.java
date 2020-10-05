/**********************************************************************************************************************************
 -File Name         :   Theater Model
 -Author            :   Sanjeev Kumar Yaduwanshi
 -Creation Date     :   23-09-2020
 -Description       :   The model class of Theater
 **********************************************************************************************************************************/

package com.cg.omtb.model;

import javax.validation.constraints.NotBlank;

public class TheaterModel {

	private int theaterId;

	@NotBlank(message = "Theater Name is mandatory")
	private String theaterName;

	@NotBlank(message = "Theater City is mandatory")
	private String theaterCity;

	@NotBlank(message = "Manager Name is mandatory")
	private String managerName;

	@NotBlank(message = "Manager Contact is mandatory")
	private String managerContact;

	public TheaterModel(int theaterId, String theaterName, String theaterCity, String managerName,
			String managerContact) {
		super();
		this.theaterId = theaterId;
		this.theaterName = theaterName;
		this.theaterCity = theaterCity;
		this.managerName = managerName;
		this.managerContact = managerContact;
	}

	public TheaterModel() {
		// TODO Auto-generated constructor stub
	}

	public int getTheaterId() {
		return theaterId;
	}

	public void setTheaterId(int theaterId) {
		this.theaterId = theaterId;
	}

	public String getTheaterName() {
		return theaterName;
	}

	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}

	public String getManagerName() {
		return managerName;
	}

	public String getTheaterCity() {
		return theaterCity;
	}

	public void setTheaterCity(String theaterCity) {
		this.theaterCity = theaterCity;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerContact() {
		return managerContact;
	}

	public void setManagerContact(String managerContact) {
		this.managerContact = managerContact;
	}

}
