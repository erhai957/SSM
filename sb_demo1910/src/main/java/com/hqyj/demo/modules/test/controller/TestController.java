/**
	 * @Title: 
	 * @Description: TODO 
	 * @param @param 
	 * @param @param 
	 * @param @return 
	 * @return 
	 * @throws
	 */
package com.hqyj.demo.modules.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ASUS
 *
 */
@Controller
public class TestController {
	@RequestMapping("/test/info")
	@ResponseBody
	public String TestInfo() {
		return "this is spring boot";
	}

	
}
