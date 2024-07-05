package com.example.repository;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.domain.user.model.TUser;
import com.example.domain.user.model.User;

@Mapper
public interface PlayerMapper {
	
	
//	PlayerController
	
	List<User> findAll();
	
	public List<User> findMany(User user);
	
//	detail
	List<User> allPlayers(int playerId);

	
	
//	TeamController
	
	List<TUser> findManyById(int teamId);
	
	List<User> findAllById(int teamId);
	
	String findOne(int teamId);
	
	Integer totalTeamPlayers(int teamId);
	
//	main
	public int insertOne(User user);
	public int insertSelfer(User user);
	
	List<TUser> findOneById(TUser tuser);
}