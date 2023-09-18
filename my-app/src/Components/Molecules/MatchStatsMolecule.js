import React from 'react';
import PropTypes from 'prop-types';

const MatchStatsMolecule = ({ team, possession, shots, shotsOnTarget, passes }) => {
  return (
    <div className="match-stats text-center border p-3">
      <h5>{team} Stats:</h5>
      <p>Possession: {possession}%</p>
      <p>Shots: {shots}</p>
      <p>Shots on Target: {shotsOnTarget}</p>
      <p>Passes: {passes}</p>
    </div>
  );
};

MatchStatsMolecule.propTypes = {
  team: PropTypes.string,
  possession: PropTypes.number,
  shots: PropTypes.number,
  shotsOnTarget: PropTypes.number,
  passes: PropTypes.number,
};

export default MatchStatsMolecule;

