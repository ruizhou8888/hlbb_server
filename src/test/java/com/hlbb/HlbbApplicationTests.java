package com.hlbb;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hlbb.module.constant.Constant;
import com.hlbb.module.constant.ConstantDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HlbbApplicationTests {

	@Autowired
	private ConstantDao constantDao;
	
	@Test
	public void contextLoads() {
		List<Constant> list =  constantDao.findByTypeNo("company_nature");
		list.forEach(item->System.out.println(item.getContent()));
	}

}
