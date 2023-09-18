import React from 'react';
import ButtonAtom from '../Atoms/ButtonAtom';
import IconAtom from '../Atoms/IconAtom';

const ButtonIconMolecule = ({ label, iconClass }) => {
  return (
    <ButtonAtom>
      <IconAtom iconClass={iconClass} />
      {label}
    </ButtonAtom>
  );
};

export default ButtonIconMolecule;
