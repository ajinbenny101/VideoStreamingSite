package com.fdmgroup.vodappapi.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/*
 * Updated: - made this the only class that handles results
 * 			- added streamUrl as a string
 * 
 * ToDo: - make this a mix of match fixture and result... (allow null values for future data, alias them when requested) 
 */
@Entity
public class Match {
	
	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "MATCH_ID_GEN")
	@SequenceGenerator(name = "MATCH_ID_GEN", sequenceName = "employee_id_sequence", allocationSize = 1, initialValue = 10)
	private int matchID;
	
	@NotBlank(message = "Home Team must be specified")
	@Size(max = 50)
	private String homeTeam;
	
	@NotBlank(message = "Away Team must be specfied")
	@Size(max = 50)
	private String awayTeam;
	
	@NotBlank(message = "Location must be specified")
	@Size(max = 50)
	private String location;
	
	
	@Column(name = "match_dates")
	private LocalDate date;
	
	
	private LocalTime kickOffTime;
	
	@Min(value = 0, message = "Home score cannot be negative")
	private byte homeScore;
	
	@Min(value = 0, message = "Away score cannot be negative")
	private byte awayScore;
	
	@NotBlank(message = "Stream URL cannot be blank")
	private String streamURL;
	
	@Min(value = 0, message = "Home Team possession cannot be negative")
	@Max(value = 100, message = "Home Team possession cannot be greater than 100")
	private int homePosesion;
	
	@Min(value = 0, message = "Away Team possession cannot be negative")
	@Max(value = 100, message = "Away Team possession cannot be greater than 100")
	private int awayPosesion;
	
	@Min(value = 0, message = "Shots cannot be less than zero")
	private int homeShots;
	
	@Min(value = 0, message = "Shots cannot be less than zero")
	private int awayShots;
	
	@Min(value = 0, message = "Shots cannot be less than zero")
	private int homeShotsOnTarget;
	
	@Min(value = 0, message = "Shots cannot be less than zero")
	private int awayShotsOnTarget;
	
	@Min(value = 0, message = "Passes cannot be less than zero")
	private int homePasses;
	
	@Min(value = 0, message = "Passes cannot be less than zero")
	private int awayPasses;

	public Match() {}
	
	public Match(String homeTeam, String awayTeam, String location, LocalTime kickOffTime, String streamURL) {
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.location = location;
		this.kickOffTime = kickOffTime;
		this.streamURL = streamURL;
	}

	public int getMatchID() {
		return matchID;
	}

	public void setMatchID(int matchID) {
		this.matchID = matchID;
	}

	public String getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(String homeTeam) {
		this.homeTeam = homeTeam;
	}

	public String getAwayTeam() {
		return awayTeam;
	}

	public void setAwayTeam(String awayTeam) {
		this.awayTeam = awayTeam;
	}

	public LocalTime getKickOffTime() {
		return kickOffTime;
	}

	public void setKickOffTime(LocalTime kickOffTime) {
		this.kickOffTime = kickOffTime;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getStreamURL() {
		return streamURL;
	}

	public void setStreamURL(String streamURL) {
		this.streamURL = streamURL;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public byte getHomeScore() {
		return homeScore;
	}

	public void setHomeScore(byte homeScore) {
		this.homeScore = homeScore;
	}

	public byte getAwayScore() {
		return awayScore;
	}

	public void setAwayScore(byte awayScore) {
		this.awayScore = awayScore;
	}

	public int getHomePosesion() {
		return homePosesion;
	}

	public void setHomePosesion(int homePosesion) {
		this.homePosesion = homePosesion;
	}

	public int getAwayPosesion() {
		return awayPosesion;
	}

	public void setAwayPosesion(int awayPosesion) {
		this.awayPosesion = awayPosesion;
	}

	public int getHomeShots() {
		return homeShots;
	}

	public void setHomeShots(int homeShots) {
		this.homeShots = homeShots;
	}

	public int getAwayShots() {
		return awayShots;
	}

	public void setAwayShots(int awayShots) {
		this.awayShots = awayShots;
	}

	public int getHomeShotsOnTarget() {
		return homeShotsOnTarget;
	}

	public void setHomeShotsOnTarget(int homeShotsOnTarget) {
		this.homeShotsOnTarget = homeShotsOnTarget;
	}

	public int getAwayShotsOnTarget() {
		return awayShotsOnTarget;
	}

	public void setAwayShotsOnTarget(int awayShotsOnTarget) {
		this.awayShotsOnTarget = awayShotsOnTarget;
	}

	public int getHomePasses() {
		return homePasses;
	}

	public void setHomePasses(int homePasses) {
		this.homePasses = homePasses;
	}

	public int getAwayPasses() {
		return awayPasses;
	}

	public void setAwayPasses(int awayPasses) {
		this.awayPasses = awayPasses;
	}

}
