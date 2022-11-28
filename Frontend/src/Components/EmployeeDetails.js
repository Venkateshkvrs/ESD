import React, { useState } from 'react'
import axios from 'axios'

const EmployeeDetails = ({ employee_id, fname, lname, email, title, salary, status }) => {

    const [modifiedsalary, setSalary] = useState('')
    const modifySalaryURL = `http://localhost:8080/api/employee/Modify_salary_details`
    const modify = (event) => {
        event.preventDefault();
        if(modifiedsalary<0){
            alert("Enter Valid Amount");
            window.location.reload(true);
        }
        else
        modifySalary();
        
    }
    const parameters = {
        employee_id, salary: parseFloat(modifiedsalary)
    }

    const modifySalary = async () => {
        await axios.post(modifySalaryURL, parameters)
            .then(function (response) {
                console.log(response.data);
                window.localStorage.setItem('usersalary', JSON.stringify(response.data))
                window.location.reload(true)
            })
            .catch(function (error) {
                console.log(error);
                // alert("Enter Valid Amount or Operation Not Possible at this Moment...");
                // window.location.reload(true)
            });
    }
    
    
    return (
        <tr>
            <td>{employee_id}</td>
            <td>{fname} {lname}</td>
            <td>{email}</td>
            <td>{title}</td>
            <td>{salary}</td>
            <td>
                <div>
                    <input className="form-control" id="ex1" placeholder="Salary" type="number" style={{ width: "150px" }} onChange={event => setSalary(event.target.value)} />
                </div>
            </td>
            <td>
                <button type="button" className="btn btn-secondary" onClick={modify}>modify</button>
            </td>
            
        </tr>

    )
}
export default EmployeeDetails