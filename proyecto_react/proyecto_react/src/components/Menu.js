import React, {Fragment} from 'react';
import { Link } from 'react-router-dom';

const Menu = () => {
    return ( 
        <Fragment>
				<div className="menu">
					<div className="menu-profile">
						<Link to="#" className="menu-profile-link" data-toggle="app-sidebar-profile" data-target="#appSidebarProfileMenu">
							<div className="menu-profile-cover with-shadow"></div>
							<div className="menu-profile-image menu-profile-image-icon bg-gray-900 text-gray-600">
								<i className="fa fa-user"></i>
							</div>
							<div className="menu-profile-info">
								<div className="d-flex align-items-center">
									<div className="flex-grow-1">
										Sean Ngu
									</div>
									<div className="menu-caret ms-auto"></div>
								</div>
								<small>Front end developer</small>
							</div>
						</Link>
					</div>
					<div id="appSidebarProfileMenu" className="collapse">
						<div className="menu-item pt-5px">
							<Link to="#" className="menu-link">
								<div className="menu-icon"><i className="fa fa-cog"></i></div>
								<div className="menu-text">Settings</div>
							</Link>
						</div>
						<div className="menu-item">
							<Link to="#" className="menu-link">
								<div className="menu-icon"><i className="fa fa-pencil-alt"></i></div>
								<div className="menu-text"> Send Feedback</div>
							</Link>
						</div>
						<div className="menu-item pb-5px">
							<Link to="#" className="menu-link">
								<div className="menu-icon"><i className="fa fa-question-circle"></i></div>
								<div className="menu-text"> Helps</div>
							</Link>
						</div>
						<div className="menu-divider m-0"></div>
					</div>
					<div className="menu-header">Navigation</div>
					<div className="menu-item active">
						<Link to="/home" className="menu-link">
							<div className="menu-icon">
								<i className="fa fa-th-large"></i>
							</div>
							<div className="menu-text">Home</div>
						</Link>
					</div>
					
					<div className="menu-item has-sub">
						<Link to="#" className="menu-link">
							<div className="menu-icon">
								<i className="fa fa-align-left"></i>
							</div>
							<div className="menu-text">Menu Level</div>
							<div className="menu-caret"></div>
						</Link>
						<div className="menu-submenu">
							
							<div className="menu-item"><Link to="/page-blank" className="menu-link"><div className="menu-text">Page Blank</div></Link></div>
							<div className="menu-item"><Link to="#" className="menu-link"><div className="menu-text">Menu 1.3</div></Link></div>
						</div>
					</div>
					
					<div className="menu-item d-flex">
						<Link to="#" className="app-sidebar-minify-btn ms-auto" data-toggle="app-sidebar-minify"><i className="fa fa-angle-double-left"></i></Link>
					</div>
				</div>
        </Fragment>
     );
}
 
export default Menu;
