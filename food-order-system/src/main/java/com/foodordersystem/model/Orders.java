/**
 * Jun 4, 2019	
 * food-order-system
 * com.foodordersystem.model
 */
package com.foodordersystem.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Tharaka Chandralal
 */
@Entity
@Table(name="ORDERS")
public class Orders {
	
	  private String orderID;
	  private Date date;
	  private String orderSenderName;
	  private String department;
	  private List<OrderDetails>orderDetails;
	  private String status;
	  private History history;
	  
	public Orders() {
		
	}

	@Id
	@Column(name="PID",nullable=false,length=100)
	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	
	@Column(name="ODATE",nullable=false,length=50)
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	
	@Column(name="OSEDR",length=100,nullable=false)
	public String getOrderSenderName() {
		return orderSenderName;
	}

	public void setOrderSenderName(String orderSenderName) {
		this.orderSenderName = orderSenderName;
	}

	@Column(name="DEPMT",length=20,nullable=false)
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@OneToMany(mappedBy="orders",targetEntity=OrderDetails.class)
	public List<OrderDetails> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}

	@Column(name="STATUS",length=10)
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
	
	
	
	
	  
}
