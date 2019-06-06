/**
 * Jun 4, 2019	
 * food-order-system
 * com.foodordersystem.helper
 */
package com.foodordersystem.helper;


/**
 * @author Tharaka Chandralal
 */
public class FoodDto {

	private String foodID;
	private String foodName;
	
	public FoodDto() {
	
	}

	public String getFoodID() {
		return foodID;
	}

	public void setFoodID(String foodID) {
		this.foodID = foodID;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

}
