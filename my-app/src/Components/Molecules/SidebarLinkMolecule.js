import React from 'react';
import IconAtom from '../Atoms/IconAtom';

const SidebarLinkMolecule = ({ iconClass, href, title }) => {
  return (
    <NavLink className="sidebar-link" to={href}>
      <IconAtom iconClass={iconClass} />
      <div>{title}</div>
    </NavLink>
  );
};

export default SidebarLinkMolecule;