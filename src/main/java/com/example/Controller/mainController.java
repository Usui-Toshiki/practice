package com.example.Controller;

import java.util.Random;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.user.model.User;
import com.example.domain.user.service.PlayerService;
import com.example.form.SignupForm;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/group")
@Slf4j
public class mainController {
	
	@Autowired
	private PlayerService playerService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	private static String[] LINKS = {
			"https://www.oikiiin.com/recruit-happiness/",
			"https://kowabana.jp/users/2669/wallpapers",
			"https://www.moranbong.co.jp/tuqro/mak/mak_01_00.html",
			"https://www.tokyodisneyresort.jp/tdl/",
			"https://www.jrc.or.jp/contribute/support/",
			"https://www.jalan.net/news/article/145790/"
	};

	@GetMapping("/main")
	public String getPractice(@ModelAttribute("signupForm")SignupForm form, Model model) {
		return "group/main";
	}
	
	@PostMapping("/main")
	public String toPractice(@ModelAttribute("signupForm") SignupForm form,BindingResult result ,Model model) {
		if(result.hasErrors()) {
			return "group/main";
		}
		log.info(form.toString());
		
		Random random = new Random();
		boolean success = random.nextBoolean();
		if(success) {
			User user = modelMapper.map(form, User.class);
			playerService.signup(user);
			return "redirect:/group/playerList";
		}else {
			int randomIndex = random.nextInt(LINKS.length);
			String randomLink = LINKS[randomIndex];
			return "redirect:" + randomLink;
		}


	}
	

	

}
