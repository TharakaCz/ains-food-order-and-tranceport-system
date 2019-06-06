/**
 * Jun 5, 2019	
 * food-order-system
 * com.foodordersystem.helper
 */
package com.foodordersystem.helper;

import java.util.Date;


/**
 * @author Tharaka Chandralal
 */
public class TranceportDto {

	private String tranceportID;
	private String whenLocation;
	private String whearLocation;
	private double avaragePrice;
	private String departmant;
	private Date date;
	private String time;
	private HistoryDto historyDto;
	
	
	public TranceportDto() {
		
	}

	public String getTranceportID() {
		return tranceportID;
	}

	public void setTranceportID(String tranceportID) {
		this.tranceportID = tranceportID;
	}

	public String getWhenLocation() {
		return whenLocation;
	}

	public void setWhenLocation(String whenLocation) {
		this.whenLocation = whenLocation;
	}

	public String getWhearLocation() {
		return whearLocation;
	}

	public void setWhearLocation(String whearLocation) {
		this.whearLocation = whearLocation;
	}

	public String getDepartmant() {
		return departmant;
	}

	public void setDepartmant(String departmant) {
		this.departmant = departmant;
	}



	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public HistoryDto getHistoryDto() {
		return historyDto;
	}

	public void setHistoryDto(HistoryDto historyDto) {
		this.historyDto = historyDto;
	}

	public double getAvaragePrice() {
		return avaragePrice;
	}

	public void setAvaragePrice(double avaragePrice) {
		this.avaragePrice = avaragePrice;
	}


	
}
