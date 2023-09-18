import React, {Component} from 'react';
import PropTypes from 'prop-types';
import './LeagueTable.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Link } from "react-router-dom";

const LeagueTableAtom = ({ teams }) => {
  

  return (
    <table className="table table-striped table-hover table-bordered">
      <thead className="thead-light">
        <tr>
          <th scope="col">Team</th>
          <th scope="col">Played</th>
          <th scope="col">Won</th>
          <th scope="col">Drawn</th>
          <th scope="col">Lost</th>
          <th scope="col">Points</th>
        </tr>
      </thead>
      <tbody>
        {teams.map((team, index) => (
          <tr key={index}>
            <td><Link to={`/team/${team.teamName}`}>{team.teamName}</Link></td>
            <td>{team.gamesPlayed}</td>
            <td>{team.won}</td>
            <td>{team.draw}</td>
            <td>{team.lost}</td>
            <td>{team.points}</td>
          </tr>
        ))}
      </tbody>
    </table>
  );
};

LeagueTableAtom.propTypes = {
  teams: PropTypes.arrayOf(PropTypes.object).isRequired,
};

export default LeagueTableAtom;
