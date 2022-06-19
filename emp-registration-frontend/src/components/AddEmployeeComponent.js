import React, { useState, useEffect } from "react";
import Select from "react-select";

import EmployeeService from "../services/EmployeeService";
import { validateEmployee } from "../utilities/EmployeeValidation";

const AddEmployeeComponent = () => {
  const [empname, setEmpName] = useState("");
  const [departments, setDepartments] = useState([]);
  const [department, setDepartment] = useState("");
  const [dateofjoining, setDateofjoining] = useState("");
  const [salary, setSalary] = useState(0);
  const [errors, setErrors] = useState([]);
  const [message, setMessage] = useState("");

  const saveEmployee = (e) => {
    e.preventDefault();

    const employee = {
      empname,
      department_code: department.value,
      dateofjoining,
      salary,
    };

    validateEmployee(employee)
      .then(() => {
        EmployeeService.addEmployee(employee)
          .then((response) => {
            console.log(response.data);

            clearForm();
            setMessage("Employee saved successfully");
            setTimeout(() => setMessage(""), 1500);
          })
          .catch((error) => {
            console.log(error);
            setMessage("Error occurred while saving the employee");
            setTimeout(() => setMessage(""), 1500);
          });
      })
      .catch((err) => {
        const errorsDetails = [];
        for (const error of err.inner) {
          errorsDetails.push({
            field: error.path,
            message: error.message,
          });
        }

        setErrors(errorsDetails);
      });
  };

  const clearForm = () => {
    setEmpName("");
    setDepartment("");
    setDateofjoining("");
    setSalary(0);
    setErrors([]);
  };

  useEffect(() => {
    EmployeeService.getAllDepartments()
      .then((response) => {
        const data = [];
        response.data.forEach((element) => {
          data.push({
            value: element.code,
            label: element.description,
          });
        });
        setDepartments(data);
      })
      .catch((error) => {
        console.log(error);
      });
  }, []);

  const title = () => {
    return <h2 className="text-center">Registration</h2>;
  };

  const getElementError = (fieldName) => {
    if (errors.length > 0) {
      const error = errors.find((e) => e.field === fieldName);
      if (error && error.message) {
        return (
          <label className="form-label" style={{ color: "red" }}>
            {" "}
            {error.message}{" "}
          </label>
        );
      }
    }
  };

  return (
    <div>
      <br />
      <br />
      <div className="container">
        <div className="row">
          <div className="card col-md-6 offset-md-3 offset-md-3">
            {title()}
            <div className="card-body">
              <form>
                {message && (
                  <div className="form-group mb-2">
                    <label className="form-label" style={{ color: "green" }}>
                      {message}
                    </label>
                  </div>
                )}

                <div className="form-group mb-2">
                  <label className="form-label"> Employee Name :</label>
                  <input
                    type="text"
                    placeholder="Enter Employee name"
                    name="empname"
                    className="form-control"
                    value={empname}
                    onChange={(e) => setEmpName(e.target.value)}
                  ></input>
                  {getElementError("empname")}
                </div>

                <div className="form-group mb-2">
                  <label className="form-label"> Department:</label>
                  <Select
                    options={departments}
                    value={department}
                    onChange={(value) => setDepartment(value)}
                  />
                  {getElementError("department_code")}
                </div>

                <div className="form-group mb-2">
                  <label className="form-label"> Date of Joining :</label>
                  <input
                    type="date"
                    placeholder="Enter dateofjoining"
                    name="dateofjoining"
                    className="form-control"
                    value={dateofjoining}
                    onChange={(e) => setDateofjoining(e.target.value)}
                  ></input>
                  {getElementError("dateofjoining")}
                </div>
                <div className="form-group mb-2">
                  <label className="form-label"> Salary :</label>
                  <input
                    type="text"
                    placeholder="Enter salary"
                    name="salary"
                    className="form-control"
                    value={salary}
                    onChange={(e) => setSalary(e.target.value)}
                  ></input>
                  {getElementError("salary")}
                </div>

                <button
                  className="btn btn-success"
                  onClick={(e) => saveEmployee(e)}
                >
                  Save{" "}
                </button>

                <button className="btn btn-info" onClick={() => clearForm()}>
                  Clear{" "}
                </button>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default AddEmployeeComponent;
