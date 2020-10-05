package sk.po.spse.beachclubapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sk.po.spse.beachclubapp.entity.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long>
{
	List<Role> findAll();
	
}
