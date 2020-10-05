package sk.po.spse.beachclubapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sk.po.spse.beachclubapp.entity.Player;
import sk.po.spse.beachclubapp.repository.PlayerRepository;

@Service
public class PlayerService 
{

	@Autowired
	private PlayerRepository playerRepository;
	
	
	public Player createPlayer(String name, int points, String sex)
	{
		Player player = new Player();
		player.setName(name);
		player.setPoints(points);
		player.setSex(sex);
		return playerRepository.save(player);
	}
	

	public List<Player> findAll()
	{
		 return playerRepository.findAll();
	}
	
	public Player findPlayer(Long id)
	{
		 return playerRepository.findById(id).orElseThrow(IllegalArgumentException::new);	
	}
	
	public boolean deletePlayer(Long id)
	{
		try 
		{
			playerRepository.deleteById(id);
			return true;
		} catch(IllegalArgumentException e)
		{
			return false;
		}			
	}
	
	public Player updatePlayer(Long id, String name, int points, String sex)
	{
		 Player player = playerRepository.findById(id).orElseThrow(IllegalArgumentException::new);
		 player.setName(name);
		 player.setPoints(points);
		 player.setSex(sex);
		 return playerRepository.save(player);
	}
	
	
	
	
}
