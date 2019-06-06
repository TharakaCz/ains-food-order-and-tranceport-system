/**
 * Jun 4, 2019	
 * food-order-system
 * com.foodordersystem.service
 */
package com.foodordersystem.service;

import java.util.List;

import com.foodordersystem.helper.FoodDto;

/**
 * @author Tharaka Chandralal
 */
public interface FoodService {

	public String saveFood(FoodDto foodDto)throws Exception;
	
	public String deleteFood(String foodID)throws Exception;
	
	public String updateFood(FoodDto foodDto)throws Exception;
	
	public FoodDto searchFood(String foodID)throws Exception;
	
	List<FoodDto>getAllFood()throws Exception;
}
