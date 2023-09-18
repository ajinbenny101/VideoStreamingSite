import React from 'react';
import LeagueTitleAtom from '../Atoms/LeagueTitleAtom';
import MatchMolecule from '../Molecules/MatchMolecule';

const LeagueMatchesRibbonOrganism = ({teamFixtureData}) => {
  return (
    <div className='card my-4 mx-2'>
      <LeagueTitleAtom leagueName="Premier League" />
      <div className='card-body'>
        <ul className="horizontal-slider">
          {teamFixtureData.map((match, index) => (
            <li className='item' key={match.matchID}>
              <MatchMolecule fixture={match} />
            </li>
          ))}
        </ul>
      </div>
    </div>
  );
};

export default LeagueMatchesRibbonOrganism;
