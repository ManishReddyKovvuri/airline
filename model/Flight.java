package com.example.demo.model;


import java.sql.Time;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "flight")
public class Flight {
	
	@Id
	@Column(name= "id")
	private int id;
	
	@Column(name= "destination")
	private String destination;
	
	@Column(name= "duration")
	private String duration;
	
	@Column(name= "origin")
	private String origin;
	
	@Column(name= "flight_date")
	@Temporal(TemporalType.DATE)
	private Date flightDate;  
	
	@Column(name= "flight_number")
	private String flightNumber;
	
	@Column(name= "flight_time")
	private Time flightTime; 
	
	@OneToOne(cascade =CascadeType.ALL,fetch =FetchType.EAGER)
	@JoinColumn(name="inv_id", referencedColumnName = "inv_id")
	private Inventory inventory;
	
	@OneToOne(cascade =CascadeType.ALL,fetch =FetchType.EAGER)
	@JoinColumn(name="fare_id", referencedColumnName = "fare_id")
	private Fare fare;	
	
	@OneToOne(cascade =CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="flight_infoid",referencedColumnName = "flight_infoid")
	private FlightInfo flightInfo;
	
	public Inventory getInventory() {
		return inventory;
	}


	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}


	public Fare getFare() {
		return fare;
	}


	public void setFare(Fare fare) {
		this.fare = fare;
	}


	public FlightInfo getFlightInfo() {
		return flightInfo;
	}


	public void setFlightInfo(FlightInfo flightInfo) {
		this.flightInfo = flightInfo;
	}
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDestination() {
		return destination;
	}


	public void setDestination(String destination) {
		this.destination = destination;
	}


	public String getDuration() {
		return duration;
	}


	public void setDuration(String duration) {
		this.duration = duration;
	}


	public String getOrigin() {
		return origin;
	}


	public void setOrigin(String origin) {
		this.origin = origin;
	}


	public Date getFlightDate() {
		return flightDate;
	}


	public void setFlightDate(Date flightDate) {
		this.flightDate = flightDate;
	}


	public String getFlightNumber() {
		return flightNumber;
	}


	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}


	public Time getFlightTime() {
		return flightTime;
	}


	public void setFlightTime(Time flightTime) {
		this.flightTime = flightTime;
	}

	@Override
	public String toString() {
		return (id+"--"+ origin+"--"+ destination+"--"+duration+"--"+flightNumber+"-->"+flightDate+"<--"+flightInfo.getFlightId()
		+"--"+getFare().getFare()+"--"+flightTime.toString());
	}

	

}
