package cn.tarena.ca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tarena.ca.pojo.IspLibrary;
import cn.tarena.ca.service.IspOperationService;

@Controller
@RequestMapping("/isp")
public class IspOperationController {
	@Autowired
	private IspOperationService ispOperationService;

	@RequestMapping("/add")
	public void addIsp(IspLibrary isp) {
		ispOperationService.addIsp(isp);
	}

	@RequestMapping("/delete")
	public void deleteIsp(Integer id) {
		ispOperationService.deleteIsp(id);
	}
}
