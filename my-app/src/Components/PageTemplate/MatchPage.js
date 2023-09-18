import React from 'react';
import LeagueTableAtom from '../Atoms/LeagueTableAtom';
import VideoAtom from '../Atoms/VideoAtom';
import ScoreboardOrganism from '../Organism/ScoreboardOrgansim';

const MatchPage = ({ match, teamsData }) => {
    return (
        <div className="container py-5">
            <div className="row mb-5">
                <div className="col-md-8 offset-md-2">
                    <div className="video-container text-center">
                        <VideoAtom url={match.streamURL} />
                    </div>
                </div>
            </div>
            <div className="row justify-content-center">
                <div className="col-md-8">
                    <div className="scoreboard-container p-3 mb-3">
                        <ScoreboardOrganism match={match} />
                    </div>
                </div>
            </div>
            
            <div className="row justify-content-center">
                <div className="col-md-8">
                    <div className="table-container  p-3 mb-3">
                        <h2 className="text-center">League Table</h2>
                        <LeagueTableAtom teams={teamsData} />
                    </div>
                </div>
            </div>
        </div>
    );
};

export default MatchPage;
