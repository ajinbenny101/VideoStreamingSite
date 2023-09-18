import React, { useState } from 'react';
import loginData from '../Data/loginData.json';

function LoginPage() {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [isLoggedIn, setIsLoggedIn] = useState(false);
  const [error, setError] = useState(null);

  const handleLogin = (event) => {
    event.preventDefault();

    const user = loginData.users.find(u => u.email === email);

    if (!user) {
      setError('Invalid email or password');
      return;
    }

    if (user.password === password) {
      localStorage.setItem('token', user.token);
      setIsLoggedIn(true);
    } else {
      setError('Invalid email or password');
    }
  };

  return (
    <div style={{ display: 'flex', flexDirection: 'column', alignItems: 'center', justifyContent: 'center', height: '100vh' }}>
      {isLoggedIn ? (
        <div style={{ display: 'flex', flexDirection: 'column', alignItems: 'center' }}>
          <h3>You are logged in!</h3>
          <div style={{ marginTop: '32px' }}>
            <iframe width="560" height="315" src="https://www.youtube.com/embed/dQw4w9WgXcQ"  allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowFullScreen></iframe>
            <h3 style={{ marginTop: '16px' }}>You are watching the current game</h3>
          </div>
        </div>
      ) : (
        <div style={{ backgroundColor: '#f7f7f7', borderRadius: '8px', padding: '24px', boxShadow: '0px 0px 8px rgba(0, 0, 0, 0.2)' }}>
          <form onSubmit={handleLogin} style={{ display: 'flex', flexDirection: 'column', alignItems: 'center', justifyContent: 'center' }}>
            <h2>Login</h2>
            <div style={{ marginBottom: '16px' }}>
              <label htmlFor="email">Email:</label>
              <input type="email" id="email" value={email} onChange={(event) => setEmail(event.target.value)} style={{ border: '2px solid #ccc', borderRadius: '4px', padding: '8px', marginTop: '8px', width: '100%', fontSize: '16px' }} />
            </div>
            <div style={{ marginBottom: '16px' }}>
              <label htmlFor="password">Password:</label>
              <input type="password" id="password" value={password} onChange={(event) => setPassword(event.target.value)} style={{ border: '2px solid #ccc', borderRadius: '4px', padding: '8px', marginTop: '8px', width: '100%', fontSize: '16px' }} />
            </div>
            {error && <div style={{ color: 'red', marginBottom: '16px' }}>{error}</div>}
            <button type="submit" style={{ backgroundColor: '#0066cc', color: '#fff', border: 'none', borderRadius: '4px', padding: '8px 16px', cursor: 'pointer', fontSize: '16px', transition: 'background-color 0.2s ease-in-out' }}>Login</button>
          </form>
        </div>
      )}


    </div>
  );
}

export default LoginPage;
