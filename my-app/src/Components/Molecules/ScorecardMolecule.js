import React from 'react';
import { NavLink } from 'react-router-dom';
import TeamLogoAtom from '../Atoms/TeamLogoAtom';

const ScorecardMolecule = ({match}) => {
  return (
    <NavLink className="score-card" to={"/match-page-" + match.matchID}>
        <TeamLogoAtom teamName={match.homeTeam} />
        <h2>{match.homeTeam}</h2>
        <h2>{match.homeScore}</h2>
        <h2>VS</h2>
        <h2>{match.awayScore}</h2>
        <h2>{match.awayTeam}</h2>
        <TeamLogoAtom teamName={match.awayTeam} />
    </NavLink>
  );
}
export default ScorecardMolecule