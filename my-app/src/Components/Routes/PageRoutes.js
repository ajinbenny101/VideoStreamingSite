import React, { Component } from 'react'
import Header from '../Organism/HeaderOrganism';
import SidebarOrganism from '../Organism/SidebarOrganism';
import MatchPage from '../PageTemplate/MatchPage';
import HomePage from '../PageTemplate/Homepage';
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import AboutUsPage from "../PageTemplate/AboutUsPage";
import TablePage from "../PageTemplate/TablePage";
import ScoresPage from "../PageTemplate/ScoresPage"
import LoginPage from '../PageTemplate/LoginPage';
import axios from 'axios';
import TeamData from '../PageTemplate/TeamData';

class PageRoutes extends Component {
    state = {
        teamData: [],
        teamFixtureData: []
    }

    componentDidMount() {
        axios.get("http://localhost:8088/api/v1/vodApi/all-teams").then(response => {
            this.setState({teamData: response.data})
        });
        axios.get("http://localhost:8088/api/v1/vodApi/all-matches").then(response => {
            this.setState({teamFixtureData: response.data})
        });
    }

    render() {
        const {teamData, teamFixtureData} = this.state;
        return (
            <Router>
                <Header brand="Football on Demand" />
                <SidebarOrganism sidebarId={"main-siderbar"} />
                <Routes>
                    <Route path="/" element={<HomePage teamFixtureData={teamFixtureData}/>} />
                    {teamFixtureData.map((fixture, index) => (
                        <Route key={index} path={"/match-page-" + fixture.matchID} element={<MatchPage match={fixture} teamsData={teamData} />} />
                    ))}
                    <Route path="/about-us" element={<AboutUsPage />} />
                    <Route path="/table" element={<TablePage />} />
                    <Route path="/log-in" element={<LoginPage />} />
                    <Route path="/results-page" element={<ScoresPage teamFixtureData={teamFixtureData}/>} />
                    {teamData.map((team, index) => (
                        <Route key={index} path={`/team/${team.teamName}`} element={<TeamData team={team} />} />
                    ))}
                </Routes>
            </Router>
        )
    }
}
export default PageRoutes
