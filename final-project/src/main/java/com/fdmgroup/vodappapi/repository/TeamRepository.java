package com.fdmgroup.vodappapi.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.fdmgroup.vodappapi.model.Team;

public interface TeamRepository extends JpaRepository<Team, Integer>{
	
	List<Team> findByTeamNameContainingIgnoreCase(String teamName);

	Optional<Team> findSingleTeamByTeamNameIgnoreCase(String teamName);

}
