package cn.tarena.ca.mapper;

import java.util.List;

import cn.tarena.ca.pojo.AreaLibrary;

public interface AreaMapper {
	// 新增
	int insertArea(AreaLibrary area);

	// 删除
	int deleteAreaById(Integer id);

	// 修改
	int updateAreaByPrimaryKey(AreaLibrary area);

	// 查询一条记录(通过主键)
	AreaLibrary selectAreaByPrimaryKey(Integer id);

	// 查询所有记录
	List<AreaLibrary> selectAllAreas();
}
