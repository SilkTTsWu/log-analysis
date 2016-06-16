package cn.tarena.ca.controller;

import cn.tarena.ca.pojo.AreaLibrary;
import cn.tarena.ca.service.AreaOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/area")
public class AreaOperationController {

	@Autowired
	private AreaOperationService areaOperationService;

	@RequestMapping("/add")
	public void addArea(AreaLibrary area) {
		areaOperationService.addArea(area);
	}

	@RequestMapping("/delete")
	public void deleteArea(Integer id) {
		areaOperationService.deleteArea(id);
	}
}
