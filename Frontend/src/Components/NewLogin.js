import React, { useState } from "react";
import axios from 'axios';


const NewLogin = () => {

    const loginBaseURL = `http://localhost:8080/api/employee/login`

    const [user_id, setUser_id] = useState('')
    const [password, setPassword] = useState('')


    const loginHandler = (event) => {
        event.preventDefault();
        login();
    }

    const login = async () => {
        await axios.post(loginBaseURL, {
            email: user_id,
            password: password
        })
            .then(function (response) {
                console.log(response.data);
                window.localStorage.setItem('loginuser', JSON.stringify(response.data))
                window.location.reload(true)
                // var reply = JSON.parse(window.localStorage.getItem('loginuser'))
                // console.log("from local storage", reply)
            })
            .catch(function (error) {
                console.log(error);
                alert("Invalid Credentials!")
                window.location.reload(true)
            });


    }

    return (
        <form onSubmit={loginHandler} id='login-form'>
            <section className="vh-80 gradient-custom">
                <div className="container py-3 h-100">
                    <div className="row d-flex justify-content-center align-items-center h-100">
                        <div className="col-12 col-md-8 col-lg-6 col-xl-5">
                            <div className="card bg-dark text-white" style={{ borderRadius: "1rem" }}>
                                <div className="card-body p-5 text-center">

                                    <div className="mb-md-5 mt-md-4 pb-5">

                                        <h2 className="fw-bold mb-2 text-uppercase">Login</h2>
                                        <p className="text-white-50 mb-5">Please enter your login and password!</p>

                                        <div className="form-outline form-white mb-4">
                                            <input type="email"
                                                placeholder="Email......"
                                                value={user_id}
                                                onChange={event => setUser_id(event.target.value)}
                                                id="form2Example1"
                                                className="form-control form-control-lg" required />
                                            <label className="form-label" htmlFor="form2Example1">Email</label>
                                        </div>

                                        <div className="form-outline form-white mb-4">
                                            <input type="password"
                                                placeholder="Password....."
                                                value={password}
                                                onChange={event => setPassword(event.target.value)}
                                                id="form2Example2"
                                                className="form-control form-control-lg" required />
                                            <label className="form-label" htmlFor="form2Example2">Password</label>
                                        </div>
                                        <button className="btn btn-outline-light btn-lg px-5" type="submit">Login</button>


                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </form>
    );

}
export default NewLogin;