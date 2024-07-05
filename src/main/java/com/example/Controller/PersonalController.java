package com.example.Controller;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.user.model.Both;
import com.example.domain.user.model.User;
import com.example.domain.user.service.PlayerService;

@Controller
@RequestMapping("/group")

public class PersonalController {
	
	@Autowired
	private PlayerService playerService;
	
	@Autowired
	private ModelMapper modelMapper;

	
	@GetMapping("/playerList")
	public String getPersonal(@ModelAttribute Both both ,Model model) {
		List<User> UserList = playerService.getUser();

		model.addAttribute("UserList",UserList);
		return "group/playerList";
	}
	
	@PostMapping("/playerList")
	public String toPersonal(@ModelAttribute Both both, Model model) {
		User user = modelMapper.map(both,User.class);
		List<User> searchList = playerService.getSearch(user);
		model.addAttribute("UserList",searchList);
		return "group/playerList";
	}

}
