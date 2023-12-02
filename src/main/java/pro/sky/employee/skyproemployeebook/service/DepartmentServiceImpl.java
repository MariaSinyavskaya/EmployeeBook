package pro.sky.employee.skyproemployeebook.service;

import org.springframework.stereotype.Service;
import pro.sky.employee.skyproemployeebook.exceptions.EmployeeNotFoundException;
import pro.sky.employee.skyproemployeebook.model.Employee;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Integer findMaxSalaryByDepartment(int departmentId) {
        return employeeService.returnAllEmployees().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .mapToInt(e -> e.getSalary())
                .max()
                .orElseThrow(() -> new EmployeeNotFoundException("Сотрудник не найден"));
    }

    @Override
    public Integer findMinSalaryByDepartment(int departmentId) {
        return employeeService.returnAllEmployees().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .mapToInt(e -> e.getSalary())
                .min()
                .orElseThrow(() -> new EmployeeNotFoundException("Сотрудник не найден"));
    }

    @Override
    public List<Employee> returnEmployeesByDepartmentId(int departmentId) {
        final List<Employee> employeesByDepartmentId = employeeService.returnAllEmployees().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .collect(Collectors.toList());
        return employeesByDepartmentId;
    }

    @Override
    public Integer findSumOfSalaryByDepartment(int departmentId) {
        return employeeService.returnAllEmployees().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .mapToInt(e -> e.getSalary())
                .sum();
    }

    @Override
    public Map<Integer, List<Employee>> returnAllEmployeesByDepartmentId() {
        return employeeService.returnAllEmployees().stream()
                .collect(Collectors.groupingBy(e -> e.getDepartmentId()));
    }
}
