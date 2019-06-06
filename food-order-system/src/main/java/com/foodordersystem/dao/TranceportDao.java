/**
 * Jun 5, 2019	
 * food-order-system
 * com.foodordersystem.dao
 */
package com.foodordersystem.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.foodordersystem.model.Tranceport;

/**
 * @author Tharaka Chandralal
 */
public interface TranceportDao extends CrudRepository<Tranceport, String>{

	Tranceport findOneByTranceportID(String tranceportID);
	
	List<Tranceport> findAllByStatus(String status);
}
