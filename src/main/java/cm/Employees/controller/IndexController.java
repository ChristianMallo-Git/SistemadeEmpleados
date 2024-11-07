package cm.Employees.controller;

import cm.Employees.model.Employee;
import cm.Employees.service.EmployeeService;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class IndexController {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String init(ModelMap model){
        List<Employee> employees = employeeService.listEmployees();
        employees.forEach((employee) -> LOGGER.info(employee.toString()));
        model.put("employees" , employees);
        return "index";

    }

    @RequestMapping(value="/add", method = RequestMethod.GET)
    public String showAdd(){
        return "add";
    }

    @RequestMapping(value="/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("employeeForm") Employee employee){
        LOGGER.info("Employee to add: " + employee);
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }

    @RequestMapping(value="/edit", method = RequestMethod.GET)
    public String showModify(@RequestParam int idEmployee, ModelMap model){
        Employee employee = employeeService.searchEmployeeById(idEmployee);
        LOGGER.info("Employee to edit: " + employee);
        model.put("employee", employee);
        return "edit";
    }

    @RequestMapping (value="/edit", method = RequestMethod.POST)
    public String edit(@ModelAttribute("employeeForm") Employee employee){
        LOGGER.info("Employee to save: " + employee);
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }

    @RequestMapping (value="/delete", method = RequestMethod.GET)
    public String delete(@RequestParam int idEmployee){
        Employee employee = new Employee();
        employee.setIdEmployee(idEmployee);
        employeeService.deleteEmployee(employee);
        return "redirect:/";
    }

}
