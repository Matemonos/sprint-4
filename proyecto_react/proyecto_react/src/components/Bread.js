import React, {Fragment} from 'react';
import { Link } from 'react-router-dom';


const Bread = () => {
    return ( 
        <Fragment>
			<ol className="breadcrumb float-xl-start">
				<li className="breadcrumb-item"><Link to="#">Home</Link></li>
				<li className="breadcrumb-item"><Link to="#">Library</Link></li>
				<li className="breadcrumb-item active">Data</li>
			</ol>
			<h1 className="page-header">&nbsp;<small>&nbsp;</small></h1>
        </Fragment>
     );
}
 
export default Bread;
