import React, { Component } from 'react';
import { useNavigate } from 'react-router-dom';
import InputAtom from '../Atoms/InputAtom';
import ButtonAtom from '../Atoms/ButtonAtom';
import axios from 'axios';
import SearchTeamsPage from '../PageTemplate/SearchTeamsPage';

class SearchBarMolecule extends Component {
  static defaultProps = {
    placeholder: "",
    buttonText: ""
  }

  state = {
    searchInput: "",
    errors: {}
  }

  handleOnChange = (e) => {
    this.setState({ searchInput: e.target.value })
  }

  handleOnSubmit = (e) => {
    e.preventDefault();
    const { searchInput } = this.state;
    console.log(searchInput);
    
    
    if (searchInput === "") {
      this.setState({errors: { searchInput: "Input a value!"}});
      return;
    }
    

  }

  render () {
    const {placeholder, buttonText} = this.props; 
    const {errors} = this.state;
    return (
      <form className="d-flex" role="search" onSubmit={this.handleOnSubmit}>
        <InputAtom 
          className="form-control me-2" 
          type="search" 
          name="searchInput" 
          placeholder={placeholder} 
          aria-label="Search" 
          onchange={this.handleOnChange} 
          error={errors.searchInput}
        />
        <ButtonAtom className="btn btn-outline-success" label={buttonText}  />
      </form>
    );
  }
  
};

export default SearchBarMolecule;