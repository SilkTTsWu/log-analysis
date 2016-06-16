package cn.tarena.ca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.reflect.TypeToken;

import cn.tarena.ca.mapper.IpMapper;
import cn.tarena.ca.pojo.IpJsonFromWeb;
import cn.tarena.ca.pojo.IpLibrary;
import cn.tarena.ca.util.IpAnalysis;
import cn.tarena.ca.util.JSONUtil;
/**
 * 
 * @author wuyw
 *
 */
@Service
public class IpOperationService {
	/*
	 * ip地址新增 注意:ip地址这里没必要做修改,因为修改,对于我来说就是前台传过来一条新记录,跟新增没区别
	 */
	@Autowired
	private IpMapper ipMapper;

	// 添加一条记录
	public Integer addIp(String name) {
		// 获取到用户在前台输入的ip地址
		System.out.println(name);
		// 判断数据库内是否有此ip对应的记录
		IpLibrary ip = ipMapper.selectIpByName(name);
		// 若有该记录,提示已经包含该记录
		if (ip != null) {
			// 前台提示已经包含该记录
			System.out.println("Ip库已包含该信息...");
			return -1;
		} else {
			// 若没有该记录,解析,新增
			// 通过工具类获取到ip信息json串
			String jsonStr = IpAnalysis.getResult("ip=" + name, "utf-8");
			IpJsonFromWeb IpData = JSONUtil.jsonToObject(jsonStr, new TypeToken<IpJsonFromWeb>() {
			}.getType());
			IpLibrary ipObj = new IpLibrary();
//			ipObj.setName(IpData.getData().getIp());
//			ipObj.setCountryId(IpData.getData().getCountry_id());
//			ipObj.setCityId(IpData.getData().getCity_id());
//			ipObj.setCountyId(IpData.getData().getCounty_id());
//			ipObj.setIspId(IpData.getData().getIsp_id());
//			ipObj.setRegionId(IpData.getData().getRegion_id());
//			Integer num = ipMapper.insertIp(ipObj);
//			return num;
			return null;
		}
	}

	// 查询全部记录
	public List<IpLibrary> selectAllIps() {
		return ipMapper.selectAllIps();
	}

	// 删除一条记录
	public void deleteIp(Integer id) {
		// 获取前台选中目标id
		ipMapper.deleteIpByPrimaryKey(id);
	}

	// 直接添加一条数据(测试)
	public void add(IpLibrary ipLibrary) {
		ipMapper.insertIp(ipLibrary);
	}


	// 查询一条记录(测试)
	public IpLibrary selectbyid(Integer id) {
		return ipMapper.selectIpByPrimaryKey(id);
	}


}
