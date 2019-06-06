/**
 * Jun 5, 2019	
 * food-order-system
 * com.foodordersystem.helper
 */
package com.foodordersystem.helper;

import java.util.Date;
import java.util.List;

/**
 * @author Tharaka Chandralal
 */
public class OrdersDto {

	  private String orderID;
	  private Date date;
	  private String orderSenderName;
	  private String department;
	  private List<OrderDetailsDto>orderDetailsDtos;
	  private HistoryDto historyDto;
	  
	public OrdersDto() {
		
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getOrderSenderName() {
		return orderSenderName;
	}

	public void setOrderSenderName(String orderSenderName) {
		this.orderSenderName = orderSenderName;
	}


	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public List<OrderDetailsDto> getOrderDetailsDtos() {
		return orderDetailsDtos;
	}

	public void setOrderDetailsDtos(List<OrderDetailsDto> orderDetailsDtos) {
		this.orderDetailsDtos = orderDetailsDtos;
	}

	public HistoryDto getHistoryDto() {
		return historyDto;
	}

	public void setHistoryDto(HistoryDto historyDto) {
		this.historyDto = historyDto;
	}
	  
	  
}
