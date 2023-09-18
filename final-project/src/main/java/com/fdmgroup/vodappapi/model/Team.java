package com.fdmgroup.vodappapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TEAM_ID_GEN")
	@SequenceGenerator(name = "TEAM_ID_GEN", sequenceName = "team_id_sequence", allocationSize = 1, initialValue = 20)
	private int teamID;
	
	@NotBlank(message = "Team name must be specified")
	@Size(max = 50)
	private String teamName;
	
	@NotBlank(message = "Logo must be provided")
	private String logo;
	
	@NotBlank(message = "Location must be specified")
	@Size(max = 50)
	private String stadium;
	
	@Min(value = 0, message = "Games played cannot be less than zero")
	private int gamesPlayed;
	
	@Min(value = 0, message = "Games won cannot be less than zero")
	private int won;
	
	@Min(value = 0, message = "Games drawn cannot be less than zero")
	private int draw;
	
	@Min(value = 0, message = "Games lost cannot be less than zero")
	private int lost;
	
	@Min(value = 0, message = "Points cannot be less than zero")
	private int points;
	
	public Team() {}
	
	public int getGamesPlayed() {
		return gamesPlayed;
	}

	public void setGamesPlayed(int gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}

	public int getWon() {
		return won;
	}

	public void setWon(int won) {
		this.won = won;
	}

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

	public int getLost() {
		return lost;
	}

	public void setLost(int lost) {
		this.lost = lost;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public Team(String teamName, String logo, String stadium, byte currentPosition) {
		this.teamName = teamName;
		this.logo = logo;
		this.stadium = stadium;
	}

	public int getTeamID() {
		return teamID;
	}

	public void setTeamID(int teamID) {
		this.teamID = teamID;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getStadium() {
		return stadium;
	}

	public void setStadium(String stadium) {
		this.stadium = stadium;
	}

}
