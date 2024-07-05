package com.example.domain.user.model;

import java.time.LocalDate;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class Both {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int playerId;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int teamId;
	
	private int totalTeamPlayers;
	private String playerName;
	private Integer age;
	private LocalDate playerBirth;
	private String birthPlace;
}
