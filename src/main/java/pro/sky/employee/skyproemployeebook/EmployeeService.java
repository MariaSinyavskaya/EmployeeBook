package pro.sky.employee.skyproemployeebook;

import java.util.Collection;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName) throws EmployeeStorageIsFullException, EmployeeAlreadyAddedException;
    Employee removeEmployee(String firstName, String lastName) throws EmployeeNotFoundException;
    Employee findEmployee(String firstName, String lastName) throws EmployeeNotFoundException;
    Collection<Employee> printAllEmployees();
}
