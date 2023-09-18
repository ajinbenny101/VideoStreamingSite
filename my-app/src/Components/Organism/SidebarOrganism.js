import React from 'react';
import IconLinkMolecule from '../Molecules/IconLinkMolecule';


const SidebarOrganism = ({sidebarId}) => {
  return (
    <React.Fragment>

      <nav
        className="offcanvas offcanvas-start  text-bg-dark p-3"
        id={sidebarId}
        
      >
        <div className="offcanvas-header">
          <h5 className="offcanvas-title" id="offcanvasDarkLabel">
            OPTIONS
          </h5>
          <button
            className="btn-close btn-close-white"
            type="button"
            data-bs-toggle="offcanvas"
           data-bs-target={"#" + sidebarId}
            aria-controls="offcanvasDark"
          ></button>
        </div>

        <ul className="list-unstyled components">
          <li className = "my-4">
            <IconLinkMolecule iconClass="fa fa-history" href="/results-page" title="Results"/>
          </li>
          <li className = "my-4">
            <IconLinkMolecule iconClass="fa fa-video-camera" href="/log-in" title="Live"/>
          </li>
          <li className = "my-4">
            <IconLinkMolecule iconClass="fa fa-futbol-o" href="/team/Manchester%20United" title="My Team"/>
          </li>
          <li className = "my-4">
            <IconLinkMolecule iconClass="fa fa-table" href="/table" title=" Premier League Table" />
          </li>
        </ul>
      </nav>
    </React.Fragment>
  );
};

export default SidebarOrganism;