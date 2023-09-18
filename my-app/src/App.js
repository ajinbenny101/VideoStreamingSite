import React from 'react';
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap/dist/js/bootstrap.bundle";
import './App.css';
import PageRoutes from './Components/Routes/PageRoutes';

const App = () => {
  return (
    <div className="container">
        <PageRoutes />
    </div>
  );
};

export default App;
