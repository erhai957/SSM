package com.hqyj.JWSystem.system.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hqyj.JWSystem.system.model.User;
import com.hqyj.JWSystem.system.service.UserService;

@Controller
@RequestMapping(value = "/loginController")
public class loginController {
	// 注入业务接口
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login.do")
	public String login(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			User user) {
		// 1.教授数据
		System.out.println("-------loginController------login()---1----" + user);

		// 3.调用业务
		User user_db = userService.queryUserByUser(user);
		System.out.println("-------loginController------login()----2---" + user_db);
		if (user_db != null) {
			model.addAttribute("message", "登录成功！！！");
			// 用户设置session
			session.setAttribute("USER", user_db);
			return "view/frame/main";
		} else {
			model.addAttribute("message", "用户名或密码错误，请重新输入！！！");
			return "login";
		}

		
	}

}