package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="airline_info")
public class AirlineInfo {

	@Id
	@Column(name="airline_id")
	private int airlineID;
	
	@Column(name="airline_logo")
	private String airlineLogo;
	
	@Column(name="name_of_airline")
	private String airlineName;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name="flights_info",
			inverseJoinColumns = {@JoinColumn(name="flight_infoid", referencedColumnName = "flight_infoid")},
	joinColumns = {@JoinColumn(name="airline_id",referencedColumnName = "airline_id")}
    )
	private List<FlightInfo> flightInfo;

//	public FlightInfo getFlightInfo() {
//		return flightInfo;
//	}
//
//	public void setFlightInfo(FlightInfo flightInfo) {
//		this.flightInfo = flightInfo;
//	}

	public int getAirlineID() {
		return airlineID;
	}

	public List<FlightInfo> getFlightInfo() {
		return flightInfo;
	}

	public void setFlightInfo(List<FlightInfo> flightInfo) {
		this.flightInfo = flightInfo;
	}

	public void setAirlineID(int airlineID) {
		this.airlineID = airlineID;
	}

	public String getAirlineLogo() {
		return airlineLogo;
	}

	public void setAirlineLogo(String airlineLogo) {
		this.airlineLogo = airlineLogo;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}
}
