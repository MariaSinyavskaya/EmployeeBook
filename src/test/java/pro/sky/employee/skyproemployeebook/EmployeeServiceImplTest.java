package pro.sky.employee.skyproemployeebook;

import org.junit.jupiter.api.Test;
import pro.sky.employee.skyproemployeebook.exceptions.EmployeeAlreadyAddedException;
import pro.sky.employee.skyproemployeebook.exceptions.EmployeeInvalidInputException;
import pro.sky.employee.skyproemployeebook.exceptions.EmployeeNotFoundException;
import pro.sky.employee.skyproemployeebook.exceptions.EmployeeStorageIsFullException;
import pro.sky.employee.skyproemployeebook.model.Employee;
import pro.sky.employee.skyproemployeebook.service.EmployeeServiceImpl;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.employee.skyproemployeebook.constants.TestConstant.*;

public class EmployeeServiceImplTest {
    private final EmployeeServiceImpl out = new EmployeeServiceImpl();
    @Test
    public void shouldThrowEmployeeInvalidInputExceptionWhenEmployeeNameNotIsAlpha() {
        assertThrows(EmployeeInvalidInputException.class,
                () -> out.checkIsAlpha("Мар1я", "Синявская"));
    }

    @Test
    public void shouldReturnEmployeeForAddEmployeeMethod() {
        Employee result = out.addEmployee(
                EMPLOYEE_IVAN.getFirstName(),
                EMPLOYEE_IVAN.getLastName(),
                EMPLOYEE_IVAN.getDepartmentId(),
                EMPLOYEE_IVAN.getSalary()
        );
        assertEquals(EMPLOYEE_IVAN,result);
    }

    @Test
    public void shouldTrowsEmployeeAlreadyAddedExceptionForAddEmployeeMethod() {
        assertThrows(EmployeeAlreadyAddedException.class,
                () -> out.addEmployee(
                        EMPLOYEE_MARIA.getFirstName(),
                        EMPLOYEE_MARIA.getLastName(),
                        EMPLOYEE_MARIA.getDepartmentId(),
                        EMPLOYEE_MARIA.getSalary()
                ));
    }

    @Test
    public void shouldEmployeeStorageIsFullExceptionForAddEmployeeMethod() {
        out.addEmployee("Дмитрий", "Иванов",DEPARTMENT , SALARY);
        out.addEmployee("Петр", "Петров", DEPARTMENT, SALARY);
        out.addEmployee("Александр", "Александров", DEPARTMENT, SALARY);
        out.addEmployee("Вася", "Васечкин", DEPARTMENT, SALARY);
        out.addEmployee("Андрей", "Андреев", DEPARTMENT, SALARY);
        out.addEmployee("Артем", "Борисов", DEPARTMENT, SALARY);
        assertThrows(EmployeeStorageIsFullException.class,
                () -> out.addEmployee(
                        EMPLOYEE_IVAN.getFirstName(),
                        EMPLOYEE_IVAN.getLastName(),
                        EMPLOYEE_IVAN.getDepartmentId(),
                        EMPLOYEE_IVAN.getSalary()
                ));
    }

    @Test
    public void shouldReturnEmployeeForRemoveEmployeeMethod() {
        out.addEmployee(
                EMPLOYEE_IVAN.getFirstName(),
                EMPLOYEE_IVAN.getLastName(),
                EMPLOYEE_IVAN.getDepartmentId(),
                EMPLOYEE_IVAN.getSalary()
        );
        assertEquals(11, out.returnAllEmployees().size());
        out.removeEmployee(EMPLOYEE_IVAN.getFirstName(),
                EMPLOYEE_IVAN.getLastName(),
                EMPLOYEE_IVAN.getDepartmentId(),
                EMPLOYEE_IVAN.getSalary()
        );
        assertEquals(10, out.returnAllEmployees().size());
    }

    @Test
    public void shouldTrowsEmployeeNotFoundExceptionForRemoveEmployeeMethod() {
        assertThrows(EmployeeNotFoundException.class,
                () -> out.removeEmployee(
                        EMPLOYEE_PETER.getFirstName(),
                        EMPLOYEE_PETER.getLastName(),
                        EMPLOYEE_PETER.getDepartmentId(),
                        EMPLOYEE_PETER.getSalary()
                ));
    }

    @Test
    public void shouldReturnEmployeeForFindEmployeeMethod() {
        Employee result = out.findEmployee(
                EMPLOYEE_MARIA.getFirstName(),
                EMPLOYEE_MARIA.getLastName(),
                EMPLOYEE_MARIA.getDepartmentId(),
                EMPLOYEE_MARIA.getSalary()
        );
        assertEquals(EMPLOYEE_MARIA,result);
    }

    @Test
    public void shouldTrowsEmployeeNotFoundExceptionForFindEmployeeMethod() {
        assertThrows(EmployeeNotFoundException.class,
                () -> out.findEmployee(
                        EMPLOYEE_PETER.getFirstName(),
                        EMPLOYEE_PETER.getLastName(),
                        EMPLOYEE_PETER.getDepartmentId(),
                        EMPLOYEE_PETER.getSalary()
                ));
    }

    @Test
    public void shouldReturnAllEmployees() {
        assertEquals(EMPLOYEES.values().size(), out.returnAllEmployees().size());
        assertIterableEquals(EMPLOYEES.values(), out.returnAllEmployees());
    }
}
