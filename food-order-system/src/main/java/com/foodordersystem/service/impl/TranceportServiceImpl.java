/**
 * Jun 6, 2019	
 * food-order-system
 * com.foodordersystem.service.impl
 */
package com.foodordersystem.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.foodordersystem.dao.HistoryDao;
import com.foodordersystem.dao.TranceportDao;
import com.foodordersystem.helper.HistoryDto;
import com.foodordersystem.helper.TranceportDto;
import com.foodordersystem.model.History;
import com.foodordersystem.model.Tranceport;
import com.foodordersystem.service.TranceportService;
import com.foodordersystem.utill.AppConstent;

/**
 * @author Tharaka Chandralal
 */
@Service
public class TranceportServiceImpl implements TranceportService{

	@Autowired
	private TranceportDao tranceportDao;
	
	@Autowired
	private HistoryDao historyDao;
	
	@Value("${app.compannyLocation}")
	private String whenLocation;
	
	/* (non-Javadoc)
	 * @see com.foodordersystem.service.TranceportService#saveTranceport(com.foodordersystem.helper.TranceportDto)
	 */
	@Override
	public String saveTranceport(TranceportDto tranceportDto) throws Exception {
		
		Date date = new Date();
	    String strDateFormat = "hh:mm:ss a";
	    DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
	    String formattedDate= dateFormat.format(date);
	    
		Tranceport tranceport = new Tranceport();
		History history = new History();
		
		tranceport.setTranceportID(UUID.randomUUID().toString());
		tranceport.setDepartmant(tranceportDto.getDepartmant());
		tranceport.setStatus(AppConstent.ACTIVE);
		
		tranceport.setDate(new Date());
		tranceport.setTime(formattedDate);
		tranceport.setWhenLocation(whenLocation);
		tranceport.setWhearLocation(tranceportDto.getWhearLocation());
		
		tranceport.setAvaragePrice(tranceportDto.getAvaragePrice());
		history.setHistoryID(UUID.randomUUID().toString());
		history.setDate(new Date());
		history.setHistoryType(AppConstent.HISTORY_TYPE_TRANCEPORT);
		history.setTime(formattedDate);
		history.setStatus(AppConstent.ACTIVE);
		history.setDepartmentName(tranceportDto.getDepartmant());
		tranceport.setHistory(historyDao.save(history));
		
		tranceportDao.save(tranceport);
		
		return "Tranceport Send Succsessfully . . !";
	}

	/* (non-Javadoc)
	 * @see com.foodordersystem.service.TranceportService#deleteTranceport(java.lang.String)
	 */
	@Override
	public String deleteTranceport(String tranceportID) throws Exception {
		
		Tranceport  tranceport = tranceportDao.findOneByTranceportID(tranceportID);
		History history = historyDao.findOneByHistoryID(tranceport.getHistory().getHistoryID());
		
		tranceport.setStatus(AppConstent.DEACTIVE);
		history.setStatus(AppConstent.DEACTIVE);
		
		if (tranceport != null) {
			
			tranceportDao.save(tranceport);
			historyDao.save(history);
			
			return "Tranceport Delete Succsessfull . . !";
		}else {
			return "Tranceport Deletion Faild . . !";
		}
		
		
	}

	/* (non-Javadoc)
	 * @see com.foodordersystem.service.TranceportService#updateTranceport(com.foodordersystem.helper.TranceportDto)
	 */
	@Override
	public String updateTranceport(TranceportDto tranceportDto) throws Exception {
		
		Date date = new Date();
	    String strDateFormat = "hh:mm:ss a";
	    DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
	    String formattedDate= dateFormat.format(date);
	    
		Tranceport tranceport = tranceportDao.findOneByTranceportID(tranceportDto.getTranceportID());
		History history = historyDao.findOneByHistoryID(tranceportDto.getHistoryDto().getHistoryID());
		
		tranceport.setWhearLocation(tranceportDto.getWhearLocation());
		tranceport.setDate(new Date());
		tranceport.setDepartmant(tranceportDto.getDepartmant());
		tranceport.setTime(formattedDate);
		tranceport.setAvaragePrice(tranceportDto.getAvaragePrice());
		
		history.setDate(new Date());
		history.setTime(formattedDate);
		history.setDepartmentName(tranceportDto.getDepartmant());
		tranceport.setHistory(historyDao.save(history));
		
		tranceportDao.save(tranceport);
		
		return "Tranceport Update Succsessfully . . !";
	}

	/* (non-Javadoc)
	 * @see com.foodordersystem.service.TranceportService#searchTranceport(java.lang.String)
	 */
	@Override
	public TranceportDto searchTranceport(String tranceportID) throws Exception {
		
		Tranceport tranceport = tranceportDao.findOneByTranceportID(tranceportID);
		TranceportDto tranceportDto = getTranceport(tranceport);
		
		return tranceportDto;
	}

	/* (non-Javadoc)
	 * @see com.foodordersystem.service.TranceportService#getAllTranceport()
	 */
	@Override
	public List<TranceportDto> getAllTranceport() throws Exception {
		
		List<Tranceport>tranceportList = tranceportDao.findAllByStatus(AppConstent.ACTIVE);
		ArrayList<TranceportDto>tranceportDtos = new ArrayList<>();
		
		tranceportList.forEach(each->{
			try {
				tranceportDtos.add(getTranceport(each));
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		return tranceportDtos;
	}

	private TranceportDto getTranceport(Tranceport tranceport)throws Exception{
		
		History history = historyDao.findOneByHistoryID(tranceport.getHistory().getHistoryID());
		HistoryDto historyDto = new HistoryDto();
		TranceportDto tranceportDto = new TranceportDto();
		
		historyDto.setDate(history.getDate());
		historyDto.setHistoryID(history.getHistoryID());
		historyDto.setHistoryType(history.getHistoryType());
		historyDto.setTime(history.getTime());
		historyDto.setDepartmentName(history.getDepartmentName());
		
		tranceportDto.setDate(tranceport.getDate());
		tranceportDto.setDepartmant(tranceport.getDepartmant());
		
		tranceportDto.setTime(tranceport.getTime());
		tranceportDto.setWhearLocation(tranceport.getWhearLocation());
		tranceportDto.setWhenLocation(tranceport.getWhenLocation());
		tranceportDto.setTranceportID(tranceport.getTranceportID());
		tranceportDto.setAvaragePrice(tranceport.getAvaragePrice());
		tranceportDto.setHistoryDto(historyDto);
		
		return tranceportDto;
		
	}
}
