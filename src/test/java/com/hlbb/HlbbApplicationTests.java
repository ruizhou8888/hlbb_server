package com.hlbb;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hlbb.frm.kit.MailKit;
import com.hlbb.module.manager.ManagerDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HlbbApplicationTests {

	
	@Autowired
	private ManagerDao managerDao;
	@Autowired
	private MailKit mailKit;
	
	@Test
	public void contextLoads() {
//		List<Constant> list =  constantDao.findByTypeNo("company_nature");
//		list.forEach(item->System.out.println(item.getContent()));
//		
//		Manager mng = managerDao.findById(1l);
//		System.out.println(mng.getLoginName());
//		mailKit.sendEmailCode("156621293@qq.com");
	}

}
