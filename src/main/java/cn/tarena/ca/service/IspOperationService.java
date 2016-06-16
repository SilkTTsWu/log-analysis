package cn.tarena.ca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tarena.ca.mapper.IspMapper;
import cn.tarena.ca.pojo.IspLibrary;

@Service
public class IspOperationService {
	@Autowired
	private IspMapper ispMapper;

	public void addIsp(IspLibrary isp) {
		ispMapper.insertIsp(isp);
	}

	public void deleteIsp(Integer id) {
		ispMapper.deleteIspByPrimaryKey(id);
	}
}
