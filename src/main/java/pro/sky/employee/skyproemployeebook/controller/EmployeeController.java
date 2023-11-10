package pro.sky.employee.skyproemployeebook.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.employee.skyproemployeebook.model.Employee;
import pro.sky.employee.skyproemployeebook.service.EmployeeServiceImpl;

import java.util.Collection;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
    private final EmployeeServiceImpl employeeServiceimpl;

    public EmployeeController(EmployeeServiceImpl employeeServiceimpl) {
        this.employeeServiceimpl = employeeServiceimpl;
    }

    @GetMapping(path = "/add")
    public Employee addEmployee(@RequestParam("firstName")  String firstName,
                                @RequestParam("lastName") String lastName,
                                @RequestParam("departmentId") int departmentId,
                                @RequestParam("salary") int salary) {
        return employeeServiceimpl.addEmployee(firstName, lastName, departmentId, salary) ;
    }

    @GetMapping(path = "/remove")
    public Employee removeEmployee(@RequestParam("firstName") String firstName,
                                   @RequestParam("lastName") String lastName,
                                   @RequestParam("departmentId") int departmentId,
                                   @RequestParam("salary") int salary) {
        return employeeServiceimpl.removeEmployee(firstName,lastName, departmentId, salary);
    }

    @GetMapping(path = "/find")
    public Employee findEmployee(@RequestParam("firstName") String firstName,
                                 @RequestParam("lastName") String lastName,
                                 @RequestParam("departmentId") int departmentId,
                                 @RequestParam("salary") int salary) {
        return employeeServiceimpl.findEmployee(firstName, lastName, departmentId, salary);
    }

    @GetMapping
    public Collection<Employee> printAllEmployees() {
         return employeeServiceimpl.returnAllEmployees();
    }
}
