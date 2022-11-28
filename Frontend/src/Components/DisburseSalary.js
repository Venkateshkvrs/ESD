import React, { useState, useEffect } from "react";
import axios from "axios";
const DisburseSalary = ({ employees }) => {
    const [isChecked, setisChecked] = useState([]);
    const handlecheckbox = (e) => {
        const { value, checked } = e.target;
        console.log(value);
        if (checked) {
            setisChecked([...isChecked, value]);
        } else {
            setisChecked(isChecked.filter((e) => e !== value));
        }
    }
    const disburseURL = `http://localhost:8080/api/employee_salary/disburse_salaryById`
    const disburse = async (empList) => {
        let res = await axios.post(disburseURL, empList)

        if (res.status === 200) {
            alert("Salary Disbursement Success!")
        }
        else {
            alert("Failure, Try Again!")
        }
        window.location.reload(true)
        // console.log("Disburse Status: ",res.data)
        console.log("Disburse Code: ", res.status)
        // console.log(disburseStatus)
    }
    
    
    const allDisburse = async () => {
        console.log("Is Checked: ", isChecked);
        if (isChecked.length !== 0) {
            const parList = isChecked.map((curObj) => {
                return { "employee_id": parseInt(curObj)};
            })
            disburse(parList)
        }
        else {
            alert("please Select at least one check box !");
        }

    }

    return (
        <React.Fragment>
            <div className="container-fluid">
                <div className="row">
                    <div className="col-sm-12 mt-2">
                    <h4 className='text-light text-center'>Disburse Salary</h4>

                        <button className="btn btn-primary" onClick={allDisburse}>Disburse</button>

                        <table className="table table-success table-hover table-bordered mt-2">
                            <thead>
                                <tr>
                                    <th scope="col">Check</th>
                                    <th scope="col">Employee ID.</th>
                                    <th scope="col">Name</th>
                                    <th scope="col">Email</th>
                                    <th scope="col">Salary</th>
                                </tr>
                            </thead>
                            <tbody>
                                {employees.map((userrecords, index) => (
                                    <tr key={index}>
                                        <td><input type='checkbox' value={userrecords.employee_id} checked={userrecords.isChecked} onChange={(e) => handlecheckbox(e)} /></td>
                                        <th scope="row">{userrecords.employee_id} </th>
                                        <td>{userrecords.fname} {userrecords.lname}</td>
                                        <td>{userrecords.email}</td>
                                        <td>{userrecords.salary}</td>
                                    </tr>
                                ))
                                }
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </React.Fragment>
    );

}

export default DisburseSalary