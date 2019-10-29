package com.shiyanlou.service;

import java.util.List;
import java.util.Map;

import com.shiyanlou.domain.Admin;

public interface AdminService {

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

    /**deleteAdmin
     * 
     * @param id
     * @return
     */
    public Integer deleteAdmin(Integer id);
}