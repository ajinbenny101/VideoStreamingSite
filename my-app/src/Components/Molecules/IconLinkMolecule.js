import React from 'react';
import IconAtom from '../Atoms/IconAtom';
import { NavLink } from 'react-router-dom';

const IconLinkMolecule = ({ iconClass, href, title }) => {
  return (
    <NavLink className="nav-link mx-3" to={href}>
      <IconAtom iconClass={iconClass} />
      {title}
    </NavLink>
  );
};

export default IconLinkMolecule;
