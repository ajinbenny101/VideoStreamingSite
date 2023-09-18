import React from 'react'
import ScorecardMolecule from '../Molecules/ScorecardMolecule';

const ScoresPage = ({teamFixtureData}) => {
  return (
    <React.Fragment>
        {teamFixtureData.map((fixture, index) => (
            <ScorecardMolecule key={index} match={fixture} />
            ))}
    </React.Fragment>
  )
}
export default ScoresPage;