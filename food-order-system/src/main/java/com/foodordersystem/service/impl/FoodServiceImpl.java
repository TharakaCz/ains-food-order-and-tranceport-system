/**
 * Jun 4, 2019	
 * food-order-system
 * com.foodordersystem.service.impl
 */
package com.foodordersystem.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodordersystem.dao.FoodDao;
import com.foodordersystem.helper.FoodDto;
import com.foodordersystem.model.Food;
import com.foodordersystem.service.FoodService;
import com.foodordersystem.utill.AppConstent;

/**
 * @author Tharaka Chandralal
 */
@Service
public class FoodServiceImpl implements FoodService{

	@Autowired
	private FoodDao foodDao;

	/* (non-Javadoc)
	 * @see com.foodordersystem.service.FoodService#saveFood(com.foodordersystem.helper.FoodDto)
	 */
	@Override
	public String saveFood(FoodDto foodDto) throws Exception {
		
		Food food = new Food();
		
		food.setFoodID(UUID.randomUUID().toString());
		food.setFoodName(foodDto.getFoodName());
		
		food.setStatus(AppConstent.ACTIVE);
		foodDao.save(food);
		
		return "Food Added Succsess";
	}

	/* (non-Javadoc)
	 * @see com.foodordersystem.service.FoodService#deleteFood(java.lang.String)
	 */
	@Override
	public String deleteFood(String foodID) throws Exception {
		
		Food food = foodDao.findOneByFoodID(foodID);
		
		if (food !=null) {
			food.setStatus(AppConstent.DEACTIVE);
			foodDao.save(food);
			return "Food Succsessfuly Deleted . . !";
		}else {
			return "Food Is Not Found Try Again . . !";
		}
		
	}

	/* (non-Javadoc)
	 * @see com.foodordersystem.service.FoodService#updateFood(com.foodordersystem.helper.FoodDto)
	 */
	@Override
	public String updateFood(FoodDto foodDto) throws Exception {
		
		Food food = foodDao.findOneByFoodID(foodDto.getFoodID());
		
		food.setFoodName(foodDto.getFoodName());
		food.setStatus(AppConstent.ACTIVE);
		
		foodDao.save(food);
		return "Food Succsessfully Updated . . !";
	}

	/* (non-Javadoc)
	 * @see com.foodordersystem.service.FoodService#searchFood(java.lang.String)
	 */
	@Override
	public FoodDto searchFood(String foodID) throws Exception {
		
		Food food = foodDao.findOneByFoodID(foodID);
		FoodDto foodDto = getFoods(food);
		
		return foodDto;
	}

	/* (non-Javadoc)
	 * @see com.foodordersystem.service.FoodService#getAllFood()
	 */
	@Override
	public List<FoodDto> getAllFood() throws Exception {
		
		List<Food>foods = foodDao.findAllByStatus(AppConstent.ACTIVE);
		
		ArrayList<FoodDto>foodDtos = new ArrayList<FoodDto>();
		
		foods.forEach(each->{
			try {
				foodDtos.add(getFoods(each));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		return foodDtos;
	}
	
	private FoodDto getFoods(Food food)throws Exception{
		
		FoodDto foodDto = new FoodDto();
		foodDto.setFoodID(food.getFoodID());
		foodDto.setFoodName(food.getFoodName());
		
		return foodDto;
	}
}
