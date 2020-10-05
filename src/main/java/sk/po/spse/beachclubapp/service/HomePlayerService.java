package sk.po.spse.beachclubapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sk.po.spse.beachclubapp.entity.HomePlayer;
import sk.po.spse.beachclubapp.entity.Player;
import sk.po.spse.beachclubapp.entity.Role;
import sk.po.spse.beachclubapp.repository.HomePlayerRepository;
import sk.po.spse.beachclubapp.repository.RoleRepository;
@Service
public class HomePlayerService 
{
	@Autowired
	private HomePlayerRepository homePlayerRepository;


	public HomePlayer createHomePlayer(String name, int points, String sex, String phone, 
			String email, String address, String registrationNumber, boolean isRightHanded, String clothesSize)
	{
		HomePlayer homePlayer = new HomePlayer();
		homePlayer.setName(name);
		homePlayer.setPoints(points);
		homePlayer.setPhone(phone);
		homePlayer.setSex(sex);
		homePlayer.setEmail(email);
		homePlayer.setAddress(address);
		homePlayer.setRegistrationNumber(registrationNumber);
		homePlayer.setRightHanded(isRightHanded);
		homePlayer.setClothesSize(clothesSize);
		return homePlayerRepository.save(homePlayer);
	}
	
	
	public List<HomePlayer> findAll()
	{
		 return homePlayerRepository.findAll();
	}
	
	public HomePlayer findHomePlayer(Long id)
	{
		 return homePlayerRepository.findById(id).orElseThrow(IllegalArgumentException::new);	
	}
	
	
	public boolean deleteHomePlayer(Long id)
	{
		try 
		{
			homePlayerRepository.deleteById(id);
			return true;
		} catch(IllegalArgumentException e)
		{
			return false;
		}			
	}
	
	public HomePlayer updateHomePlayer(Long id, String name, int points, String sex, String phone, 
			String email, String address, String registrationNumber, boolean isRightHanded, String clothesSize)
	{
		HomePlayer homePlayer = homePlayerRepository.findById(id).orElseThrow(IllegalArgumentException::new);
		homePlayer.setName(name);
		homePlayer.setPoints(points);
		homePlayer.setPhone(phone);
		homePlayer.setSex(sex);
		homePlayer.setEmail(email);
		homePlayer.setAddress(address);
		homePlayer.setRegistrationNumber(registrationNumber);
		homePlayer.setRightHanded(isRightHanded);
		homePlayer.setClothesSize(clothesSize);
		return homePlayerRepository.save(homePlayer);
	}
	
	
}
