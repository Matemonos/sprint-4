import React, { Fragment } from "react";
import Header from "../components/Header";
import Sidebar from "../components/Sidebar";
import Bread from "../components/Bread";
import { Link } from "react-router-dom";
import PanelHeading from "../components/PanelHeading";

const PageBlank = () => {
  return (
    <Fragment>
      <div id="app" className="app app-header-fixed app-sidebar-fixed">
        <Header></Header>
        <Sidebar></Sidebar>
        <div id="content" className="app-content">
          <Bread></Bread>

          <div class="panel panel-inverse">
            <PanelHeading></PanelHeading>
            <div class="panel-body">


              <form data-parsley-validate="true">
                <div class="row mb-3">
                  <label class="form-label col-form-label col-md-3">
                    Nombres
                  </label>
                  <div class="col-md-7">
                    <input
                      type="text"
                      class="form-control"
                      placeholder="Ingrese su nombre"
                      data-parsley-required="true"
                    />
                  </div>
                </div>
                <div class="row mb-3">
                  <label class="form-label col-form-label col-md-3">
                    Apellidos
                  </label>
                  <div class="col-md-7">
                    <input
                      type="text"
                      class="form-control"
                      placeholder="Ingrese sus apellidos"
                      data-parsley-required="true"
                    />
                  </div>
                </div>
                <div class="row mb-3">
                  <label class="form-label col-form-label col-md-3">
                    Email
                  </label>
                  <div class="col-md-7">
                    <input
                      type="text"
                      class="form-control"
                      placeholder="Ingrese su Email"
                      data-parsley-type="email"
                    />
                  </div>
                </div>
                <button type="submit" class="btn btn-primary">Guardar</button>
              </form>
            </div>
          </div>
        </div>
      </div>
    </Fragment>
  );
};

export default PageBlank;
