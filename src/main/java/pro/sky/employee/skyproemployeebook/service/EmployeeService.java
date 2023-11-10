package pro.sky.employee.skyproemployeebook.service;


import pro.sky.employee.skyproemployeebook.model.Employee;
import pro.sky.employee.skyproemployeebook.exceptions.EmployeeAlreadyAddedException;
import pro.sky.employee.skyproemployeebook.exceptions.EmployeeNotFoundException;
import pro.sky.employee.skyproemployeebook.exceptions.EmployeeStorageIsFullException;

import java.util.Collection;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName, int departmentId, int salary) throws EmployeeStorageIsFullException, EmployeeAlreadyAddedException;
    Employee removeEmployee(String firstName, String lastName, int departmentId, int salary) throws EmployeeNotFoundException;
    Employee findEmployee(String firstName, String lastName, int departmentId, int salary) throws EmployeeNotFoundException;
    Collection<Employee> returnAllEmployees();
}
