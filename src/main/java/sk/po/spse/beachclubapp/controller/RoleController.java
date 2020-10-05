package sk.po.spse.beachclubapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sk.po.spse.beachclubapp.entity.Role;
import sk.po.spse.beachclubapp.repository.RoleRepository;
import sk.po.spse.beachclubapp.service.RoleService;
@RestController
public class RoleController 
{
	
	@Autowired
	private RoleService roleService;
	
	@PostMapping("/roles")
	public Role addRole(@RequestParam("name") String name)
	{
		return roleService.createRole(name);
	}
	
	
	 @GetMapping("/roles")
	 public List<Role> getRoles()
	 {
		return roleService.findAll();
	 }
	 
	
	 @GetMapping(path="/roles/{id}")
	 public Role getRole(@PathVariable("id") Long id)
	 {
		return roleService.findRole(id);
	 }
	 
	 @DeleteMapping("/roles/{id}")
	 public String deleteRole(@PathVariable Long id)
	 {
		 if (roleService.deleteRole(id)) 
		 {
			 return "Done !";
		 } 
		 else
		 {
			 return "Wrong id !";
		 }
	 }
	 
	 @PutMapping("/roles/{id}")
	 public Role updateRole(@PathVariable Long id, @RequestParam("name") String name)
	 {
		return roleService.updateRole(id, name);			
	 }
	
}
