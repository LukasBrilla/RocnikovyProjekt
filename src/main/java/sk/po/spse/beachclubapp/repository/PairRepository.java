package sk.po.spse.beachclubapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sk.po.spse.beachclubapp.entity.Pair;
import sk.po.spse.beachclubapp.entity.Player;

@Repository
public interface PairRepository extends CrudRepository<Pair, Long>
{

	List<Pair> findAll();
}