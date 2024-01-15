package pro.sky.employeespringhomework;


import org.springframework.stereotype.Service;


import java.util.List;


@Service


public interface EmployeeService {

    Employee add(String firstName, String lastName) throws EmployeeStorageIsFullException,
            EmployeeAlreadyAddedInListException;


    Employee remove(String firstName, String lastName) throws EmployeeNotFoundException;


    Employee find(String firstName, String lastName) throws EmployeeNotFoundException;


    List<Employee> getAll();


}