import React from 'react';
import PropTypes from 'prop-types';
import LiveScoreAtom from '../Atoms/LiveScoreAtom';
import MatchStatsMolecule from '../Molecules/MatchStatsMolecule';

const ScoreboardOrganism = ({ match }) => {
  return (
    <div className="scoreboard d-flex flex-column  ">
        <div className="border mb-3 p-3">
          <LiveScoreAtom
            homeTeam={match.homeTeam}
            awayTeam={match.awayTeam}
            location = {match.location}
            kickoffdate = {match.date}
            kickofftime = {match.kickOffTime}
            homeScore={match.homeScore}
            awayScore={match.awayScore}
            className="border-bottom mb-3 pb-3"
          />
          <div className="row mt-3">
            <div className="col-md-6 text-center  border-right pr-3">
              <h4>{match.home_team} Stats</h4>
              <MatchStatsMolecule
                possession={match.homePosesion}
                shots={match.homeShots}
                shotsOnTarget={match.homeShotsOnTarget}
                passes={match.homePasses}
              />
            </div>
            <div className="col-md-6 text-center pl-3">
              <h4>{match.away_team} Stats</h4>
              <MatchStatsMolecule
                possession={match.awayPosesion}
                shots={match.awayShots}
                shotsOnTarget={match.awayShotsOnTarget}
                passes={match.awayPasses}
              />
            </div>
          </div>
        </div>
    </div>
  );
};

ScoreboardOrganism.propTypes = {
  match: PropTypes.shape({
    home_team: PropTypes.string,
    away_team: PropTypes.string,
    home_score: PropTypes.number,
    away_score: PropTypes.number,
    home_posesion: PropTypes.number,
    home_shots: PropTypes.number,
    home_shots_on_target: PropTypes.number,
    home_passes: PropTypes.number,
    away_posesion: PropTypes.number,
    away_shots: PropTypes.number,
    away_shots_on_target: PropTypes.number,
    away_passes: PropTypes.number,
  })
};

export default ScoreboardOrganism;
