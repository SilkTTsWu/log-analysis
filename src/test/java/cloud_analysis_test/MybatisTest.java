package cloud_analysis_test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import cn.tarena.ca.pojo.IpLibrary;
import cn.tarena.ca.service.IpOperationService;



public class MybatisTest {
	/*@Autowired
	IpMapper ipMapper;*/
	
	@Test
	public void test(){
		ApplicationContext ac = new FileSystemXmlApplicationContext("classpath:spring/applicationContext*.xml");
		IpOperationService w= (IpOperationService) ac.getBean("ipOperationService");
//		w.deleteIp(1);
//		IpLibrary ip = new IpLibrary();
//		ip.setCountryId("3223");
//		ip.setId(4);
//		ip.setName("abc");
//		ip.setCityId("123123");
//		w.add(ip);
//		w.queryAll();
//		IpLibrary ip = w.selectbyid(3);
//		System.out.println(ip);
//		List<IpLibrary> list = w.selectAll();
//		System.out.println(list);
	}
}
