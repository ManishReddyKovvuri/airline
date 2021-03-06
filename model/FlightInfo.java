package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name= "flight_info")
public class FlightInfo {

	
	@Id
	@Column(name ="flight_infoid")
	private int flightInfoId;

	@Column(name = "flight_number")
	private String flightNumber;
	
	@Column(name ="flight_type")
	private String flightType;
	
	@Column(name ="numberof_seats")
	private int seatCapacity;
	
//	@OneToOne(mappedBy = "flightInfo")   //seat_capacity
////	@MapsId
//	private Flight flight;
	
	
	/*
	 *  @JoinTable(name = " ", 
      joinColumns = 
        { @JoinColumn(name = "employee_id", referencedColumnName = "id") },
      inverseJoinColumns = 
        { @JoinColumn(name = "workstation_id", referencedColumnName = "id") })
	 */
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name="flights_info",
				joinColumns = {@JoinColumn(name="flight_infoid", referencedColumnName = "flight_infoid")},
				inverseJoinColumns = {@JoinColumn(name="airline_id",referencedColumnName = "airline_id")}
			    )	
	private AirlineInfo airlineInfo;
	
	
 
	
	
	
	public AirlineInfo getAirlineInfo() {
		return airlineInfo;
	}
	public void setAirlineInfo(AirlineInfo airlineInfo) {
		this.airlineInfo = airlineInfo;
	}
//	public Flight getFlight() {
//		return flight;
//	}
//	public void setFlight(Flight flight) {
//		this.flight = flight;
//	}
	public int getFlightId() {
		return flightInfoId;
	}
	public void setFlightId(int flightInfoId) {
		this.flightInfoId = flightInfoId;
	}
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public int getFlightInfoId() {
		return flightInfoId;
	}
	public void setFlightInfoId(int flightInfoId) {
		this.flightInfoId = flightInfoId;
	}
	public String getFlightType() {
		return flightType;
	}
	public void setFlightType(String flightType) {
		this.flightType = flightType;
	}
	public int getSeatCapacity() {
		return seatCapacity;
	}
	public void setSeatCapacity(int numberOfSeats) {
		this.seatCapacity = numberOfSeats;
	}

	
}
