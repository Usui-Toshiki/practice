CREATE TABLE IF NOT EXISTS myself(
	player_id INT AUTO_INCREMENT PRIMARY KEY,
	player_name VARCHAR(100) NOT NULL,
	age INT NOT NULL,
	player_birth DATE NOT NULL,
	birthPlace VARCHAR(100) NOT NULL,
	strong VARCHAR(100) NOT NULL,
	food VARCHAR(100) NOT NULL,
	word VARCHAR(255) NOT NULL
);


CREATE TABLE IF NOT EXISTS  yourself(
	team_id INT  PRIMARY KEY NOT NULL,
	team_name VARCHAR(45) NOT NULL,
	team_address VARCHAR(45) NOT NULL,
	category VARCHAR(45) NOT NULL
);

CREATE TABLE IF NOT EXISTS  selfer(
	player_id INT AUTO_INCREMENT,
	team_id INT NOT NULL,
	PRIMARY KEY(player_id,team_id),
	FOREIGN KEY(player_id) REFERENCES myself(player_id),
	FOREIGN KEY(team_id) REFERENCES yourself(team_id)
);

