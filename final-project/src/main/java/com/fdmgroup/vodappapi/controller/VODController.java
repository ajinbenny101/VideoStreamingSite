package com.fdmgroup.vodappapi.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fdmgroup.vodappapi.exception.MatchExistsException;
import com.fdmgroup.vodappapi.exception.MatchNotFoundException;
import com.fdmgroup.vodappapi.exception.TeamExistsException;
import com.fdmgroup.vodappapi.exception.TeamNotFoundException;
import com.fdmgroup.vodappapi.model.Match;
import com.fdmgroup.vodappapi.model.Team;
import com.fdmgroup.vodappapi.service.VODService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/vodApi")

public class VODController {

	private final static Logger log = LoggerFactory.getLogger(VODController.class);
	private VODService vodService;

	public VODController(VODService vodService) {
		this.vodService = vodService;
	}

	@GetMapping("/all-teams")
	public ResponseEntity<List<Team>> getAllTeams() {
		log.info("api-controller get all teams called");
		return ResponseEntity.status(HttpStatus.OK).body(vodService.getAllTeams());
	}

	@GetMapping("/all-matches")
	public ResponseEntity<List<Match>> getAllMatches() {
		log.info("api-controller get all teams called");
		return ResponseEntity.status(HttpStatus.OK).body(vodService.getAllMatches());
	}

	@PostMapping("/add-team")
	public ResponseEntity<Void> addTeam(@Valid @RequestBody Team team) throws TeamExistsException {
		Team createdTeam = vodService.AddTeam(team);
		log.info("api controller adds team: " + team);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(createdTeam.getTeamID()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PostMapping("/add-match")
	public ResponseEntity<Void> addMatch(@Valid @RequestBody Match match) throws MatchExistsException {
		Match createdMatch = vodService.AddMatch(match);
		log.info("api controller adds match: " + match);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(createdMatch.getMatchID()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping("/update-team")
	public ResponseEntity<Team> updateTeam(@Valid @RequestBody Team team) throws TeamNotFoundException {
		log.info("api controller is updating: " + team);
		return ResponseEntity.status(HttpStatus.OK).body(vodService.updateTeam(team));
	}

	@PutMapping("/update-match")
	public ResponseEntity<Match> updateMatch(@Valid @RequestBody Match match) throws MatchNotFoundException {
		log.info("api controller is updating: " + match);
		return ResponseEntity.status(HttpStatus.OK).body(vodService.updateMatch(match));
	}

	@DeleteMapping("/delete-team-{id}")
	public ResponseEntity<Void> deleteTeamById(@PathVariable int id) throws TeamNotFoundException {
		vodService.deleteTeamById(id);
		log.info("api controller is deleting team");
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@DeleteMapping("/delete-match-{id}")
	public ResponseEntity<Void> deleteMatchById(@PathVariable int id) throws MatchNotFoundException {
		vodService.deleteMatchById(id);
		log.info("api controller is deleting team");
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@GetMapping("/get-team-{id}")
	public ResponseEntity<Team> getTeamById(@PathVariable int id) throws TeamNotFoundException {
		log.info("fetching team with id: " + id);
		return ResponseEntity.status(HttpStatus.OK).body(vodService.getTeamById(id));
	}

	@GetMapping("/get-match-{id}")
	public ResponseEntity<Match> getMatchById(@PathVariable int id) throws MatchNotFoundException {
		log.info("fetching match with id: " + id);
		return ResponseEntity.status(HttpStatus.OK).body(vodService.getMatchById(id));
	}

	@GetMapping("/search-team-{teamName}")
	public ResponseEntity<List<Team>> searchByTeamNameContainingIgnoreCase(@PathVariable String teamName)
			throws TeamNotFoundException {
		log.info("fetching teams matching " + teamName);
		return ResponseEntity.status(HttpStatus.OK).body(vodService.searchByTeamNameContainingIgnoreCase(teamName));
	}

	@GetMapping("/search-single-team-{teamName}")
	public ResponseEntity<Optional<Team>> searchSingleTeamByTeamName(@PathVariable String teamName) throws TeamNotFoundException{
		log.info("found team: " + teamName);
		return ResponseEntity.status(HttpStatus.OK).body(vodService.searchSingleTeam(teamName));
	}

}
