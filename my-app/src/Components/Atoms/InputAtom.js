import React from 'react';
import classnames from "classnames"
import PropTypes from 'prop-types';

const InputAtom = ({ type, placeholder, onchange, error }) => {
  return (
    <React.Fragment>
      <input
            type={type}
            className={classnames("form-control me-2", { "is-invalid": error })}
            placeholder={placeholder}
            onChange={onchange}
        />
        {error && <div className='invalid-feedback'>{error}</div>}
    </React.Fragment>
    
  );
};

InputAtom.propTypes = {
  type: PropTypes.string.isRequired,
  placeholder: PropTypes.string.isRequired,
};

export default InputAtom;
 