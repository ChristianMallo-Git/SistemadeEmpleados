package cm.Employees.service;

import cm.Employees.model.Employee;

import java.util.List;

public interface IEmployeeService {

    public List<Employee> listEmployees();

    public Employee searchEmployeeById(Integer idEmployee);

    public void saveEmployee (Employee employee);

    public void deleteEmployee(Employee employee);
}
