/**
 * Jun 4, 2019	
 * food-order-system
 * com.foodordersystem.model
 */
package com.foodordersystem.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Tharaka Chandralal
 */
@Entity
@Table(name="HISTORY")
public class History {
	
	private String historyID;
	private Date date;
	private String time;
	private String status;
	private String historyType;
	private List<Tranceport>tranceports;
	private List<Orders>orders;
	
	public History() {
		
	}

	@Id
	@Column(name="PID",nullable=false,length=100)
	public String getHistoryID() {
		return historyID;
	}

	public void setHistoryID(String historyID) {
		this.historyID = historyID;
	}

	@Column(name="HDATE",nullable=false,length=50)
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	
	
	@Column(name="HTIME")
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

	@Column(name="HTYPE",length=50)
	public String getHistoryType() {
		return historyType;
	}

	public void setHistoryType(String historyType) {
		this.historyType = historyType;
	}

	@OneToMany(mappedBy="history",targetEntity=Tranceport.class)
	public List<Tranceport> getTranceports() {
		return tranceports;
	}

	public void setTranceports(List<Tranceport> tranceports) {
		this.tranceports = tranceports;
	}

	@OneToMany(mappedBy="history",targetEntity=Orders.class)
	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
	
	
}
