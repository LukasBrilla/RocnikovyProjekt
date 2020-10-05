package sk.po.spse.beachclubapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sk.po.spse.beachclubapp.entity.Role;
import sk.po.spse.beachclubapp.repository.RoleRepository;

@Service
public class RoleService 
{
	@Autowired
	private RoleRepository roleRepository;
	
	public Role createRole(String name) 
	{
		for(Role role : roleRepository.findAll())
		if(role.getName().equals(name))
		{
			return role;
		}
		Role role = new Role();
		role.setName(name);
		return roleRepository.save(role);
	}
	
	public List<Role> findAll()
	{
		 return roleRepository.findAll();
	}
	
	public Role findRole(Long id)
	{
		 return roleRepository.findById(id).orElseThrow(IllegalArgumentException::new);	
	}

	public boolean deleteRole(Long id)
	{
		try 
		{
			roleRepository.deleteById(id);
			return true;
		} catch(IllegalArgumentException e)
		{
			return false;
		}			
	}
	
	public Role updateRole(Long id, String name)
	{
		 Role role = roleRepository.findById(id).orElseThrow(IllegalArgumentException::new);
		 role.setName(name);
		 return roleRepository.save(role);
	}
}
