package com.fdmgroup.vodappapi.VODService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.fdmgroup.vodappapi.exception.MatchExistsException;
import com.fdmgroup.vodappapi.exception.MatchNotFoundException;
import com.fdmgroup.vodappapi.exception.TeamExistsException;
import com.fdmgroup.vodappapi.exception.TeamNotFoundException;
import com.fdmgroup.vodappapi.model.Match;
import com.fdmgroup.vodappapi.model.Team;
import com.fdmgroup.vodappapi.repository.MatchRepository;
import com.fdmgroup.vodappapi.repository.TeamRepository;
import com.fdmgroup.vodappapi.service.VODService;

@SpringBootTest
class VODServiceTest {

	@Autowired
	VODService vodService;

	@MockBean
	TeamRepository mockTeamRepository;
	@MockBean
	MatchRepository mockMatchRepository;
	@MockBean
	Team mockTeam;
	@MockBean
	Match mockMatch;
	@MockBean 
	List<Team> mockTeamsList;

	@Test
	void test_getAllTeams_CallsFindAllFromTeamRepository_whenCalled() {
		vodService.getAllTeams();
		verify(mockTeamRepository).findAll();
	}

	@Test
	void test_getAllMatches_CallsFindAllFromMatchRepository_whenCalled() {
		vodService.getAllMatches();
		verify(mockMatchRepository).findAll();
	}

	@Test
	void test_getTeamById_CallsFindByIdFromTeamRepository_whenCalled() {
		try {
			when(mockTeamRepository.findById(1)).thenReturn(Optional.of(mockTeam));
			assertEquals(mockTeam, vodService.getTeamById(1));
		} catch (TeamNotFoundException e) {
		}

	}

	@Test
	void test_getTeamById_throwsTeamNotFoundException() {
		when(mockTeamRepository.findById(1)).thenReturn(Optional.empty());
		assertThrows(TeamNotFoundException.class, () -> vodService.getTeamById(1));
	}

	@Test
	void test_getMatchById_CallesFindByIdFromMatchRepository_WhenCalled() {
		try {
			when(mockMatchRepository.findById(1)).thenReturn(Optional.of(mockMatch));
			assertEquals(mockMatch, vodService.getMatchById(1));
		} catch (MatchNotFoundException e) {
		}
	}

	@Test
	void test_getMatchById_throwsMatchNotFoundException() {
		when(mockMatchRepository.findById(1)).thenReturn(Optional.empty());
		assertThrows(MatchNotFoundException.class, () -> vodService.getMatchById(1));
	}

	@Test
	void test_addTeamCallsTeamRepositorySave_whenCalledWithValidTeam() {
		
		when(mockTeamRepository.findById(mockTeam.getTeamID())).thenReturn(Optional.empty());
		try {
			vodService.AddTeam(mockTeam);
		} catch (TeamExistsException e) {
		}
		verify(mockTeamRepository).save(mockTeam);
		
	}

	@Test
	void test_addTeam_throwsTeamNotFoundExeption() {
		when(mockTeam.getTeamID()).thenReturn(1);
		when(mockTeamRepository.findById(mockTeam.getTeamID())).thenReturn(Optional.of(mockTeam));
		assertThrows(TeamExistsException.class, () -> vodService.AddTeam(mockTeam));
	}

	@Test
	void test_addMatchCallsMatchRepositorySave_WhenCalledWithAValidMatch(){
		when(mockMatchRepository.findById(mockMatch.getMatchID())).thenReturn(Optional.empty());
		try {
			vodService.AddMatch(mockMatch);
		} catch (MatchExistsException e) {
		}
		verify(mockMatchRepository).save(mockMatch);
	}

	@Test
	void test_addMatch_ThrowsTeamNotFoundException() {
		when(mockMatch.getMatchID()).thenReturn(1);
		when(mockMatchRepository.findById(mockMatch.getMatchID())).thenReturn(Optional.of(mockMatch));
		assertThrows(MatchExistsException.class, () -> vodService.AddMatch(mockMatch));
	}

	@Test
	void test_deleteTeam_callsTeamRepository_WhenTeamIsPresent() {
		when(mockTeamRepository.existsById(1)).thenReturn(true);
		try {
			vodService.deleteTeamById(1);
		} catch (TeamNotFoundException e) {
		}
		verify(mockTeamRepository).deleteById(1);
	}

	@Test
	void test_deleteTeam_throwsTeamNotFoundException() {
		when(mockTeamRepository.existsById(1)).thenReturn(false);
		assertThrows(TeamNotFoundException.class, () -> vodService.deleteTeamById(1));
	}

	@Test
	void test_deleteMatch_CallsMatchrepositorySave_WhenMatchIsPresent() {
		when(mockMatchRepository.existsById(1)).thenReturn(true);
		try {
			vodService.deleteMatchById(1);
		} catch (MatchNotFoundException e) {
		}
		verify(mockMatchRepository).deleteById(1);
	}

	@Test
	void test_deleteMatch_throwsMatchNotFound() {
		when(mockMatchRepository.existsById(1)).thenReturn(false);
		assertThrows(MatchNotFoundException.class, () -> vodService.deleteMatchById(1));
	}

	@Test
	void test_UpdateTeam_CallsTeamRepositorySave_WhenTeamIsValid() {
		when(mockTeamRepository.existsById(mockTeam.getTeamID())).thenReturn(true);
		try {
			vodService.updateTeam(mockTeam);
		} catch (TeamNotFoundException e) {
		}
		verify(mockTeamRepository).save(mockTeam);
	}

	@Test
	void test_updateTeam_throwsTeamNotFoundException() {
		when(mockTeamRepository.existsById(mockTeam.getTeamID())).thenReturn(false);
		assertThrows(TeamNotFoundException.class, () -> vodService.updateTeam(mockTeam));
	}

	@Test
	void test_updateMatch_callsMatchRepository_whenMatchIsValid() {
		when(mockMatchRepository.existsById(mockMatch.getMatchID())).thenReturn(true);
		try {
			vodService.updateMatch(mockMatch);
		} catch (MatchNotFoundException e) {
		}
		verify(mockMatchRepository).save(mockMatch);
	}

	@Test
	void test_updateMatch_ThrowsMatchNotFoundException() {
		when(mockMatchRepository.existsById(mockMatch.getMatchID())).thenReturn(false);
		assertThrows(MatchNotFoundException.class, () -> vodService.updateMatch(mockMatch));
	}
	
	
	@Test
	void test_searchByName_ThrowsTeamNotFoundException() {
		when(mockTeamRepository.findByTeamNameContainingIgnoreCase("teamName")).thenReturn(new ArrayList<>());
		assertThrows(TeamNotFoundException.class, () -> vodService.searchByTeamNameContainingIgnoreCase("teamName"));	
	}
	
	@Test
	void test_searchByName_callsFindByTeamNameFromTeamRepository_whenCalled() {
		try {
			when(mockTeamRepository.findByTeamNameContainingIgnoreCase("teamName")).thenReturn(mockTeamsList);
			assertEquals(mockTeamsList, vodService.searchByTeamNameContainingIgnoreCase("teamName"));
		} catch (TeamNotFoundException e) {
		}
	}

	@Test
void test_searchSingleTeamByName_ThrowsTeamNotFoundException() {
    when(mockTeamRepository.findSingleTeamByTeamNameIgnoreCase("teamName")).thenReturn(Optional.empty());
    assertThrows(TeamNotFoundException.class, () -> vodService.searchSingleTeam("teamName"));
}

@Test
void test_searchSingleTeamByName_callsFindSingleTeamByTeamNameFromTeamRepository_whenCalled() throws TeamNotFoundException {
    when(mockTeamRepository.findSingleTeamByTeamNameIgnoreCase("teamName")).thenReturn(Optional.of(mockTeam));
    assertEquals(Optional.of(mockTeam), vodService.searchSingleTeam("teamName"));
}

	
}
