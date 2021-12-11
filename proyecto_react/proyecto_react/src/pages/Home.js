import React, { Fragment } from "react";
import Header from "../components/Header";
import Sidebar from "../components/Sidebar";
import Bread from "../components/Bread";
import { Link } from "react-router-dom";

const Home = () => {
  return (
    <Fragment>
      <div id="app" className="app app-header-fixed app-sidebar-fixed">
        <Header></Header>
        <Sidebar></Sidebar>
        <div id="content" className="app-content">
          <Bread></Bread>
          <div className="row">
            <div className="col-xl-3 col-md-6">
              <div className="widget widget-stats bg-blue">
                <div className="stats-icon">
                  <i className="fa fa-desktop"></i>
                </div>
                <div className="stats-info">
                  <h4>TOTAL VISITORS</h4>
                  <p>3,291,922</p>
                </div>
                <div className="stats-link">
                  <Link to="#">
                    View Detail <i className="fa fa-arrow-alt-circle-right"></i>
                  </Link>
                </div>
              </div>
            </div>
            <div className="col-xl-3 col-md-6">
            <div className="widget widget-stats bg-info">
              <div className="stats-icon">
                <i className="fa fa-link"></i>
              </div>
              <div className="stats-info">
                <h4>BOUNCE RATE</h4>
                <p>20.44%</p>
              </div>
              <div className="stats-link">
                <Link to="#">
                  View Detail <i className="fa fa-arrow-alt-circle-right"></i>
                </Link>
              </div>
            </div>
          </div>
          <div className="col-xl-3 col-md-6">
            <div className="widget widget-stats bg-orange">
              <div className="stats-icon">
                <i className="fa fa-users"></i>
              </div>
              <div className="stats-info">
                <h4>UNIQUE VISITORS</h4>
                <p>1,291,922</p>
              </div>
              <div className="stats-link">
                <Link to="#">
                  View Detail <i className="fa fa-arrow-alt-circle-right"></i>
                </Link>
              </div>
            </div>
          </div>
          <div className="col-xl-3 col-md-6">
            <div className="widget widget-stats bg-red">
              <div className="stats-icon">
                <i className="fa fa-clock"></i>
              </div>
              <div className="stats-info">
                <h4>AVG TIME ON SITE</h4>
                <p>00:12:23</p>
              </div>
              <div className="stats-link">
                <Link to="#">
                  View Detail <i className="fa fa-arrow-alt-circle-right"></i>
                </Link>
              </div>
            </div>
          </div>
          </div>
        </div>
      </div>
    </Fragment>
  );
};

export default Home;
