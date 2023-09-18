import React from 'react';
import PropTypes from 'prop-types';

const VideoAtom = ({ url }) => {
  return (
    <div className="video">
      <iframe

        width="560"
        height="315"
        src={url}
        title="Video"
        frameBorder="0"
        allowFullScreen

      ></iframe>
    </div>
  );
};

VideoAtom.propTypes = {
  url: PropTypes.string.isRequired,
};

export default VideoAtom;
