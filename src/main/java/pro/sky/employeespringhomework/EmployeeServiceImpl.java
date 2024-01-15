package pro.sky.employeespringhomework;

import pro.sky.employeespringhomework.Employee;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final List<Employee> employees = List.of(
            new Employee("Ivan", "Ivanov"),
            new Employee("Ivan", "Petrov"),
            new Employee("Peter", "Ivanov"),
            new Employee("Peter", "Petrov"),
            new Employee("Andrey", "Petrov"),
            new Employee("Peter", "Andreev"),
            new Employee("Sidor", "Sidorov"));

    private final int STORAGE_SIZE = 7;


    @Override


    public Employee add(String firstName, String lastName) throws EmployeeStorageIsFullException,
            EmployeeAlreadyAddedInListException {
        Employee employee = new Employee(firstName, lastName);

        int STORAGE_SIZE = 7;

        if (employees.size() >= STORAGE_SIZE) {


            throw new EmployeeStorageIsFullException("Хранилище заполнено");

        }


        if (employees.contains(employee)) {

            throw new EmployeeAlreadyAddedInListException("Сотрудник уже есть в хранилище");

        } else {
            employees.add(employee);

            return employee;

        }
    }

    @Override


    public Employee remove(String firstName, String lastName) throws EmployeeNotFoundException {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            employees.remove(employee);
            return employee;
        }
        throw new EmployeeNotFoundException("Такого  сотрудника нет в хранилище");
    }


    @Override


    public Employee find(String firstName, String lastName) throws EmployeeNotFoundException {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException("Такого  сотрудника нет в хранилище");
    }


    @Override

    public List<Employee> getAll() {

        return employees;


    }

}





