package com.shiyanlou.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shiyanlou.domain.Admin;
import com.shiyanlou.service.AdminService;
import com.shiyanlou.util.ResponseUtil;

/**
 * 
 * @author shiyanlou
 *
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

	@Resource
	private AdminService adminService;
	
	/**
	 * 
	 * @param admin
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping("/login")
	public String login(Admin admin, HttpServletRequest request,
			HttpSession session) {
		Admin resultAdmin = adminService.login(admin);
		if (resultAdmin == null) {
			request.setAttribute("admin", admin);
			request.setAttribute("errorMsg",
					"Please check your username and password!");
			return "login";
		} else {
			session.setAttribute("currentAdmin", resultAdmin);
			session.setAttribute("username", resultAdmin.getUsername());
			return "redirect:main";
		}
	}
	
	/**
	 * 
	 * @param model
	 * @return
	 * @throws Exception
	 */
    @RequestMapping(value="/main")
    public String test(Model model) throws Exception{ 
        return "home_page";
    }
    
	/**
	 * 
	 * @param admin
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public String list(Admin admin, HttpServletResponse response)
			throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		if (admin.getUsername() != null
				&& !"".equals(admin.getUsername().trim())) {
			map.put("username", "%" + admin.getUsername() + "%");
		}
		List<Admin> adminList = adminService.findAdmins(map);
		Integer total = adminService.getCount(map);
		JSONObject result = new JSONObject();
		JSONArray jsonArray = JSONArray.fromObject(adminList);
		result.put("rows", jsonArray);
		result.put("total", total);
		ResponseUtil.write(response, result);
		return null;
	}
	
	/**
	 * 
	 * @param admin
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public String save(Admin admin, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int resultTotal = 0;
		if (admin.getId() == null)
			resultTotal = adminService.addAdmin(admin);
		else
			resultTotal = adminService.updateAdmin(admin);
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
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	public String delete(@RequestParam(value = "ids") String ids,
			HttpServletResponse response, HttpSession session) throws Exception {
		JSONObject result = new JSONObject();
		String[] idsStr = ids.split(",");
		for (int i = 0; i < idsStr.length; i++) {
			if (idsStr[i].equals("1")||idsStr[i].equals(((Admin)session.getAttribute("currentAdmin")).getId().toString())){
				result.put("success", false);
				continue;
			}else{
				adminService.deleteAdmin(Integer.parseInt(idsStr[i]));
				result.put("success", true);
			}
		}
		ResponseUtil.write(response, result);
		return null;
	}
	
	/**
	 * 
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/logout")
	public String logout(HttpSession session) throws Exception {
		session.invalidate();
		return "redirect:/login.jsp";
	}
}