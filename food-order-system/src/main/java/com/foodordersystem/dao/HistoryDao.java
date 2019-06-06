/**
 * Jun 5, 2019	
 * food-order-system
 * com.foodordersystem.dao
 */
package com.foodordersystem.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.foodordersystem.model.History;

/**
 * @author Tharaka Chandralal
 */
public interface HistoryDao extends CrudRepository<History, String>{

	History findOneByHistoryID(String historyID);
	
	List<History>findAllByStatus(String status);
	
	List<History>findAllByDateAndStatusOrderByDateDesc(Date date,String status);
	
	List<History>findAllByDepartmentNameAndStatusOrderByDateDesc(String departmentName,String status);
	
}
