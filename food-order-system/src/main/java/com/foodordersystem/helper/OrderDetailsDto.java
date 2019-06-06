/**
 * Jun 5, 2019	
 * food-order-system
 * com.foodordersystem.helper
 */
package com.foodordersystem.helper;


/**
 * @author Tharaka Chandralal
 */
public class OrderDetailsDto {

	private String orderDetailID;
	private Integer quntity;
	private FoodDto foodDto;
	private OrdersDto ordersDto;
	
	
	
	public OrderDetailsDto() {
		
	}


	public String getOrderDetailID() {
		return orderDetailID;
	}


	public void setOrderDetailID(String orderDetailID) {
		this.orderDetailID = orderDetailID;
	}


	public Integer getQuntity() {
		return quntity;
	}


	public void setQuntity(Integer quntity) {
		this.quntity = quntity;
	}


	public FoodDto getFoodDto() {
		return foodDto;
	}


	public void setFoodDto(FoodDto foodDto) {
		this.foodDto = foodDto;
	}


	public OrdersDto getOrdersDto() {
		return ordersDto;
	}


	public void setOrdersDto(OrdersDto ordersDto) {
		this.ordersDto = ordersDto;
	}


	
	


	
}
