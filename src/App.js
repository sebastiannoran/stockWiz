import './App.css';
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap/dist/js/bootstrap'
import {BrowserRouter as Router,Route,Routes} from "react-router-dom"

import Navbar from './layout/Navbar';
import Stock from './Pages/Stock';


function App() {
  return (
    <div className="App">
      
      <Router>
      <Navbar/> 
      <Routes>
        <Route exact path="src/Pages/Stock.js" element={<Stock/>}/>
      </Routes>
      </Router>
      
    </div>
  );
}

export default App;
