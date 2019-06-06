/**
 * Jun 4, 2019	
 * food-order-system
 * com.foodordersystem.model
 */
package com.foodordersystem.model;

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
@Table(name="FOOD")
public class Food {
	
	private String foodID;
	private String foodName;
	private String status;
	private List<OrderDetails>orderDetails;
	
	public Food() {
	}

	@Id
	@Column(name="PID",nullable=false,length=100)
	public String getFoodID() {
		return foodID;
	}

	public void setFoodID(String foodID) {
		this.foodID = foodID;
	}

	@Column(name="FNAME",nullable=false,length=255)
	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	@Column(name="STATUS",nullable=false,length=10)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@OneToMany(mappedBy="food",targetEntity=OrderDetails.class)
	public List<OrderDetails> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}

	
}
