import React from 'react';
import './HomePage.css';
import LeagueMatchesRibbonOrganism from '../Organism/LeagueMatchesRibbonOrganism';
import HeadlineMatchOrganism from '../Organism/HeadlineMatchOrganism';


const HomePage = ({teamFixtureData}) => {
    return ( 
      <React.Fragment>
          <HeadlineMatchOrganism fixture={teamFixtureData[0]} />
          <LeagueMatchesRibbonOrganism teamFixtureData={teamFixtureData}/>
      </React.Fragment>
        
          );
    };
    
   

export default HomePage;
