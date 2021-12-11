import React, {Fragment} from 'react';
import { Link } from 'react-router-dom';

const Header= () => {
    return ( 
        <Fragment>
            <div id="header" className="app-header">
			<div className="navbar-header">
				<Link to="/home" className="navbar-brand"><span className="navbar-logo"></span> <b>Color</b> Admin</Link>
				<button type="button" className="navbar-mobile-toggler" data-toggle="app-sidebar-mobile">
					<span className="icon-bar"></span>
					<span className="icon-bar"></span>
					<span className="icon-bar"></span>
				</button>
			</div>
			<div className="navbar-nav">
				<div className="navbar-item navbar-form">
					<form action="" method="POST" name="search">
						<div className="form-group">
							<input type="text" className="form-control" placeholder="Enter keyword" />
							<button type="submit" className="btn btn-search"><i className="fa fa-search"></i></button>
						</div>
					</form>
				</div>
				<div className="navbar-item dropdown">
					<Link to="#" data-bs-toggle="dropdown" className="navbar-link dropdown-toggle fs-14px">
						<i className="fa fa-bell"></i>
						<span className="badge">0</span>
					</Link>
					<div className="dropdown-menu media-list dropdown-menu-end">
						<div className="dropdown-header">NOTIFICATIONS (0)</div>
						<div className="text-center w-300px py-3">
							No notification found
						</div>
					</div>
				</div>
				<div className="navbar-item navbar-user dropdown">
					<Link to="#" className="navbar-link dropdown-toggle d-flex align-items-center" data-bs-toggle="dropdown">
						<div className="image image-icon bg-gray-800 text-gray-600">
							<i className="fa fa-user"></i>
						</div>
						<span className="d-none d-md-inline">Adam Schwartz</span> <b className="caret ms-10px"></b>
					</Link> 
					<div className="dropdown-menu dropdown-menu-end me-1">
						<Link to="#" className="dropdown-item">Edit Profile</Link>
						<Link to="#" className="dropdown-item"><span className="badge badge-danger float-end">2</span> Inbox</Link>
						<Link to="#" className="dropdown-item">Calendar</Link>
						<Link to="#" className="dropdown-item">Setting</Link>
						<div className="dropdown-divider"></div>
						<Link to="#" className="dropdown-item">Log Out</Link>
					</div>
				</div>
			</div>
		</div>
        </Fragment>
     );
}
 
export default Header;