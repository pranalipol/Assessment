import axios from "axios";

const EMPLOYEE_REST_API_URL = "http://localhost:8080/employees";

const DEPARTMENTS_REST_API_URL = "http://localhost:8080/departments";

class EmployeeService {
  getAllEmployees() {
    return axios.get(EMPLOYEE_REST_API_URL);
  }

  getAllDepartments() {
    return axios.get(DEPARTMENTS_REST_API_URL);
  }

  addEmployee(employee) {
    return axios.post(EMPLOYEE_REST_API_URL, employee);
  }
}

export default new EmployeeService();
