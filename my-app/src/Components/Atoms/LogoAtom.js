import React from 'react';
import PropTypes from 'prop-types';

const LogoAtom = ({ brand, iconClass }) => {
  return (
    <a className="navbar-brand" href="/">
      {iconClass && <i className={iconClass}></i>}
      {brand}
    </a>
  );
};

LogoAtom.propTypes = {
  brand: PropTypes.string.isRequired,
  iconClass: PropTypes.string,
};

export default LogoAtom;
