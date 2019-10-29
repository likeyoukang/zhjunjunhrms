package com.shiyanlou.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.shiyanlou.domain.Employee;
import com.shiyanlou.domain.Post;

@Repository
public interface EmployeeDao {
	
	/**findEmployees
	 * 
	 * @param map
	 * @return
	 */
	public List<Post>findEmployees(Map<String, Object> map);
	
	/**getCount
	 * 
	 * @param map
	 * @return
	 */
	public Integer getCount(Map<String, Object> map);
	
	/**addEmployee
	 * 
	 * @param employee
	 * @return
	 */
	public Integer addEmployee(Employee employee);
	
	/**updateEmployee
	 * 
	 * @param employee
	 * @return
	 */
	public Integer updateEmployee(Employee employee);
	
	/**deleteEmployee
	 * 
	 * @param id
	 * @return
	 */
	public Integer deleteEmployee(String id);
}
