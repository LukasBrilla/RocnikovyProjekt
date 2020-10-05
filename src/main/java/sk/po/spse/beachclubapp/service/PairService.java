package sk.po.spse.beachclubapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sk.po.spse.beachclubapp.entity.Pair;
import sk.po.spse.beachclubapp.entity.Player;
import sk.po.spse.beachclubapp.repository.PairRepository;
@Service
public class PairService 
{
	@Autowired
	private PairRepository pairRepository;
	
	public Pair createPair (Player firstPlayer, Player secondPlayer) 
	{
		Pair pair = new Pair();
		pair.setFirstPlayer(firstPlayer);
		pair.setSecondPlayer(secondPlayer);
		return pairRepository.save(pair);
	}
	
	public List<Pair> findAll()
	{
		 return pairRepository.findAll();
	}
	
	public Pair findRole(Long id)
	{
		 return pairRepository.findById(id).orElseThrow(IllegalArgumentException::new);	
	}

	public boolean deletePair(Long id)
	{
		try 
		{
			pairRepository.deleteById(id);
			return true;
		} catch(IllegalArgumentException e)
		{
			return false;
		}			
	}
	public Pair updatePair(Long id, Player firstPlayer, Player secondPlayer)
	{
		 Pair pair = pairRepository.findById(id).orElseThrow(IllegalArgumentException::new);
		 pair.setFirstPlayer(firstPlayer);
		 pair.setSecondPlayer(secondPlayer);
		 return pairRepository.save(pair);
	}
}
