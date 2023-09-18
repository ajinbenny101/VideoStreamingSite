import React, { Component } from 'react';
import LeagueTableAtom from '../Atoms/LeagueTableAtom.js';
import axios from 'axios';

class Table extends Component {
  state = {
    teamsData: []
  }

  componentDidMount() {
      axios.get("http://localhost:8088/api/v1/vodApi/all-teams").then(response => {
          this.setState({teamsData: response.data})
      })
  }

  render() {
    const { teamsData} = this.state;
    return (
      <div className="row justify-content-center p-4">
        <div className="col-md-8">
          <div className="table-container p-3 mb-3">
            <h2 className="text-center">League Table</h2>
            <LeagueTableAtom teams={teamsData} />
          </div>
        </div>
      </div>
    );
  }
};

export default Table;
