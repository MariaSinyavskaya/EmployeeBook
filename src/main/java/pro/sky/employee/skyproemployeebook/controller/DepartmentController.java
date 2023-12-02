package pro.sky.employee.skyproemployeebook.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.employee.skyproemployeebook.model.Employee;
import pro.sky.employee.skyproemployeebook.service.DepartmentServiceImpl;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/department")
public class DepartmentController {
    private final DepartmentServiceImpl departmentServiceImpl;

    public DepartmentController(DepartmentServiceImpl departmentServiceImpl) {
        this.departmentServiceImpl = departmentServiceImpl;
    }

    @GetMapping(path = "/{id}/salary/max")
    public Integer employeeWithMaxSalary(@PathVariable("id") int departmentId) {
        return departmentServiceImpl.findMaxSalaryByDepartment(departmentId);
    }

    @GetMapping(path = "/{id}/salary/min")
    public Integer employeeWithMinSalary(@PathVariable("id") int departmentId) {
        return departmentServiceImpl.findMinSalaryByDepartment(departmentId);
    }

    @GetMapping(path = "/{id}/salary/sum")
    public Integer sumOfSalaryByDepartment(@PathVariable("id") int departmentId) {
        return departmentServiceImpl.findSumOfSalaryByDepartment(departmentId);
    }

    @GetMapping(path = "/{id}/employees")
    public List<Employee> returnEmployeesByDepartmentId(@PathVariable("id") int departmentId) {
        return departmentServiceImpl.returnEmployeesByDepartmentId(departmentId);
    }

    @GetMapping(path = "/employees")
    public Map<Integer, List<Employee>> returnAllEmployeesByDepartmentId() {
        return departmentServiceImpl.returnAllEmployeesByDepartmentId();
    }
}
