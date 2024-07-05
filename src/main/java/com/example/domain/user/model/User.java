package com.example.domain.user.model;

import java.time.LocalDate;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int playerId;
	
	private String playerName;
	private int age;
	private LocalDate playerBirth;
	private String birthPlace;
	private String strong;
	private String food;
	private String word;
	private int teamId;
	private String teamName;
	private Integer rownum;
	
}
