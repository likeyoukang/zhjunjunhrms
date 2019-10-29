package com.shiyanlou.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shiyanlou.dao.EmployeeDao;
import com.shiyanlou.domain.Employee;
import com.shiyanlou.domain.Post;
import com.shiyanlou.service.EmployeeService;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Resource
	private EmployeeDao employeeDao;
	
	@Override
	public List<Post> findEmployees(Map<String, Object> map) {
		
		return employeeDao.findEmployees(map);
	}

	@Override
	public Integer getCount(Map<String, Object> map) {
		
		return employeeDao.getCount(map);
	}

	@Override
	public Integer addEmployee(Employee employee) {
		Integer flag = null;
		try {
			flag =  employeeDao.addEmployee(employee);
		} catch (Exception e) {
			throw new RuntimeException();
		}
		
		return flag;
	}

	@Override
	public Integer updateEmployee(Employee employee) {
		
		return employeeDao.updateEmployee(employee);
	}

	@Override
	public Integer deleteEmployee(String id) {
		
		return employeeDao.deleteEmployee(id);
	}

}
