package sk.po.spse.beachclubapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sk.po.spse.beachclubapp.entity.Employee;
import sk.po.spse.beachclubapp.entity.HomePlayer;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>
{

	List<Employee> findAll();
}