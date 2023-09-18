import React from 'react';
import PropTypes from 'prop-types';

const LiveScoreAtom = ({ homeTeam, awayTeam, homeScore, awayScore, location, kickoffdate, kickofftime }) => {
  return (
    <div className="live-score border rounded p-3 mb-3">
      <h2 className="text-center">{homeTeam} vs {awayTeam}</h2>
      <h4 className="text-center">{location}</h4>
      <h6 className="text-center">{kickoffdate} AT {kickofftime}</h6>
      
      <div className="score">
        <span className="home-score">{homeScore}</span> - <span className="away-score">{awayScore}</span>
        
      </div>
    </div>
  );
};

LiveScoreAtom.propTypes = {
  homeTeam: PropTypes.string,
  awayTeam: PropTypes.string,
  location: PropTypes.string,
  homeScore: PropTypes.number,
  awayScore: PropTypes.number,
 
};

export default LiveScoreAtom;
