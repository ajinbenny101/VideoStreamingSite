import React, { } from 'react';
import './MyTeam.css';

const MyTeamPage = ({ team }) => {
  return (
    <div className="myteam-container">
      <h1 className="team-name">{team.teamName}</h1>
      <div className="row">
        <div className="col-md-6 col-lg-3">
          <img className="team-logo" src={team.logo} alt={team.teamName} />
        </div>
        <div className="col-md-6 col-lg-8">
          <div className="myteam-stats">
            <div className="row">
              <div className="col-4">
                <p className="stat-label">Played</p>
                <p className="stat-value">{team.gamesPlayed}</p>
              </div>
              <div className="col-4">
                <p className="stat-label">Won</p>
                <p className="stat-value">{team.won}</p>
              </div>
              <div className="col-4">
                <p className="stat-label">Stadium</p>
                <p className="stat-value">{team.stadium}</p>
              </div>
            </div>
            <div className="row"
            ><div className="col-4">
                <p className="stat-label">Drawn</p>
                <p className="stat-value">{team.draw}</p>
              </div>
              <div className="col-4">
                <p className="stat-label">Lost</p>
                <p className="stat-value">{team.lost}</p>
              </div>
              <div className="col-4">
                <p className="stat-label">Points</p>
                <p className="stat-value">{team.points}</p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};





export default MyTeamPage;

