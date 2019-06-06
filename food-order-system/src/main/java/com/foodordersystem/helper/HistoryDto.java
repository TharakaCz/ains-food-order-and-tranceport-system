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
public class HistoryDto {

	private String historyID;
	private Date date;
	private String time;
	private String departmentName;
	private String historyType;
	
	
	public HistoryDto() {
		
	}

	public String getHistoryID() {
		return historyID;
	}

	public void setHistoryID(String historyID) {
		this.historyID = historyID;
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

	public String getHistoryType() {
		return historyType;
	}

	public void setHistoryType(String historyType) {
		this.historyType = historyType;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	
}
