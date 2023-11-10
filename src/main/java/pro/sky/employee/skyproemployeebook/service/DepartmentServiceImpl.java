package pro.sky.employee.skyproemployeebook.service;

import org.springframework.stereotype.Service;
import pro.sky.employee.skyproemployeebook.exceptions.EmployeeNotFoundException;
import pro.sky.employee.skyproemployeebook.model.Employee;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    private final EmployeeServiceImpl employeeServiceimpl;

    public DepartmentServiceImpl(EmployeeServiceImpl employeeServiceimpl) {
        this.employeeServiceimpl = employeeServiceimpl;
    }

    @Override
    public Employee findEmployeeWithMaxSalary(int departmentId) {
         Optional<Employee> maxSalary = employeeServiceimpl.returnAllEmployees().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .max(Comparator.comparingInt(e -> e.getSalary()));
        return maxSalary.orElseThrow(() -> new EmployeeNotFoundException("Сотрудник не найден"));
    }

    @Override
    public Employee findEmployeeWithMinSalary(int departmentId) {
        Optional<Employee> minSalary = employeeServiceimpl.returnAllEmployees().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .min(Comparator.comparingInt(e -> e.getSalary()));
        return minSalary.orElseThrow(() -> new EmployeeNotFoundException("Сотрудник не найден"));
    }

    @Override
    public List<Employee> returnEmployeesByDepartmentId(int departmentId) {
        final List<Employee> employeesByDepartmentId = employeeServiceimpl.returnAllEmployees().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .collect(Collectors.toList());
        return employeesByDepartmentId;
    }

    @Override
    public Map<Integer, List<Employee>> returnAllEmployeesByDepartmentId() {
        return employeeServiceimpl.returnAllEmployees().stream()
                .collect(Collectors.groupingBy(e -> e.getDepartmentId()));
    }


}
