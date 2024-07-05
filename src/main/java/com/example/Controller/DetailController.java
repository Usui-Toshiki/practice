package com.example.Controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.domain.user.model.User;
import com.example.domain.user.service.PlayerService;

@Controller
@RequestMapping("/group")

public class DetailController {
	
	@Autowired
	private PlayerService playerService;
	
	private static String[] LINKS = {
			"https://www.oikiiin.com/recruit-happiness/",
			"https://kowabana.jp/users/2669/wallpapers",
			"https://www.moranbong.co.jp/tuqro/mak/mak_01_00.html",
			"https://www.tokyodisneyresort.jp/tdl/"
	};
	
	@GetMapping("/detailByOwnself")
	public String getDetail(@RequestParam("player_id") Integer player_id,String team_name, Model model) {
		
		List<User> DetailList = playerService.getDetailByOwnself(player_id);
	

		model.addAttribute("DetailList",DetailList);

		return "group/detail";
	}
	
	@PostMapping("/randomLink")
	public String getLink(Model model) {
		Random random = new Random();
		int randomIndex = random.nextInt(LINKS.length);
		String randomLink = LINKS[randomIndex];
		model.addAttribute("randomLink",randomLink);
		return "redirect:" + randomLink;
	}

}
