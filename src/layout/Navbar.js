import React, { useState } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css'; // Include Bootstrap CSS
import './Navbar.css'; // Create a corresponding CSS file for additional styling

const App = () => {
  const [isSidebarOpen, setSidebarOpen] = useState(false);

  const handleToggleSidebar = () => {
    setSidebarOpen(!isSidebarOpen);
  };

  return (
    <div className={`app-container ${isSidebarOpen ? 'sidebar-open' : ''}`}>
      <nav className="navbar navbar-dark bg-dark">
        <button
          className="navbar-toggler"
          type="button"
          onClick={handleToggleSidebar}
        >
          <span className="navbar-toggler-icon"></span>
        </button>
        <div className="navbar-brand ml-auto">WizStock</div>
      </nav>
      <div
        className={`container-fluid ${isSidebarOpen ? 'sidebar-open' : 'sidebar-closed'}`}
      >
        <div className="row">
          <nav
            id="sidebar"
            className="col-md-3 col-lg-2 d-md-block bg-light"
          >
            {/* Add your sidebar content here */}
            <div className="sidebar-sticky">
              <ul className="nav flex-column">
                <li className="nav-item">
                  <a className="nav-link active" href="#">
                    Inventory
                  </a>
                </li>
                <li className="nav-item">
                  <a className="nav-link" href="src\Pages\Stock.js">
                    Stock
                  </a>
                </li>
                <li className="nav-item">
                  <button className="nav-link btn btn-link">Logout</button>
                </li>
              </ul>
            </div>
          </nav>
        </div>
      </div>
    </div>
  );
};

export default App;
