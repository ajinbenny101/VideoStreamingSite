import React from 'react';
import PropTypes from 'prop-types';

const NavbarMolecule = ({ children }) => {
  return (
    <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
      <div className="container-fluid">
        {children}
      </div>
    </nav>
  );
};

NavbarMolecule.propTypes = {
  children: PropTypes.node.isRequired,
};

export default NavbarMolecule;
