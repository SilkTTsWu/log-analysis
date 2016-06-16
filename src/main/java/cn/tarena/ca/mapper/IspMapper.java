package cn.tarena.ca.mapper;

import java.util.List;

import cn.tarena.ca.pojo.IspLibrary;

public interface IspMapper {
	// 新增
	int insertIsp(IspLibrary isp);

	// 删除
	int deleteIspByPrimaryKey(Integer id);

	// 修改
	int updateIspByPrimaryKey(IspLibrary ip);

	// 查询一条记录(按主键)
	int selectIspByPrimaryKey(Integer id);

	// 查询所有记录
	List<IspLibrary> selectAllIsps();
}
