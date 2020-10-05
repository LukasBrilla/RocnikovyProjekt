package sk.po.spse.beachclubapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import sk.po.spse.beachclubapp.entity.Employee;
import sk.po.spse.beachclubapp.entity.Role;
import sk.po.spse.beachclubapp.service.EmployeeService;
import sk.po.spse.beachclubapp.service.RoleService;

@RestController
public class EmployeeController 
{
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private RoleService roleService;
	
	
	@PostMapping("/employees")
	public ModelAndView addEmployee(@RequestParam("name") String name, @RequestParam("role") String role)
	{
		employeeService.createEmployee(name, roleService.createRole(role));
		return new ModelAndView("/employeesBrowse").addObject("employees", employeeService.findAll());

	}
	
	 @GetMapping("/employees")
	 public List<Employee> getEmployees()
	 {
		return employeeService.findAll();
	 }
	 
	
	 @GetMapping(path="/employees/{id}")
	 public Employee getEmployee(@PathVariable("id") Long id)
	 {
		return employeeService.findEmployee(id);
	 }
	 
	 @PostMapping("/employees/{id}")
	 public ModelAndView deleteEmployee(@PathVariable Long id)
	 {
		 employeeService.deleteEmployee(id);
		 return new ModelAndView("/employeesBrowse").addObject("employees", employeeService.findAll());
	 }
	 
	 @PostMapping("/employees/update/{id}")
	 public ModelAndView updateEmployee(@PathVariable Long id, @RequestParam("name") String name, @RequestParam("role") String role)
	 {
		 employeeService.updateEmployee(id, name, roleService.createRole(role));	
		 return new ModelAndView("/employeesBrowse").addObject("employees", employeeService.findAll());
	 }
	 
	 
	 
	 
}
