package com.hqyj.JWSystem.system.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import com.hqyj.JWSystem.system.model.Permission;
import com.hqyj.JWSystem.system.model.Role;
import com.hqyj.JWSystem.system.model.RolePermission;
import com.hqyj.JWSystem.system.model.User;
import com.hqyj.JWSystem.system.service.PermissionService;
import com.hqyj.JWSystem.system.service.RolePermissionService;
import com.hqyj.JWSystem.system.service.RoleService;

@Controller
@RequestMapping(value = "/PermissionController")
public class PermissionController {
	@Autowired
	private PermissionService permissionService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private RolePermissionService rolePermissionService;
	
	@RequestMapping(value = "/list.do")
	public String list(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			User user) {
		// 1.接受数据
		// System.err.println("-------------------");

		// 3.调用业务
		List<Permission> permission_dbList = permissionService.queryAllPermission();
//		 for (Permission permission : permission_dbList) {
//		 System.err.println("-------------------" + user);
//		 }
//		 返回页面数据
		request.setAttribute("permission_dbList", permission_dbList);
		// 2.跳转页面
		return "view/system/Permission/permissionList";

	}
	@RequestMapping(value = "/FPPermissionUI.do")
	public String FPPermissionUI(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		//接受数据
		System.out.println("跳转界面");
		//1.接受数据,得到roleid
		String role_idString=req.getParameter("roleId");
		int roleId=Integer.parseInt(role_idString);
		
		//将role放到req中
		Role role_db=roleService.queryRoleByRole_id(roleId);
		req.setAttribute("role_db", role_db);
		
		List<Permission> permission_dbList=permissionService.queryAllPermission();
		req.setAttribute("permission_dbList",  permission_dbList);
		
		//跳转页面

		return "view/system/Permission/FPPermission";

	}
	
	@RequestMapping(value = "/FPPermission.do")
	public String FPPermission(HttpServletRequest req, HttpServletResponse resp,RolePermission rolePermission) {
		String role_idString=req.getParameter("roleId");
		int roleId=Integer.parseInt(role_idString);
		//先删除
		int m=rolePermissionService.deleteRolePermissionByroleid(roleId);
		//
		String[] permission_idsSTR = req.getParameterValues("permission_ids");
		for (String permission_idSTR : permission_idsSTR) {
			int permissionId = Integer.parseInt(permission_idSTR);
//			System.out.println("----------------role_id---" + permission_id);
			// 3.调用业务
			rolePermission.setRoleId(roleId);
			rolePermission.setPermissionId(permissionId);
			int n = rolePermissionService.addRolePermissionByRolePermission(rolePermission);
			// a. 准备数据
			Role role_db = roleService.queryRoleByRole_id(roleId);
			req.setAttribute("role_db", role_db);

			// b. 准备数据
			List<Permission> permission_dbList = permissionService.queryAllPermission();
			req.setAttribute("permission_dbList", permission_dbList);

			// c. 消息
			req.setAttribute("message", "菜单分配成功，重新分配吗？");

			// d.选择菜单数据
			// (XZ:选中)
			List<Permission> permission_dbListXZ = permissionService.queryAllPermissionXZ_By(roleId);
			req.setAttribute("permission_dbListXZ", permission_dbListXZ);
			for (Permission permission : permission_dbListXZ) {
				System.out.println("---------------permission-----------------" + permission);
			}
		}
		
		return "view/system/Permission/FPPermission";
	}
}
