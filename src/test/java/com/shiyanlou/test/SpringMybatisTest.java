package com.shiyanlou.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shiyanlou.domain.Admin;
import com.shiyanlou.service.AdminService;


@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration({ "classpath:spring-mybatis.xml" })
public class SpringMybatisTest {
	
	@Autowired
	private AdminService adminService;
	
	@Test
	public void testLogin() {
		Admin admin = new Admin();
		admin.setUsername("superadmin");
		admin.setPassword("123456");
		System.out.println(adminService.login(admin).toString());

	}
}
