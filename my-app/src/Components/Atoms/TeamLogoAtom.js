import React, { Component } from 'react';
import axios from 'axios';

class TeamLogoAtom extends Component {
    state = {
        teamLogo: ""
    }

    componentDidMount() {
        axios.get("http://localhost:8088/api/v1/vodApi/search-single-team-" + this.props.teamName).then(response => {
            this.setState({teamLogo: response.data.logo})
        })
    }

    render() {
        const { teamLogo } = this.state;
        return (
            <img src={teamLogo} alt="Team Logo" />
        )
    }
}



export default TeamLogoAtom;