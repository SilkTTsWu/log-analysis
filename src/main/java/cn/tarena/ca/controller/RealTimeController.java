package cn.tarena.ca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tarena.ca.pojo.DataByHours;
import cn.tarena.ca.service.RealTimeService;

@Controller
@RequestMapping("/realtime")
public class RealTimeController {
	@Autowired
	private RealTimeService realTimeService;
	
	@RequestMapping("dataJson_today")
	@ResponseBody
	public List<DataByHours> queryRealTime_today(){
		List<DataByHours> list =  realTimeService.queryRealTime_today();
		return list;
	}
	
	@RequestMapping("dataJson_yestoday")
	@ResponseBody
	public List<DataByHours> queryRealTime_yestoday(){
		List<DataByHours> list = realTimeService.queryRealTime_yestoday();
		return list;
	}
	
	@RequestMapping("dataJson_7daysago")
	@ResponseBody
	public List<DataByHours> queryRealTime_7daysago(){
		List<DataByHours> list = realTimeService.queryRealTime_7daysago();
		return list;
	}
	
	@RequestMapping("dataJson_30daysago")
	@ResponseBody
	public List<DataByHours> queryRealTime_30daysago(){
		List<DataByHours> list = realTimeService.queryRealTime_30daysago();
		return list;
	}
	
	
	
	
	
}
