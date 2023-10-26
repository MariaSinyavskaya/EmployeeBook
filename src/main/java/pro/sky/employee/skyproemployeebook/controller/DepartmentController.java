package pro.sky.employee.skyproemployeebook.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.employee.skyproemployeebook.model.Employee;
import pro.sky.employee.skyproemployeebook.service.DepartmentServiceImpl;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/departments")
public class DepartmentController {
    private final DepartmentServiceImpl departmentServiceImpl;

    public DepartmentController(DepartmentServiceImpl departmentServiceImpl) {
        this.departmentServiceImpl = departmentServiceImpl;
    }

    @GetMapping(path = "/max-salary")
    public Employee employeeWithMaxSalary(@RequestParam("departmentId") int departmentId) {
        return departmentServiceImpl.findEmployeeWithMaxSalary(departmentId);
    }

    @GetMapping(path = "min-salary")
    public Employee employeeWithMinSalary(@RequestParam("departmentId") int departmentId) {
        return departmentServiceImpl.findEmployeeWithMinSalary(departmentId);
    }

    @GetMapping(path = "all", params = "departmentId")
    public List<Employee> returnEmployeesByDepartmentId(int departmentId) {
        return departmentServiceImpl.returnEmployeesByDepartmentId(departmentId);
    }

    @GetMapping(path = "all")
    public Map<Integer, List<Employee>> returnAllEmployeesByDepartmentId() {
        return departmentServiceImpl.returnAllEmployeesByDepartmentId();
    }
}
