package com.example.domain.user.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.user.model.TUser;
import com.example.domain.user.model.User;
import com.example.domain.user.service.PlayerService;
import com.example.repository.PlayerMapper;

@Service
public class PlayerServiceImpl implements PlayerService{
	
	@Autowired
	private PlayerMapper mapper;
	
//	signup
	
	@Transactional
	@Override
	public void signup(User user) {
		try {
			mapper.insertOne(user);
			
			mapper.insertSelfer(user);
		} catch(Exception e) {
			throw new RuntimeException("Signup faild", e);
		}
		
	}
	
	@Override
	public List<TUser> getTeamName(TUser tuser){
		return mapper.findOneById(tuser);
	}
	
//	playercontroller
	
	@Override
	public List<User> getUser(){
		return mapper.findAll();
	}
	
	@Override
	public List<User> getSearch(User user){
		return mapper.findMany(user);
	}
	
//	detail
	
	@Override
	public List<User> getDetailByOwnself(int playerId){
		return mapper.allPlayers(playerId);
	}
	

	
//	teamcontroller

	
	@Override
	public List<TUser> getTUsersByYourself(int teamId){
		return mapper.findManyById(teamId);
	}
	
	@Override
	public List<User> getUsersByOwnself(int teamId){
		return mapper.findAllById(teamId);
	}
	
	@Override
	public String getNameById(int teamId) {
		return mapper.findOne(teamId);
	}
	
	@Override
	public Integer getTotalTeamPlayers(int teamId) {
		return mapper.totalTeamPlayers(teamId);
	}

}
