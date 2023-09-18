import React from 'react';

const ButtonAtom = ({ label, onClick, className, type }) => {
  return (
    <button onClick={onClick} className={`btn ${className}`} type={type}>
      {label}
    </button>
  );
};

export default ButtonAtom;
