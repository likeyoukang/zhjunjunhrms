package com.shiyanlou.service;

import java.util.List;
import java.util.Map;

import com.shiyanlou.domain.Department;

public interface DepartmentService {

	/**findDepartments
	 * 
	 * @param map
	 * @return
	 */
	public List<Department> findDepartments(Map<String, Object> map);
	
	/**getCount
	 * 
	 * @param map
	 * @return
	 */
	public Integer getCount(Map<String, Object> map);
		
	/**addDepartment
	 * 
	 * @param department
	 * @return
	 */
	public Integer addDepartment(Department department);
	
	/**updateDepartment
	 * 
	 * @param department
	 * @return
	 */
	public Integer updateDepartment(Department department);
	
	/**deleteDepartment
	 * 
	 * @param id
	 * @return
	 */
	public Integer deleteDepartment(Integer id);
}
