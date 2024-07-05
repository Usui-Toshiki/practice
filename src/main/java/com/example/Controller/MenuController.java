package com.example.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/group")
public class MenuController {
	
	@GetMapping("/menu")
	public String getMenu(Model model) {
		return "/group/menu";
	}

}
