package pro.sky.employeespringhomework;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {

        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public Employee add(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName) {
        try {
            employeeService.add(firstName, lastName);
        } catch (EmployeeStorageIsFullException e) {
            System.out.println("Хранилище заполнено");
            ;
        } catch (EmployeeAlreadyAddedInListException e) {
            System.out.println("Сотрудник уже есть в хранилище");
        }
        Employee employee = new Employee(firstName, lastName);
        return employee;
    }


    @GetMapping(path = "/remove")
    public Employee remove(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName) {
        try {
            employeeService.remove(firstName, lastName);
        } catch (EmployeeNotFoundException e) {
            throw new RuntimeException(e);
        }
        Employee employee = new Employee(firstName, lastName);
        return employee;
    }

    @GetMapping(path = "/find")
    public Employee find(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName) {
        try {
            employeeService.find(firstName, lastName);
        } catch (EmployeeNotFoundException e) {
            throw new RuntimeException(e);
        }

        Employee employee = new Employee(firstName, lastName);
        return employee;
    }

    @GetMapping(path = "/print")
    public List<Employee> getAll() {

        return employeeService.getAll();
    }
}

