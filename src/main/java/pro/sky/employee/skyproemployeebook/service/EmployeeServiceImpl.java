package pro.sky.employee.skyproemployeebook.service;

import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.employee.skyproemployeebook.exceptions.EmployeeInvalidInputException;
import pro.sky.employee.skyproemployeebook.model.Employee;
import pro.sky.employee.skyproemployeebook.exceptions.EmployeeAlreadyAddedException;
import pro.sky.employee.skyproemployeebook.exceptions.EmployeeNotFoundException;
import pro.sky.employee.skyproemployeebook.exceptions.EmployeeStorageIsFullException;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static final int MAX_NUMBER_EMPLOYEES = 30;
    private final Map<String, Employee> employees = Maps.newHashMap(Map.of(
            "ЕкатеринаСарафанова",
            new Employee("Екатерина", "Сарафанова", 1, 68550),
            "НикитаБратченко",
            new Employee("Никита", "Братченко", 5, 25327),
            "ДарьяВасильева",
            new Employee("Дарья", "Васильева", 3, 33088),
            "ДарьяЮдина",
            new Employee("Дарья", "Юдина", 2, 55457),
            "МарияСинявская",
            new Employee("Мария", "Синявская", 4, 40789),
            "ВикторияОрлова",
            new Employee("Виктория", "Орлова", 1, 37440),
            "МарияЛарионова",
            new Employee("Мария", "Ларионова", 3, 27890),
            "СофьяСиротина",
            new Employee("Софья", "Сиротина", 2, 42220),
            "НикитаТихонов",
            new Employee("Никита", "Тихонов", 5, 38990),
            "АлександрСергеев",
            new Employee("Александр", "Сергеев", 4, 70888)
    ));

    public void checkIsAlpha(String firstName, String lastName) {
        if (!(StringUtils.isAlpha(firstName) || StringUtils.isAlpha(lastName))) {
            throw new EmployeeInvalidInputException();
        }
    }

    @Override
    public Employee addEmployee(String firstName, String lastName, int departmentId, int salary)
            throws EmployeeStorageIsFullException, EmployeeAlreadyAddedException {
        checkIsAlpha(firstName, lastName);
        Employee employee = new Employee(firstName, lastName, departmentId, salary);
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException("Сотрудник уже добавлен");
        } else if (employees.size() > MAX_NUMBER_EMPLOYEES) {
            throw new EmployeeStorageIsFullException("Нельзя добавить сотрудника, потому что коллекция переполнена");
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName, int departmentId, int salary)
            throws EmployeeNotFoundException {
        checkIsAlpha(firstName, lastName);
        Employee employee = new Employee(firstName, lastName, departmentId, salary);
        if (employees.containsKey(employee.getFullName())) {
            employees.remove(employee.getFullName(), employee);
            return employee;
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }

    @Override
    public Employee findEmployee(String firstName, String lastName, int departmentId, int salary)
            throws EmployeeNotFoundException {
        checkIsAlpha(firstName,lastName);
        Employee employee = new Employee(firstName, lastName, departmentId, salary);
        if (employees.containsKey(employee.getFullName())) {
            return employee;
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");

    }

    @Override
    public Collection<Employee> returnAllEmployees() {
        return Collections.unmodifiableCollection(employees.values());
    }
}
