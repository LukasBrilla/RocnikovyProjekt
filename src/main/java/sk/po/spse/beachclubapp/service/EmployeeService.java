package sk.po.spse.beachclubapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sk.po.spse.beachclubapp.entity.Employee;
import sk.po.spse.beachclubapp.entity.Role;
import sk.po.spse.beachclubapp.repository.EmployeeRepository;
import sk.po.spse.beachclubapp.repository.RoleRepository;
@Service
public class EmployeeService 
{
	
	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee createEmployee (String name, Role role) 
	{
		Employee employee = new Employee();
		employee.setName(name);
		employee.setRole(role);
		return employeeRepository.save(employee);
	}
	
	public List<Employee> findAll()
	{
		 return employeeRepository.findAll();
	}
	
	public Employee findEmployee(Long id)
	{
		 return employeeRepository.findById(id).orElseThrow(IllegalArgumentException::new);	
	}

	public boolean deleteEmployee(Long id)
	{
		try 
		{
			employeeRepository.deleteById(id);
			return true;
		} catch(IllegalArgumentException e)
		{
			return false;
		}			
	}
	
	public Employee updateEmployee(Long id, String name, Role role)
	{
		 Employee employee = employeeRepository.findById(id).orElseThrow(IllegalArgumentException::new);
		 employee.setName(name);
		 employee.setRole(role);
		 return employeeRepository.save(employee);
	}
	
	
	
}
