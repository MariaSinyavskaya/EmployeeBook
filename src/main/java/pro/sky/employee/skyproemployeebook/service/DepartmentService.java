package pro.sky.employee.skyproemployeebook.service;

import pro.sky.employee.skyproemployeebook.model.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Integer findMaxSalaryByDepartment(int departmentId);

    Integer findMinSalaryByDepartment(int departmentId);

    List<Employee> returnEmployeesByDepartmentId(int departmentId);

    Integer findSumOfSalaryByDepartment(int departmentId);

    Map<Integer, List<Employee>> returnAllEmployeesByDepartmentId();
}
