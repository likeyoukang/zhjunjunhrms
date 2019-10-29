package com.shiyanlou.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.shiyanlou.domain.Admin;

@Repository
public interface AdminDao {

    /** login
     * 
     * @param admin
     * @return
     */
    public Admin login(Admin admin);

    /** findAdmins
     * 
     * @param map
     * @return
     */
    public List<Admin> findAdmins(Map<String, Object> map);

    /** getCount
     * 
     * @param map
     * @return
     */
    public Integer getCount(Map<String, Object> map);

    /** addAdmin
     * 
     * @param admin
     * @return
     */
    public Integer addAdmin(Admin admin);

    /** updateAdmin
     * 
     * @param admin
     * @return
     */
    public Integer updateAdmin(Admin admin);

    /** deleteAdmin
     * 
     * @param id
     * @return
     */
    public Integer deleteAdmin(Integer id);
}