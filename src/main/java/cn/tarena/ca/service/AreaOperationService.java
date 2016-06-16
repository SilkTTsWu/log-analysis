package cn.tarena.ca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tarena.ca.mapper.AreaMapper;
import cn.tarena.ca.pojo.AreaLibrary;

@Service
public class AreaOperationService {
	@Autowired
	private AreaMapper areaMapper;

	// 增,选中对象增加的就是其下属的地域,那么,pid就是点击的那个地域对象的id,level则是所选对象的下一级
	public void addArea(AreaLibrary area) {
		areaMapper.insertArea(area);
	}

	// 级联关系存在,不能做级联删除,删除该级别后,其所有下属地域的pid全部设置为null?level决定他所处的位置
	public void deleteArea(Integer id) {
		areaMapper.deleteAreaById(id);
	}
}
