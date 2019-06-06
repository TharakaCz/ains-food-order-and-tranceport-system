/**
 * Jun 4, 2019	
 * food-order-system
 * com.foodordersystem.dao
 */
package com.foodordersystem.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.foodordersystem.model.Food;

/**
 * @author Tharaka Chandralal
 */
public interface FoodDao extends CrudRepository<Food, String>{

	Food findOneByFoodID(String foodID);
	List<Food> findAllByStatus(String status)throws Exception;
}
