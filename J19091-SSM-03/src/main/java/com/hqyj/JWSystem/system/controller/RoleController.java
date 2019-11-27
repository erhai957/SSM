package com.hqyj.JWSystem.system.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hqyj.JWSystem.system.model.Role;
import com.hqyj.JWSystem.system.model.User;
import com.hqyj.JWSystem.system.model.UserRole;
import com.hqyj.JWSystem.system.service.RoleService;
import com.hqyj.JWSystem.system.service.UserRoleService;
import com.hqyj.JWSystem.system.service.UserService;

@Controller
@RequestMapping(value = "/RoleController")
public class RoleController {
	@Autowired
	private RoleService roleService;
	@Autowired
	private UserService userService;
	@Autowired
	private UserRoleService userRoleService;
	
	@RequestMapping(value = "/list.do")
	public String list(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			User user) {
		// 1.接受数据
//		System.err.println("-------------------");

		// 3.调用业务
		List<Role> role_dbList = roleService.queryAllRole();
//		for (Role role : role_dbList) {
//			System.err.println("-------------------"+role);
//		}
		// 返回页面数据
		request.setAttribute("role_dbList", role_dbList);
		// 2.跳转页面
		return "view/system/role/roleList";

	}
	@RequestMapping(value = "/FPRoleUI.do")
	public String FPRoleUI(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			Role role) {
		
		// 1.接受数据
				String idSTR = request.getParameter("id");
				int id = Integer.parseInt(idSTR);
				System.err.println("-------------------" + id);
				// 3.调用业务
				// a.分配用户信息
				User user_db = userService.queryUserById(id);
				model.addAttribute("user_db", user_db);
				// b.角色所有信息
				List<Role> role_dbList = roleService.queryAllRole();
				model.addAttribute("role_dbList", role_dbList);

				// d.选择角色数据
				// (XZ:选中)
				// 根据中间表得到role id，通过userid得到roleid
				// Role role_dbXZ = userRoleService.queryRoleById(id);
				Role role_dbXZ = roleService.queryRoleById(id);
				// spring框架需要哪个对象直接调用相应的接口
				model.addAttribute("role_dbXZ", role_dbXZ);

				// 2.跳转页面
				return "view/system/role/FPRole";
	}
	@RequestMapping(value = "/FPRole.do")
	public String FPRole(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			Role role, UserRole userRole) {
		// 1.接受数据
		String idSTR = request.getParameter("id");
		int id = Integer.parseInt(idSTR);
		System.err.println("------------用户ID-------" + id);

		String roleIdSTR = request.getParameter("roleId");
		int roleId = Integer.parseInt(roleIdSTR);
		System.err.println("-----------角色ID--------" + roleId);
		// 3.调用业务
		// 先删除
		int m = userRoleService.deleteUserRoleById(id);
		// 再保存
		userRole.setUserId(id);
		userRole.setRoleId(roleId);
		// userRole.setUser_id(id);
		// userRole.setRole_id(role_id);
		int n = userRoleService.addUserRoleByUserRole(userRole);

		// a.分配用户信息
		User user_db = userService.queryUserById(id);
		model.addAttribute("user_db", user_db);

		// b.角色所有信息
		List<Role> role_dbList = roleService.queryAllRole();

		model.addAttribute("role_dbList", role_dbList);
		// c.返回信息

		model.addAttribute("message", "角色分配成功，重新分配吗？");
		// d.选择角色数据
		// (XZ:选中)
		// Role role_dbXZ = userRoleService.queryRoleById(id);
		Role role_dbXZ = roleService.queryRoleById(id);
		model.addAttribute("role_dbXZ", role_dbXZ);
		// 2.跳转页面
		return "view/system/role/FPRole";

	}
	

}
