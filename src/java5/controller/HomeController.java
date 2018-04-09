package java5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/index")
	public String home(){
		return "redirect:product.html";
	}
	
	@RequestMapping("")
	public String showHome() {
		return "redirect:product.html";
	}
	
	@RequestMapping("/accessdenied")
	public String hienTrangBaoLoi() {
		return "accessdenied";
	}
}
