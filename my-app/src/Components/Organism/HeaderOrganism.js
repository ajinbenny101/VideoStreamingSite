import React from 'react';
import PropTypes from 'prop-types';
import 'font-awesome/css/font-awesome.min.css';
import NavbarMolecule from '../Molecules/NavbarMolecule';
import NavItemMolecule from '../Molecules/NavItemMolecule';
import IconLinkMolecule from '../Molecules/IconLinkMolecule';
import LogoAtom from '../Atoms/LogoAtom';


const Header = ({ brand }) => {
  return (
    <NavbarMolecule  id="header-ribbon">
      <LogoAtom iconClass="fa fa-futbol" brand={brand} />
      <button
        className="btn btn-outline-secondary"
        type="button"
        data-bs-toggle="offcanvas"
        data-bs-target="#main-siderbar"
        aria-controls="offcanvasDark"
      >
        <i className="fa fa-bars"></i>
      </button>
      <ul className="navbar-nav ms-auto mb-2 mb-lg-0 d-flex align-items-center">
        <NavItemMolecule>
          <IconLinkMolecule iconClass="fa fa-home" href="/" title="Home" />
        </NavItemMolecule>
        <NavItemMolecule>
          <IconLinkMolecule iconClass="fa fa-question" href="/about-us" title="About us" />
        </NavItemMolecule>
        <NavItemMolecule>
          <IconLinkMolecule iconClass="fa fa-sign-out" href="/log-in" title="Log In" />
        </NavItemMolecule>
      </ul>
    </NavbarMolecule>
  );
};

Header.propTypes = {
  brand: PropTypes.string.isRequired,
};

export default Header;

