package com.sadseven.bcdividend.test;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sadseven.bcdividend.util.HttpUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


public class HttpClientTest {
	
	public static void main(String[] args) {
		HttpClientTest HCT = new HttpClientTest();
		BigDecimal total = new BigDecimal("0");
		for (int i = 1; i < 7; i++) {
			String url = "http://bc.plus/Market/GetKlineData?ceId=" + i + "&type=1min&size=8000";
			BigDecimal dividendTest = HCT.getDividendTest(url);
			total = total.add(dividendTest);
		}
		BigDecimal cost = total.multiply(new BigDecimal("0.004")).divide(new BigDecimal("5000"), 8, RoundingMode.HALF_UP);
		BigDecimal sigcost = total.multiply(new BigDecimal("0.004")).divide(new BigDecimal("3500"), 8, RoundingMode.HALF_UP);
		System.out.println("总交易额 :" + total.multiply(new BigDecimal("2")) + "usdt");
		System.out.println("双刷成本 ：" + cost + "usdt");
		System.out.println("单刷成本 ：" + sigcost + "usdt");
	}
	
	//BTC-1 LTC-2 ETH-3 QUTM-4 BSC-5 CT-6 
	
	public BigDecimal getDividendTest(String url) {
		
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String currentDay = sdf.format(d);
		Date date;
		long currentDayTime = 0;
		long nextDayTime = 0;
		try {
			date = sdf.parse(currentDay);
			currentDayTime = 1526659200000l;
			nextDayTime = currentDayTime + 86400000;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		
		JSONObject doHttpGet = HttpUtil.doHttpGet(url);
		JSONArray jsonArray = doHttpGet.getJSONObject("datas").getJSONArray("data");
		BigDecimal total = new BigDecimal("0");
		BigDecimal totalVolume = new BigDecimal("0");
		for (int i = 0; i < jsonArray.size(); i++) {
			JSONObject object = jsonArray.getJSONObject(i);
			long time = (long) object.get("Date"); //获取时间
			if (time >= currentDayTime && time < nextDayTime) {
				Double maxPrice = (Double) object.get("MaxPrice"); //获取最高价
				Double minPrice = (Double) object.get("MinPrice"); //获取最低价
				Double volume = (Double)object.get("Volume");	//获取成交量
				BigDecimal price = new BigDecimal(Double.toString(maxPrice)).add(new BigDecimal(Double.toString(minPrice))).divide(new BigDecimal("2.00000000"));
				total = total.add(price.multiply(new BigDecimal(Double.toString(volume))));
				totalVolume = totalVolume.add(new BigDecimal((Double.toString(volume))));
			} else {
				continue;
			}
		}
		return total;
	}
	
}
