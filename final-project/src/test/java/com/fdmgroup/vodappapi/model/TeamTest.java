package com.fdmgroup.vodappapi.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

class TeamTest {

	@Autowired Team team = new Team();
	
	@Test
	void test_setWonSetsCorrectValue() {
		team.setWon(10);
		assertEquals(10, team.getWon());
	}
	
	@Test
	void test_SetStaduimSetsCorrectStadium() {
		team.setStadium("test");
		assertEquals("test", team.getStadium());
	}
	
	@Test
	void test_setGamesPlayedSetsCorrectValue(){
		team.setGamesPlayed(10);
		assertEquals(10, team.getGamesPlayed());
		}
	
	@Test 
	void test_setLogoSetsLogo() {
		team.setLogo("logo");
		assertEquals("logo",team.getLogo());
	}
	
	@Test
	void test_setNameSetNames() {
		team.setTeamName("name");
		assertEquals("name", team.getTeamName());
	}
}
