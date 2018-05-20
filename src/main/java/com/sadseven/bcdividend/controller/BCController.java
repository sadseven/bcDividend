package com.sadseven.bcdividend.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sadseven.bcdividend.model.Dividend;
import com.sadseven.bcdividend.model.DividendExample;
import com.sadseven.bcdividend.service.BCService;
import com.sadseven.bcdividend.service.DividendService;

@RestController
public class BCController {
	
	@Autowired
    private BCService bcService;
	@Autowired
    private DividendService dividendService;
	
	@RequestMapping("/")
    public String show(){
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		String currentDay = sdf.format(d);
		Date date;
		long currentDayTime = 0;
		try {
			date = sdf.parse(currentDay);
			currentDayTime = date.getTime();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DividendExample example = new DividendExample();
		example.createCriteria().andTimeEqualTo(currentDayTime);
		
		List<Dividend> selectByExample = dividendService.selectByExample(example);
		if (selectByExample != null && selectByExample.size() > 0) {
			return "总交易额 :" + selectByExample.get(0).getTurnover() + "usdt\n" + 
					"单刷成本 ：" + selectByExample.get(0).getSinglecost() + "usdt\n" + 
					"双刷成本 ：" + selectByExample.get(0).getDoublecost() + "usdt" ;
		} else {
			BigDecimal total = new BigDecimal("0");
			for (int i = 1; i < 7; i++) {
				String url = "http://bc.plus/Market/GetKlineData?ceId=" + i + "&type=1min&size=1450";
				BigDecimal dividendTest = bcService.getDividend(url);
				total = total.add(dividendTest);
			}
			BigDecimal doublecost = total.multiply(new BigDecimal("0.004")).divide(new BigDecimal("5000"), 8, RoundingMode.HALF_UP);
			BigDecimal singlecost = total.multiply(new BigDecimal("0.004")).divide(new BigDecimal("3500"), 8, RoundingMode.HALF_UP);
			BigDecimal turnover = total.multiply(new BigDecimal("2")).setScale(8,BigDecimal.ROUND_HALF_UP);;
			Dividend record = new Dividend();
			record.setTime(currentDayTime);
			record.setSinglecost(singlecost.doubleValue());
			record.setDoublecost(doublecost.doubleValue());
			record.setTurnover(turnover.doubleValue());
			
			dividendService.insert(record);
			
	        return "总交易额 :" + turnover + "usdt\n" +
	        		"单刷成本 ：" + singlecost + "usdt\n" +
	        		"双刷成本 ：" + doublecost + "usdt\n"	; 
		}
		       
    }
	
	
	
}
