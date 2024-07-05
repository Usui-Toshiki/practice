package com.example.form;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SignupForm {
	private int playerId;

	@NotNull
	private String playerName;
	
	@NotNull
	private Integer age;
	
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate playerBirth;
	
	@NotNull
	private String birthPlace;
	
	@NotNull
	private String food;
	
	@NotNull
	private String strong;
	
	@NotNull
	private String word;
	
	@NotNull
	private int teamId;
}
