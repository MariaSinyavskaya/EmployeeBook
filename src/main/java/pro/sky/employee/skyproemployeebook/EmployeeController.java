package pro.sky.employee.skyproemployeebook;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
                                @RequestParam("lastName") String lastName) {
        return employeeServiceimpl.addEmployee(firstName, lastName) ;
    }

    @GetMapping(path = "/remove")
    public Employee removeEmployee(@RequestParam("firstName") String firstName,
                                   @RequestParam("lastName") String lastName) {
        return employeeServiceimpl.removeEmployee(firstName,lastName);
    }

    @GetMapping(path = "/find")
    public Employee findEmployee(@RequestParam("firstName") String firstName,
                                 @RequestParam("lastName") String lastName) {
        return employeeServiceimpl.findEmployee(firstName, lastName);
    }

    @GetMapping
    public Collection<Employee> printAllEmployees() {
         return employeeServiceimpl.printAllEmployees();
    }
}
