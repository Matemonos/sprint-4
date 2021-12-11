import React, { useEffect, useState } from "react";
import PanelHeading from "../../components/PanelHeading";
import "./SignUp.css";
import APIInvoke from "../../utils/APIInvoke";
import cifrador from 'js-sha512';   
import swal from "sweetalert";

const SignUp = () => {
  const [usuario, setState] = useState({
    id_rol: 1,
    nombre: "",
    apellido: "",
    telefono: "",
    nombreusuario: "",
    clave: "",
  });

  const { id_rol, nombre, apellido, telefono, nombreusuario, clave } = usuario;

  const onChange = (e) => {
    setState({
      ...usuario,
      [e.target.name]: e.target.value,
    });
  };

  const [rol, setRoles] = useState([]);

  const cargarRoles = async () => {
    const response = await APIInvoke.invokeGET(`/roles`);
    //console.log(response);
    setRoles(response.body);
  };

  useEffect(() => {
      document.getElementById("nombre").focus();
    cargarRoles();
  }, []);

  const crearCuenta = async () => {
    const data = {
      id_rol: {
        id_rol: usuario.id_rol,
      },
      nombre: usuario.nombre,
      apellido: usuario.apellido,
      telefono: usuario.telefono,
      nombreusuario: usuario.nombreusuario,
      clave: cifrador.sha512(usuario.clave)
    };

    const response = await APIInvoke.invokePOST(`/signUp`, data);

    if(response.ok === true){
        const mensaje = response.message;
        swal({
            title: 'Informacion',
            text: mensaje,
            icon: 'success',
            buttons: {
              confirm: {
                text: 'Primary',
                value: true,
                visible: true,
                className: 'btn btn-primary',
                closeModal: true
              }
            }
          });


    }else{
        const mensaje = response.message;
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


        setState({
            id_rol: 1,
            nombre: '',
            apellido: '',
            telefono:'',
            nombreusuario:'',
            clave:''

        })
  };

  const onSubmit = (e) => {
      e.preventDefault();
      crearCuenta();
  };





  return (
    <div id="app" className="app app-header-fixed app-sidebar-fixed">
      <div id="content" className="app-content">
        <div className="panel panel-inverse">
          <PanelHeading titulo={"Crear Cuenta de Usuario"} />
          <div className="panel-body">
            <form onSubmit={onsubmit} data-parsley-validate="true">
              <div className="row mb-3">
                <label className="form-label col-form-label col-md-3">
                  Perfil
                </label>
                <div className="col-md-7">
                  <select
                    className="form-select"
                    style={{ cursor: "pointer" }}
                    id="id_rol"
                    name="id_rol"
                    value={id_rol}
                    onChange={onChange}
                    tabIndex="1"
                    data-parsley-required="true"
                  >
                    {rol.map((item) => (
                      <option key={item.id_rol} value={item.id_rol}>
                        {item.nombre}
                      </option>
                    ))}
                  </select>
                </div>
              </div>

              <div className="row mb-3">
                <label className="form-label col-form-label col-md-3">
                  Nombres
                </label>
                <div className="col-md-7">
                  <input
                    type="text"
                    className="form-control"
                    placeholder="Ingrese su nombre"
                    data-parsley-required="true"
                    id="nombre"
                    name="nombre"
                    value={nombre}
                    onChange={onChange}
                    tabIndex="2"
                  />
                </div>
              </div>

              <div className="row mb-3">
                <label className="form-label col-form-label col-md-3">
                  Apellidos
                </label>
                <div className="col-md-7">
                  <input
                    type="text"
                    className="form-control"
                    placeholder="Ingrese sus apellidos"
                    data-parsley-required="true"
                    id="apellido"
                    name="apellido"
                    value={apellido}
                    onChange={onChange}
                    tabIndex="3"
                  />
                </div>
              </div>

              <div className="row mb-3">
                <label className="form-label col-form-label col-md-3">
                  Telefono
                </label>
                <div className="col-md-7">
                  <input
                    type="text"
                    className="form-control"
                    placeholder="Ingrese su Telefono"
                    data-parsley-type="true"
                    id="telefono"
                    name="telefono"
                    value={telefono}
                    onChange={onChange}
                    tabIndex="4"
                  />
                </div>
              </div>

              <div className="row mb-3">
                <label className="form-label col-form-label col-md-3">
                  Nombre Usuario
                </label>
                <div className="col-md-7">
                  <input
                    type="text"
                    className="form-control"
                    placeholder="Ingrese su nombre de usuario"
                    data-parsley-type="true"
                    id="nombreusuario"
                    name="nombreusuario"
                    value={nombreusuario}
                    onChange={onChange}
                    tabIndex="5"
                  />
                </div>
              </div>

              <div className="row mb-3">
                <label className="form-label col-form-label col-md-3">
                  Contraseña
                </label>
                <div className="col-md-7">
                  <input
                    type="password"
                    className="form-control"
                    placeholder="Ingrese su contraseña"
                    data-parsley-type="true"
                    id="clave"
                    name="clave"
                    value={clave}
                    onChange={onChange}
                    tabIndex="6"
                  />
                </div>
              </div>

              <button type="submit" className="btn btn-primary">
                Guardar
              </button>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
};

export default SignUp;
