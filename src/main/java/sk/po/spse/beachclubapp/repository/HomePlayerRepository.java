package sk.po.spse.beachclubapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sk.po.spse.beachclubapp.entity.HomePlayer;
import sk.po.spse.beachclubapp.entity.Role;

@Repository
public interface HomePlayerRepository extends CrudRepository<HomePlayer, Long>
{
	List<HomePlayer> findAll();
	
}
