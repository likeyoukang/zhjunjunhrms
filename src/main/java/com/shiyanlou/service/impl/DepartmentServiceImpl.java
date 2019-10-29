package com.shiyanlou.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shiyanlou.dao.DepartmentDao;
import com.shiyanlou.domain.Department;
import com.shiyanlou.service.DepartmentService;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {
	
	@Resource
	private DepartmentDao departmentDao;
	
	@Override
	public List<Department> findDepartments(Map<String, Object> map) {

		return departmentDao.findDepartments(map);
	}

	@Override
	public Integer getCount(Map<String, Object> map) {

		return departmentDao.getCount(map);
	}

	@Override
	public Integer addDepartment(Department department) {

		return departmentDao.addDepartment(department);
	}

	@Override
	public Integer updateDepartment(Department department) {

		return departmentDao.updateDepartment(department);
	}

	@Override
	public Integer deleteDepartment(Integer id) {
		Integer flag = null;
		try {
			flag =  departmentDao.deleteDepartment(id);
		} catch (Exception e) {
			throw new RuntimeException();
		}
		
		return flag;
	}
}
