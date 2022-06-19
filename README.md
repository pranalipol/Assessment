# Project Flow:

## Steps to run the project

1. import the spring boot project 'employee'
2. Run Spring boot application (It will create employee table and department_master table)
3. open folder 'emp-registration-frontend'
4. install npm
5. start npm

-------Sample Request Response-----------------

### 1.GET API

Find Employee By Employee Name
url: http://localhost:8081/employees/empname/Pranali

---

### 2.GET API

Find Employee by Employee No
url: http://localhost:8081/employees/3
Response:
{
"empno": 3,
"empname": "Pranali",
"department_code": "HR",
"dateofjoining": "18-06-2022",
"salary": 2000000.0
}

---

### 3. POST API

Add Employee
url: http://localhost:8081/employees

Request:
{
{
"empname":"Aadhya",
"department_code":"OP",
"dateofjoining":"18-06-2022",
"salary":"4000000"

}

}
response:
{
"empno": 31,
"empname": "Aadhya1",
"department_code": "OP",
"dateofjoining": "18-06-2022",
"salary": 4000000.0
}
