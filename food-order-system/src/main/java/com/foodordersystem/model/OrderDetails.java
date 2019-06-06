/**
 * Jun 4, 2019	
 * food-order-system
 * com.foodordersystem.model
 */
package com.foodordersystem.model;

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
@Table(name="ORDERDETAILS")
public class OrderDetails {
	
	
	private String orderDetailID;
	private Integer quntity;
	private Food food;
	private Orders orders;
	private String status;
	
	public OrderDetails() {

	}

	@Id
	@Column(name="PID",nullable=false,length=100)
	public String getOrderDetailID() {
		return orderDetailID;
	}

	public void setOrderDetailID(String orderDetailID) {
		this.orderDetailID = orderDetailID;
	}

	@Column(name="QTY",nullable=false,length=100)
	public Integer getQuntity() {
		return quntity;
	}

	public void setQuntity(Integer quntity) {
		this.quntity = quntity;
	}

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="FID")
	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="OID",nullable=false)
	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	@Column(name="STATUS",length=10)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
