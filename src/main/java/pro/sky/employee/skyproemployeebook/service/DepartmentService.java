package pro.sky.employee.skyproemployeebook.service;

import pro.sky.employee.skyproemployeebook.model.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee findEmployeeWithMaxSalary(int departmentId);

    Employee findEmployeeWithMinSalary(int departmentId);

    List<Employee> returnEmployeesByDepartmentId(int departmentId);

    Map<Integer, List<Employee>> returnAllEmployeesByDepartmentId();
}
