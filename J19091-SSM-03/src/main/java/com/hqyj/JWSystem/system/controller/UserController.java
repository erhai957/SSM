package com.hqyj.JWSystem.system.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hqyj.JWSystem.system.model.User;
import com.hqyj.JWSystem.system.service.UserService;

@Controller
@RequestMapping(value = "/UserController")
public class UserController {
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value = "/list.do")
	public String list(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			User user) {
		// 1.教授数据
//		System.out.println("-------loginController------login()---1----" + user);
//		 3.调用业务
		List<User> user_dbList = userService.queryAllUser();
//		System.out.println("-------loginController------login()----2---" + user_dbList);
		request.setAttribute("user_dbList", user_dbList);
		// 2.跳转页面
		return "view/system/user/userList";

	}
	
	@RequestMapping(value = "/add.do")
	public String add(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			User user) {
		//接收数据
		String name = request.getParameter("name");
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		String salt = request.getParameter("salt");
		String locked = request.getParameter("locked");

		user.setName(name);
		user.setAccount(account);
		user.setPassword(password);
		user.setSalt(salt);
		user.setLocked(locked);
		Date date = new Date(); // 获取当前的系统时间。
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss"); // 使用了默认的格式创建了一个日期格式化对象。
		String time = dateFormat.format(date); // 可以把日期转换转指定格式的字符串
		System.out.println("当前的系统时间：" + time);
		user.setCreateTime(time);
		
		//调用业务
		int m =userService.addUser(user);
		//准备数据
		List<User> user_dbList = userService.queryAllUser();
		request.setAttribute("user_dbList", user_dbList);

		// 2.跳转页面
		return "view/system/user/userList";

	}
	
	 @RequestMapping("/delete.do")
	public String delete(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			User user) {
		//接收数据
		String idSTR = request.getParameter("id");
		int id = Integer.parseInt(idSTR);
		//调用业务
		int m =userService.deleteUser(id);
		// 准备数据
		List<User> user_dbList = userService.queryAllUser();
		request.setAttribute("user_dbList", user_dbList);
		//跳转界面
		return "view/system/user/userList";
	}
	 
	 @RequestMapping("/updateUI.do")
	 public String updateUI(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
				User user) {
			String idSTR = request.getParameter("id");
			int id = Integer.parseInt(idSTR);
			// 1.接受数据
			// System.err.println("--------updateUI()-----------" + id);

			// 3.调用业务
			User user_db = userService.queryUserById(id);
			// System.err.println("--------updateUI()-----user_db------" + user_db);
			request.setAttribute("user_db", user_db);
			// 2.跳转页面
			return "view/system/user/updateUser";

		}
	 
	 @RequestMapping("/update.do")
	 public String update(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
				User user) {
			// 1.接受数据
			String idSTR = request.getParameter("id");
			int id = Integer.parseInt(idSTR);
			String name = request.getParameter("name");
			String account = request.getParameter("account");
			String password = request.getParameter("password");
			String salt = request.getParameter("salt");
			String locked = request.getParameter("locked");
			
			
			user.setId(id);
			user.setName(name);
			user.setAccount(account);
			user.setPassword(password);
			user.setSalt(salt);
			user.setLocked(locked);
			System.out.println("------------------" + user);

			// 3.调用业务
			int m =userService.deleteUser(id);
			int n = userService.addUserByUser(user);

			// 准备数据
			List<User> user_dbList = userService.queryAllUser();
			request.setAttribute("user_dbList", user_dbList);
			// 2.跳转页面
			return "view/system/user/userList";

		}

}
