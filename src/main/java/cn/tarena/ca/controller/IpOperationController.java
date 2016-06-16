package cn.tarena.ca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tarena.ca.pojo.IpLibrary;
import cn.tarena.ca.service.IpOperationService;
import cn.tarena.ca.util.JSONUtil;

@Controller
@RequestMapping("/ip")
public class IpOperationController {
	@Autowired
	private IpOperationService ipOperationService;
	
	@RequestMapping("/add")
	public Integer addIp(@RequestParam String name){
		System.out.println(name);
		Integer num = ipOperationService.addIp(name);
		return num;
	}
	
	@RequestMapping("/delete")
	public void deleteIp(Integer id){
		ipOperationService.deleteIp(id);
	}
	
	@RequestMapping("/selectAll")
	@ResponseBody
	public String selectAllIps(){
		List<IpLibrary> list = ipOperationService.selectAllIps();
		String json = JSONUtil.ObjectToJson(list);
		System.out.println(json);
		return json;
	}
	
}
