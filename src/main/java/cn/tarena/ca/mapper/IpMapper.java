package cn.tarena.ca.mapper;

import java.util.List;

import cn.tarena.ca.pojo.IpLibrary;

/**
 * 这个类是Ip地址库Mapper层.
 *
 * @version 1.0 6 Jun 2016
 * @author wuyw
 */
public interface IpMapper {
    /**
     * 新增一条Ip记录.
     * @param ip Ip库实体类
     * @return int mybatis会返回一个整型数值判断操作是否完成
     */
    int insertIp(IpLibrary ip);

    /**
     * 通过主键Id删除一条记录.
     * @param id 该记录的主键id
     * @return int mybatis会返回一个整型数值判断操作是否完成
     */
    int deleteIpByPrimaryKey(Integer id);

    /**
     * 更新一条Ip记录,该方法在前台没有被调用.
     * @param ip Ip库实体类
     * @return int mybatis会返回一个整型数值判断操作是否完成
     */
    int updateIpByPrimaryKey(IpLibrary ip);

    /**
     * 按主键进行查询,该功能没有被调用.
     * @param id 该记录的主键id
     * @return 查到的Ip记录
     */
    IpLibrary selectIpByPrimaryKey(Integer id);

    /**
     * 按Ip地址进行查询.
     * @param name Ip地址
     * @return 查询到的Ip记录
     */
    IpLibrary selectIpByName(String name);

    /**
     * 查询所有记录.
     * @return 查询到的所有记录
     */
    List<IpLibrary> selectAllIps();
}
