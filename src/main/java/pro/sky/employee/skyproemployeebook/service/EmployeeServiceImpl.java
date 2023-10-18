package pro.sky.employee.skyproemployeebook.service;

import org.springframework.stereotype.Service;
import pro.sky.employee.skyproemployeebook.model.Employee;
import pro.sky.employee.skyproemployeebook.exceptions.EmployeeAlreadyAddedException;
import pro.sky.employee.skyproemployeebook.exceptions.EmployeeNotFoundException;
import pro.sky.employee.skyproemployeebook.exceptions.EmployeeStorageIsFullException;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static final int MAX_NUMBER_EMPLOYEES = 15;
    private final Map<String, Employee> employees;

    public EmployeeServiceImpl(Map<String, Employee> employees) {
        this.employees = employees;
    }

    @Override
    public Employee addEmployee(String firstName, String lastName)
            throws EmployeeStorageIsFullException, EmployeeAlreadyAddedException {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException("Сотрудник уже добавлен");
        } else if (employees.size() > MAX_NUMBER_EMPLOYEES) {
            throw new EmployeeStorageIsFullException("Нельзя добавить сотрудника, потому что коллекция переполнена");
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName)
            throws EmployeeNotFoundException {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())) {
            employees.remove(employee.getFullName(), employee);
            return employee;
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }

    @Override
    public Employee findEmployee(String firstName, String lastName)
            throws EmployeeNotFoundException {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())) {
            return employee;
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");

    }

    @Override
    public Collection<Employee> printAllEmployees() {
        return Collections.unmodifiableCollection(employees.values());
    }
}
