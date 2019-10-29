package com.shiyanlou.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shiyanlou.domain.Department;
import com.shiyanlou.service.DepartmentService;
import com.shiyanlou.util.ResponseUtil;

/**
 * 
 * @author shiyanlou
 *
 */
@Controller
@RequestMapping("/dept")
public class DeptController {

	@Resource
	private DepartmentService departmentService;
	
	/**
	 * 
	 * @param department
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public String list(Department department, HttpServletResponse response)
			throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		if (department.getName() != null
				&& !"".equals(department.getName().trim())) {
			map.put("name", "%" + department.getName() + "%");
		}
		List<Department> deptList = departmentService.findDepartments(map);
		Integer total = departmentService.getCount(map);
		JSONObject result = new JSONObject();
		JSONArray jsonArray = JSONArray.fromObject(deptList);
		result.put("rows", jsonArray);
		result.put("total", total);
		ResponseUtil.write(response, result);
		return null;
	}
	
	/**
	 * 
	 * @param department
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public String save(Department department, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int resultTotal = 0;
		if (department.getId() == null)
			resultTotal = departmentService.addDepartment(department);
		else
			resultTotal = departmentService.updateDepartment(department);
		JSONObject result = new JSONObject();
		if (resultTotal > 0) {
			result.put("success", true);
		} else {
			result.put("success", false);
		}
		ResponseUtil.write(response, result);
		return null;
	}
	
	/**
	 * 
	 * @param ids
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	public String delete(@RequestParam(value = "ids") String ids,
			HttpServletResponse response) throws Exception {
		JSONObject result = new JSONObject();
		String[] idsStr = ids.split(",");
		for (int i = 0; i < idsStr.length; i++) {
			try {
				departmentService.deleteDepartment(Integer.parseInt(idsStr[i]));
				result.put("success", true);
			} catch (Exception e) {
				result.put("success", false);
			}					
		}
		ResponseUtil.write(response, result);
		return null;
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/getcombobox")
	@ResponseBody
	public JSONArray getDept(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Department> deptList = departmentService.findDepartments(map);
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for (Department dept : deptList) {
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("id", dept.getId());
			result.put("name", dept.getName());
			list.add(result);
		}
		JSONArray jsonArray = JSONArray.fromObject(list);
		return jsonArray;
	}
}
