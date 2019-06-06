/**
 * Jun 4, 2019	
 * food-order-system
 * com.foodordersystem.model
 */
package com.foodordersystem.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Tharaka Chandralal
 */
@Entity
@Table(name="TRANCEPORT")
public class Tranceport {

	private String tranceportID;
	private String whenLocation;
	private String whearLocation;
	private double avaragePrice;
	private String departmant;
	private Date date;
	private String time;
	private String status;
	private History history;
	
	public Tranceport() {
		
	}

	@Id
	@Column(name="PID",length=100,nullable=false)
	public String getTranceportID() {
		return tranceportID;
	}

	public void setTranceportID(String tranceportID) {
		this.tranceportID = tranceportID;
	}

	@Column(name="WHENL",length=100)
	public String getWhenLocation() {
		return whenLocation;
	}

	public void setWhenLocation(String whenLocation) {
		this.whenLocation = whenLocation;
	}

	@Column(name="WHERL",length=100)
	public String getWhearLocation() {
		return whearLocation;
	}

	public void setWhearLocation(String whearLocation) {
		this.whearLocation = whearLocation;
	}

	@Column(name="DEPN")
	public String getDepartmant() {
		return departmant;
	}
	
	public void setDepartmant(String departmant) {
		this.departmant = departmant;
	}

	

	@Column(name="DATE",length=50,nullable=false)
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name="TIME",length=50,nullable=false)
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Column(name="STATUS",length=10,nullable=false)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="HID")
	public History getHistory() {
		return history;
	}

	public void setHistory(History history) {
		this.history = history;
	}

	@Column(name="AVGP",nullable=true,length=20)
	public double getAvaragePrice() {
		return avaragePrice;
	}

	public void setAvaragePrice(double avaragePrice) {
		this.avaragePrice = avaragePrice;
	}

	
	
}
