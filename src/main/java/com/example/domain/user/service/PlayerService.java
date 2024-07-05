package com.example.domain.user.service;

import java.util.List;

import com.example.domain.user.model.TUser;
import com.example.domain.user.model.User;


public interface PlayerService {
	
//	playercontroller
	List<User> getUser();
	
	public List<User> getSearch(User user);
	
//	detail
	List<User> getDetailByOwnself(int playerId);
	
//	teamcontroller
	
	List<TUser> getTUsersByYourself(int teamId);
	
	List<User> getUsersByOwnself(int teamId);
	
	String getNameById(int teamId);
	
	Integer getTotalTeamPlayers(int teamId);
	
//	signup
	public void signup(User user);
	
	List<TUser> getTeamName(TUser tuser);
}
