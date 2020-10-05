package sk.po.spse.beachclubapp.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import sk.po.spse.beachclubapp.entity.Employee;
import sk.po.spse.beachclubapp.service.EmployeeService;

@RestController
public class EmployeeWebController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping(value = "/")
	public ModelAndView getIndex() {
		return new ModelAndView("/welcome");
	}
	
	@GetMapping(value = "/employees/add")
	public ModelAndView getAddEmployees() {
		return new ModelAndView("/employeesAdd");
	}
	
	@GetMapping(value = "/employees/browse")
	public ModelAndView getAllEmployees() {
		return new ModelAndView("/employeesBrowse").addObject("employees", employeeService.findAll());
	}
	
	@GetMapping(value = "/employees/delete")
	public ModelAndView deleteEmployees() {
		return new ModelAndView("/employeesDelete").addObject("employees", employeeService.findAll());
	}
	
	@GetMapping(value = "/employees/update/{id}")
	public ModelAndView updateEmployee(@PathVariable Long id)
	{	
		 return new ModelAndView("/employeesUpdate").addObject("employee", employeeService.findEmployee(id));
	 }
}
