import React from 'react'

const HeadlineMatchOrganism = ({fixture}) => {
  return (
    <a className="featured-match" href="/match-page-1">
      <h2>Featured Match</h2>
      <div className="match-details">
        <div className="team-logo">
          <img src="https://ssl.gstatic.com/onebox/media/sports/logos/udQ6ns69PctCv143h-GeYw_48x48.png" alt="Team Logo" />
          <p>{fixture.homeTeam}</p>
        </div>
        <p className="me-3">vs</p>
        <div className="team-logo">
          <img src="https://ssl.gstatic.com/onebox/media/sports/logos/4us2nCgl6kgZc0t3hpW75Q_96x96.png" alt="Team Logo" />
          <p>{fixture.awayTeam}</p>
        </div>
      </div>
      <div className="match-info">
        <div className="match-location">{fixture.location}</div>
        <div className="match-time">{fixture.date} {fixture.kickOffTime}</div>
      </div>
    </a>
  )
}

HeadlineMatchOrganism.defaultProps = {
  fixture: {
    homeTeam: "",
    awayTeam: "",
    homeLogoUrl: "",
    awayLogoUrl: "",
    location: "",
    date: null,
    kickOffTime: null
  }
}

export default HeadlineMatchOrganism
