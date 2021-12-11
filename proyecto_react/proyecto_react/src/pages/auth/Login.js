import React, { Fragment, useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import cifrador from 'js-sha512'
import APIInvoke from "../../utils/APIInvoke";
import swal from "sweetalert";

const Login = () => {

    const navigate = useNavigate();


   const [Usuario, setUsuario] = useState({
        nombreusuario:'',
        clave:''
   });

   const {nombreusuario, clave} = Usuario;


   const onChange = (e) => {
     setUsuario({
       ...Usuario,
       [e.target.name]: e.target.value
     })
  };

  useEffect(() => {
    document.getElementById("nombreusuario").focus();
  }, []);

  const iniciarSesion = async () => {
    const data = {
      nombreusuario: Usuario.nombreusuario,
      clave: cifrador.sha512(Usuario.clave)
    }

    const response = await APIInvoke.invokePOST(`/login`, data);

  }

 const onsubmit = (e) => {
    e.proventDefault();
    

    if(iniciarSesion()){

      setTimeout(() => {
        navigate("/home");
      }, 1000);

    }else{
      navigate("/")

      const mensaje = 'no fue posible iniciar sesion ';
        swal({
            title: 'Error',
            text: mensaje,
            icon: 'error',
            buttons: {
              confirm: {
                text: 'Ok',
                value: true,
                visible: true,
                className: 'btn btn-danger',
                closeModal: true
              }
            }
          });
    }
 }



  return (
    <Fragment>
      <div id="app" className="app">
        <div className="login login-v1">
          <div className="login-container">
            <div className="login-header">
              <div className="brand">
                <div className="d-flex align-items-center">
                  <span className="logo"></span> <b>Iniciar&nbsp;</b> Sesion
                </div>
                <small>Bienvenido, Ingrese sus credenciales</small>
              </div>
              <div className="icon">
                <i className="fa fa-lock"></i>
              </div>
            </div>

            <div className="login-body">
              <div className="login-content fs-13px">
                <form onSubmit={onsubmit} data-parsley-validate="true">
                  <div className="form-floating mb-20px">
                    <input
                      type="email"
                      className="form-control fs-13px h-45px"
                      id="nombreusuario"
                      name="nombreusuario"
                      value={nombreusuario}
                      onChange={onChange}
                      data-parsley-required="true"
                      tabIndex="1"
                      placeholder="Email Address"
                    />
                    <label
                      htmlFor="emailAddress"
                      className="d-flex align-items-center py-0"
                    >
                      Email
                    </label>
                  </div>
                  <div className="form-floating mb-20px">
                    <input
                      type="password"
                      className="form-control fs-13px h-45px"
                      id="clave"
                      name="clave"
                      value={clave}
                      onChange={onChange}
                      data-parsley-required="true"
                      placeholder="Contraseña"
                      tabIndex="2"
                    />
                    <label
                      htmlFor="password"
                      className="d-flex align-items-center py-0"
                    >
                      Contraseña
                    </label>
                  </div>
                  
                  <div className="login-buttons">
                    <Link to = {"/crear-cuenta"}
                      className="btn h-45px btn-green d-block w-100 btn-lg">
                      Crear Cuenta
                    </Link>
                    </div>

                  <br/>


                  <div className="login-buttons">
                    <button
                      type="submit"
                      className="btn h-45px btn-primary d-block w-100 btn-lg">
                      Ingresar
                    </button>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
      <h1>Login</h1>
    </Fragment>
  );
};

export default Login;
