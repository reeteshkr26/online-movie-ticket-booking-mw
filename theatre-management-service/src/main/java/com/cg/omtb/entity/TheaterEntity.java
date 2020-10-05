/**********************************************************************************************************************************
 -File Name         :   Theater Entity
 -Author            :   Sanjeev Kumar Yaduwanshi
 -Creation Date     :   23-09-2020
 -Description       :   Entity class used to create the table instance of object Theater
 **********************************************************************************************************************************/


package com.cg.omtb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="theater_table")
public class TheaterEntity {
	
	@Id
	@Column(name="theater_id")
	private int theaterId;
	
	@Column(name="theater_name",nullable=false)
	@NotBlank(message = "Theater Name is mandatory")
	private String theaterName;
	
	@Column(name="theater_city",nullable=false)
	@NotBlank(message = "Theater City is mandatory")
	private String theaterCity;
	
	@Column(name="manager_name",nullable=false)
	@NotBlank(message = "Manager Name is mandatory")
	private String managerName;
	
	@Column(name="manager_contact",nullable=false)
	@NotBlank(message = "Manager Contact is mandatory")
	private String managerContact;

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

	public TheaterEntity() {
	}

	public TheaterEntity(int theaterId, String theaterName, String theaterCity, String managerName,
			String managerContact) {
		super();
		this.theaterId = theaterId;
		this.theaterName = theaterName;
		this.theaterCity = theaterCity;
		this.managerName = managerName;
		this.managerContact = managerContact;
	}

	@Override
	public String toString() {
		return "TheaterEntity [theaterId=" + theaterId + ", theaterName=" + theaterName + ", theaterCity=" + theaterCity
				+ ", managerName=" + managerName + ", managerContact=" + managerContact + "]";
	}
	
	

}

