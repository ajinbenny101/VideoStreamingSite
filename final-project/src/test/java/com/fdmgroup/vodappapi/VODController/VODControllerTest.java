package com.fdmgroup.vodappapi.VODController;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.fdmgroup.vodappapi.controller.VODController;
import com.fdmgroup.vodappapi.exception.MatchExistsException;
import com.fdmgroup.vodappapi.exception.MatchNotFoundException;
import com.fdmgroup.vodappapi.exception.TeamExistsException;
import com.fdmgroup.vodappapi.exception.TeamNotFoundException;
import com.fdmgroup.vodappapi.model.Match;
import com.fdmgroup.vodappapi.model.Team;
import com.fdmgroup.vodappapi.service.VODService;

@WebMvcTest(controllers = VODController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class VODControllerTest {

	@Autowired
	VODController vodController;
	@Autowired
	MockMvc mockMvc;

	@MockBean
	VODService mockVodService;
	@MockBean
	Team mockTeam;
	@MockBean
	Match mockMatch;
	@MockBean 
	List<Team> mockTeamsList;

	@Test
	void test_allTeams_callsvodService() {
		vodController.getAllTeams();
		verify(mockVodService).getAllTeams();
	}

	@Test
	void test_allMatches_callsVodService() {
		vodController.getAllMatches();
		verify(mockVodService).getAllMatches();
	}

	@Test
	void test_addTeam_callsVodServiceAddTeam() throws TeamExistsException {
		when(mockVodService.AddTeam(mockTeam)).thenReturn(mockTeam);
		
		MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        vodController.addTeam(mockTeam);
        
        verify(mockVodService).AddTeam(mockTeam);	
	}

	@Test
	void test_addMatch_callsVodServiceAddMatch() throws MatchExistsException {
		
		when(mockVodService.AddMatch(mockMatch)).thenReturn(mockMatch);

		
		MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        vodController.addMatch(mockMatch);
        
        verify(mockVodService).AddMatch(mockMatch);
	}

	@Test
	void test_updateTeam_callsVodServiceUpdateTeam() throws TeamNotFoundException {
		when(mockVodService.updateTeam(mockTeam)).thenReturn(mockTeam);
		
		MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        vodController.updateTeam(mockTeam);
        
        verify(mockVodService).updateTeam(mockTeam);
	}

	@Test
	void test_updateMatch_callsVodServiceUpdateMatch() throws MatchNotFoundException {
		when(mockVodService.updateMatch(mockMatch)).thenReturn(mockMatch);
		
		MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        vodController.updateMatch(mockMatch);
        
        verify(mockVodService).updateMatch(mockMatch);
	}

	@Test
	void test_deleteTeam_callsVodServiceDeleteTeam() throws TeamNotFoundException {
		doNothing().when(mockVodService).deleteTeamById(1);

		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		vodController.deleteTeamById(1);

		verify(mockVodService).deleteTeamById(1);
	}

	@Test
	void test_deleteMatch_callsVodServiceDeleteMatch() throws MatchNotFoundException {
		doNothing().when(mockVodService).deleteMatchById(1);

		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		vodController.deleteMatchById(1);

		verify(mockVodService).deleteMatchById(1);
	}

	@Test
	void test_getTeamById_CallsVodServiceGetTeamById() throws TeamNotFoundException {
		when(mockVodService.getTeamById(1)).thenReturn(mockTeam);
		vodController.getTeamById(1);
		verify(mockVodService).getTeamById(1);
	}

	@Test
	void test_getMatchById_CallsVodServiceGetMatchById() throws MatchNotFoundException {
		when(mockVodService.getMatchById(1)).thenReturn(mockMatch);
		vodController.getMatchById(1);
		verify(mockVodService).getMatchById(1);
	}
	
	@Test
	void test_searchByTeamName_callsVodServiceSearchByTeamName () throws TeamNotFoundException {
		when(mockVodService.searchByTeamNameContainingIgnoreCase("teamName")).thenReturn(mockTeamsList);
		vodController.searchByTeamNameContainingIgnoreCase("teamName");
		verify(mockVodService).searchByTeamNameContainingIgnoreCase("teamName");
	}

	@Test
	void test_searchSingleTeam_callsVodServiceSearchBySingleTeam() throws TeamNotFoundException {
		when(mockVodService.searchSingleTeam("teamName")).thenReturn(Optional.of(mockTeam));
		vodController.searchSingleTeamByTeamName("teamName");
		verify(mockVodService).searchSingleTeam("teamName");
	}


}
