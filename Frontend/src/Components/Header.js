import React from 'react'

function Header() {
    return (
        <div>
        <nav className="navbar bg-dark d-flex px-5">
            <div className="navbar-brand text-light" style={{ fontSize: "30px" }}><span>International Institude of Information Technology, Bangalore</span></div>
            <div className='float-right' style={{BackgroundColor: 'green'}}>
            <button className="btn btn-success btn-lg" onClick={()=>{
                window.localStorage.removeItem('loginuser')
                window.location.reload(true)
            }}>Logout</button> 
            </div>      
        </nav>
    </div>
    )
}
export default Header;