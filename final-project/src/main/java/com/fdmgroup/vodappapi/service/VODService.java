package com.fdmgroup.vodappapi.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fdmgroup.vodappapi.exception.MatchExistsException;
import com.fdmgroup.vodappapi.exception.MatchNotFoundException;
import com.fdmgroup.vodappapi.exception.TeamExistsException;
import com.fdmgroup.vodappapi.exception.TeamNotFoundException;
import com.fdmgroup.vodappapi.model.Match;
import com.fdmgroup.vodappapi.model.Team;
import com.fdmgroup.vodappapi.repository.MatchRepository;
import com.fdmgroup.vodappapi.repository.TeamRepository;

@Service
public class VODService {

	private final static Logger log = LoggerFactory.getLogger(VODService.class);
	private TeamRepository teamRepository;
	private MatchRepository matchRepository;

	public VODService(TeamRepository teamRepository, MatchRepository matchRepository) {
		this.teamRepository = teamRepository;
		this.matchRepository = matchRepository;
	}

	/**
	 * @return list of teams from team repository
	 */
	public List<Team> getAllTeams() {
		log.info("api-service got team list from database");
		return teamRepository.findAll();
	}

	/**
	 * @return list of all matches from match repository
	 */
	public List<Match> getAllMatches() {
		log.info("api-service got match list from database");
		return matchRepository.findAll();
	}

	/**
	 * 
	 * @param id
	 * @return team with inputed id from team database
	 * 
	 */
	public Team getTeamById(int id) throws TeamNotFoundException {
		Optional<Team> foundTeam = teamRepository.findById(id);
		if (foundTeam.isPresent()) {
			log.info("api-service found team");
			return foundTeam.get();
		}
		throw new TeamNotFoundException("team with id " + id + " not found");
	}

	/**
	 * 
	 * @param id
	 * @return match with inputed id from team database
	 * 
	 */
	public Match getMatchById(int id) throws MatchNotFoundException {
		Optional<Match> foundMatch = matchRepository.findById(id);
		if (foundMatch.isPresent()) {
			log.info("api-service found match");
			return foundMatch.get();
		}
		throw new MatchNotFoundException("match with id " + id + " not found");
	}

	/**
	 * 
	 * @param team
	 * @return adds a team to database
	 * 
	 */
	public Team AddTeam(Team team) throws TeamExistsException {
		Optional<Team> optionalTeam = teamRepository.findById(team.getTeamID());
		if (optionalTeam.isPresent()) {
			throw new TeamExistsException("Team " + team.getTeamID() + " already exists, cannot persist");
		}
		log.info("persisting team to team database");
		return teamRepository.save(team);
	}

	/**
	 * 
	 * @param match
	 * @return adds a match to match database
	 */
	public Match AddMatch(Match match) throws MatchExistsException {
		Optional<Match> optionalMatch = matchRepository.findById(match.getMatchID());
		if (optionalMatch.isPresent()) {
			throw new MatchExistsException("Match " + match.getMatchID() + " already exists, cannot persist");
		}
		log.info("persisting match to match database");
		return matchRepository.save(match);
	}

	/**
	 * Deletes team by id
	 * 
	 * @param id
	 *
	 */
	public void deleteTeamById(int id) throws TeamNotFoundException {
		if (teamRepository.existsById(id)) {
			log.info("deleting Team from database");
			teamRepository.deleteById(id);
		} else {
			throw new TeamNotFoundException("No team with id " + id + " to delete");
		}
	}

	/**
	 * deletes match by id
	 * 
	 * @param id
	 * 
	 */
	public void deleteMatchById(int id) throws MatchNotFoundException {
		if (matchRepository.existsById(id)) {
			log.info("deleting match from database");
			matchRepository.deleteById(id);
		} else {
			throw new MatchNotFoundException("No match with id " + id + " to delete");
		}
	}

	/**
	 * updates the team
	 * 
	 * @param team
	 * @return team updated
	 * 
	 */
	public Team updateTeam(Team team) throws TeamNotFoundException {
		if (teamRepository.existsById(team.getTeamID())) {
			log.info("updating team");
			return teamRepository.save(team);
		}
		throw new TeamNotFoundException("team with id " + team.getTeamID() + " is not present");
	}

	/**
	 * match updating
	 * 
	 * @param match
	 * @return updated match
	 * 
	 */
	public Match updateMatch(Match match) throws MatchNotFoundException {
		if (matchRepository.existsById(match.getMatchID())) {
			log.info("saving match");
			return matchRepository.save(match);
		}
		throw new MatchNotFoundException("match with id " + match.getMatchID() + " is not present");
	}

	/**
	 * team search by name
	 * 
	 * @param string team name
	 * @return list of teams that match string
	 * 
	 * 
	 */
	public List<Team> searchByTeamNameContainingIgnoreCase(String teamName) throws TeamNotFoundException {
		List<Team> teams = teamRepository.findByTeamNameContainingIgnoreCase(teamName);
		if (teams.isEmpty()) {
			throw new TeamNotFoundException("no teams matching " + teamName + " found");
		} else {
			log.info("searching for teams");
			return teamRepository.findByTeamNameContainingIgnoreCase(teamName);
		}
	}

	public Optional<Team> searchSingleTeam(String teamName) throws TeamNotFoundException{
		Optional<Team> foundTeam = teamRepository.findSingleTeamByTeamNameIgnoreCase(teamName);
		if(foundTeam.isPresent()){
			return foundTeam;
		}
		throw new TeamNotFoundException("team not found");
	}

}
