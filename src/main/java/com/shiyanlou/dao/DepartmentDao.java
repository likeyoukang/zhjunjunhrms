package com.shiyanlou.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.shiyanlou.domain.Department;

@Repository
public interface DepartmentDao {
	
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
