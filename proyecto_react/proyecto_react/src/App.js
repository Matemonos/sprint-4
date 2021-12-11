import React, {Fragment}  from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import Login from "./pages/auth/Login";
import SignUp from "./pages/auth/SignUp";
import Home from "./pages/Home";
import PageBlank from "./pages/PageBlank";


const App = () => {
  return ( 
    <Fragment>
      <Router>
        <Routes>
          <Route path="/" exact element={<Login/>}/>
          <Route path="/Home" exact element={<Home/>}/>
          <Route path="/page-blank" exact element={<PageBlank/>}/>
          <Route path="/crear-cuenta" exact element={<SignUp/>}/>
        </Routes>
      </Router>
    </Fragment>
   );
}
 
export default App;

