package pro.sky.employee.skyproemployeebook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.employee.skyproemployeebook.exceptions.EmployeeNotFoundException;
import pro.sky.employee.skyproemployeebook.model.Employee;
import pro.sky.employee.skyproemployeebook.service.DepartmentServiceImpl;
import pro.sky.employee.skyproemployeebook.service.EmployeeService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static pro.sky.employee.skyproemployeebook.constants.TestConstant.*;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {
    @Mock
    private EmployeeService employeeService;

    private DepartmentServiceImpl out;

    @BeforeEach
    public void setUp() {
        out = new DepartmentServiceImpl(employeeService);
        when(employeeService.returnAllEmployees()).thenReturn(EMPLOYEES.values());
    }

    @Test
    public void shouldReturnMaxSalaryByDepartment() {
        int expected = 68550;
        int departmentId = 1;
        int result = out.findMaxSalaryByDepartment(departmentId);
        assertEquals(expected, result);
        verify(employeeService, only()).returnAllEmployees();
    }

    @Test
    public void shouldReturnMinSalaryByDepartment() {
        int expected = 25327;
        int departmentId = 5;
        int result = out.findMinSalaryByDepartment(departmentId);
        assertEquals(expected, result);
        verify(employeeService, only()).returnAllEmployees();
    }

    @Test
    public void shouldEmployeeNotFoundExceptionForMaxSalaryByDepartmentMethod() {
        assertThrows(EmployeeNotFoundException.class,
                () -> out.findMaxSalaryByDepartment(6));
    }
    @Test
    public void shouldEmployeeNotFoundExceptionForMinSalaryByDepartmentMethod() {
        assertThrows(EmployeeNotFoundException.class,
                () -> out.findMinSalaryByDepartment(8));
    }

    @Test
    public void shouldReturnSumOfSalaryByDepartment() {
        int expected = 111677;
        int departmentId = 4;
        int result = out.findSumOfSalaryByDepartment(departmentId);
        assertEquals(expected, result);
        verify(employeeService, only()).returnAllEmployees();
    }

    @Test
    public void shouldReturnEmployeesByDepartmentId() {
        List<Employee> expected = List.of(
                new Employee(
                        EMPLOYEE_MARIA.getFirstName(),
                        EMPLOYEE_MARIA.getLastName(),
                        EMPLOYEE_MARIA.getDepartmentId(),
                        EMPLOYEE_MARIA.getSalary()
                ),
                new Employee(
                        EMPLOYEE_ALEX.getFirstName(),
                        EMPLOYEE_ALEX.getLastName(),
                        EMPLOYEE_ALEX.getDepartmentId(),
                        EMPLOYEE_ALEX.getSalary()
                ));
        assertEquals(expected.size(), out.returnEmployeesByDepartmentId(4).size());
        assertIterableEquals(expected, out.returnEmployeesByDepartmentId(4));
    }

    @Test
    public void shouldreturnAllEmployeesByDepartmentId() {
        Map<Integer, List<Employee>> expected = new HashMap<>(Map.of(
                1, new ArrayList<>(out.returnEmployeesByDepartmentId(1)),
                2, new ArrayList<>(out.returnEmployeesByDepartmentId(2)),
                3, new ArrayList<>(out.returnEmployeesByDepartmentId(3)),
                4, new ArrayList<>(out.returnEmployeesByDepartmentId(4)),
                5, new ArrayList<>(out.returnEmployeesByDepartmentId(5))
        ));
        Map<Integer, List<Employee>> result = out.returnAllEmployeesByDepartmentId();
        assertEquals(expected.size(), result.size());
        assertEquals(expected, result);
    }
}
