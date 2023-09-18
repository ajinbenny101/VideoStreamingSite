import { NavLink } from 'react-router-dom';
import TeamLogoAtom from '../Atoms/TeamLogoAtom';

const MatchMolecule = ({fixture}) => {
  return (
    <NavLink id="link-card" className="card d-flex justify-content-center" to={"/match-page-" + fixture.matchID}>
      <div className="card-img-top align-self-center">
        <div className="match-details d-flex justify-content-center align-items-center">
          <div className="team-logo">
            <TeamLogoAtom teamName={fixture.homeTeam} />
          </div>
          <p className="m-0 mx-3">vs</p>
          <div className="team-logo">
            <TeamLogoAtom teamName={fixture.awayTeam} />
          </div>
        </div>
      </div>
      <div className="card-body">
        <h5 className="card-title text-wrap text-center">{fixture.homeTeam} vs {fixture.awayTeam}</h5>
      </div>
      <ul className="list-group list-group-flush">
        <li className="list-group-item"><b>Location: </b> {fixture.location}</li>
        <li className="list-group-item"><b>Date: </b> {fixture.date}</li>
        <li className="list-group-item"><b>Kick-Off Time: </b> {fixture.kickOffTime}</li>
      </ul>
    </NavLink> 
  )
}

export default MatchMolecule;
