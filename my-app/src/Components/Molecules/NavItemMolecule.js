import React from 'react';

const NavItemMolecule = ({ children }) => {
  return (
    <ul className="navbar-nav me-auto mb-2 mb-lg-0">
      {children}
    </ul>
  );
};

export default NavItemMolecule;