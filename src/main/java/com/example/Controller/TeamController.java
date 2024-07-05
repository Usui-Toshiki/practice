package com.example.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.domain.user.model.TUser;
import com.example.domain.user.model.User;
import com.example.domain.user.service.PlayerService;

@Controller
@RequestMapping("/group")

public class TeamController {

	
	@Autowired
	private PlayerService playerService;
	
	@GetMapping("/TUsersByYourself")
	public String getTeamsList(@RequestParam Integer team_id, Model model) {

		List<TUser> TUsersList = playerService.getTUsersByYourself(team_id);
		List<User> UsersList = playerService.getUsersByOwnself(team_id);
		String teamName = playerService.getNameById(team_id);
		Integer totalTeamPlayers = playerService.getTotalTeamPlayers(team_id);
		
		model.addAttribute("TUsersList",TUsersList);
		model.addAttribute("UsersList",UsersList);
		model.addAttribute("teamName",teamName);
		model.addAttribute("totalTeamPlayers",totalTeamPlayers);
		return "group/teamInfo";
	}
	
	@GetMapping("/teamInfo")
	public String getTeamInfo(Model model) {
		
		return "group/teamInfo";
	}

}
