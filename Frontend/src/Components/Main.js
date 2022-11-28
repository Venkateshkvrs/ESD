import React, { useEffect, useState } from 'react'
import axios from 'axios'
import EmployeeDetails from './EmployeeDetails'
import ReactDOM from 'react-dom'
import DisburseSalary from './DisburseSalary'

const Main = () => {
  var operation= JSON.parse(window.localStorage.getItem('opnDef'))

  
  const [employees, setEmployee] = useState([])
  const [page, setPage] = useState(1)
  // -------------------------employee fetch
  const empDetailsURL = `http://localhost:8080/api/employee/employee_details`
  const employeeFetch = async () => {
    await axios.get(empDetailsURL)
      .then(function (response) {
        //console.log("employee details", response.data);
        setEmployee(response.data)
      })
      .catch(function (error) {
        console.log(error);
      });
  }

  // ----------------------------------------------------------------

  useEffect(() => {
    employeeFetch();
  }, [])
  const disburseHandler = (event) => {
    event.preventDefault();
    setPage(2);
    employeeFetch();
    // window.localStorage.setItem('opnDef',"OPERATION2");
  }
  
  
  return (
  
    <div className='bg-dark'>
      {
        (page===1) && (
                <div>
                  <h4 className='text-light text-center'>Employee Salary Details</h4>
                  {<div className='container-sm bg-dark text-light'>
              <form class="form-inline" onSubmit={disburseHandler}>
                <div className='form-group form-inline py-4 float-right'>
                  {/* <input type='text' placeholder="Description" className='form-control' required></input> */}
                  <button type='submit' className='btn btn-link text-white mt-3 float-right' > <p>Go to Disbursement Section</p></button>
                </div>

              </form>
            </div>}
            {<table className="table table-hover table-bordered " style={{
              textAlign: "center", alignContent: "center"
            }}>
              <thead className='table-primary'>
                <tr>
                  <th scope='row'>Employee_Id</th>
                  <th>Name</th>
                  <th>Email</th>
                  <th>Title</th>
                  <th>Salary</th>
                  <th>Modify Salary</th>
                  <th>Update</th>
                </tr>
              </thead>
              <tbody className='table-success'>
                {
                  employees.map(e =>
                    <EmployeeDetails
                      {...e}
                      key={e.employee_id}

                    />
                  )

                }

              </tbody>
              

            </table>
            }
            {/*
              Salary Disbursement
              */}
            
          </div>
        )
      }
      {
        (page===2) && (
        <div className='container-fluid'>
          <DisburseSalary employees={employees}/>
          <button className='btn btn-link text-white'
          onClick={()=>{
            setPage(1);
          }}
          >Back</button>
        </div>
      
      )
      
      }
    </div>
  )
}
export default Main
