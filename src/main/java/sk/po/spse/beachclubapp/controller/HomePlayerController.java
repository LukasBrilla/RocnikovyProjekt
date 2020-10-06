package sk.po.spse.beachclubapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import sk.po.spse.beachclubapp.entity.HomePlayer;
import sk.po.spse.beachclubapp.entity.Player;
import sk.po.spse.beachclubapp.entity.Role;
import sk.po.spse.beachclubapp.service.HomePlayerService;
import sk.po.spse.beachclubapp.service.RoleService;

@RestController
public class HomePlayerController 
{
	
	@Autowired
	private HomePlayerService homePlayerService;
	
	@PostMapping("/home-players")
	public ModelAndView addHomePlayer(@RequestParam("name") String name, @RequestParam("points") int points,
			@RequestParam("sex") String sex, @RequestParam("phone") String phone,@RequestParam("email") String email,
			@RequestParam("address") String address, @RequestParam("registrationNumber") String registrationNumber, 
			@RequestParam("handed") String handed, @RequestParam("clothesSize") String clothesSize)
	{
		homePlayerService.createHomePlayer(name, points, sex, phone, email, address, registrationNumber, handed, clothesSize);
		return new ModelAndView("/homePlayersBrowse").addObject("homePlayers", homePlayerService.findAll());
	}
	
	 @GetMapping("/home-players")
	 public List<HomePlayer> getHomePlayers()
	 {
		return homePlayerService.findAll();
	 }
	 
	 @GetMapping(path="/home-players/{id}")
	 public HomePlayer getHomePlayer(@PathVariable("id") Long id)
	 {
		return homePlayerService.findHomePlayer(id);
	 }
	 
	 @PostMapping("/home-players/{id}")
	 public ModelAndView deleteHomePlayer(@PathVariable Long id)
	 {
		 homePlayerService.deleteHomePlayer(id);
		 return new ModelAndView("/homePlayersBrowse").addObject("homePlayers",homePlayerService.findAll());}
	 
	 
	 @PostMapping("/home-players/update/{id}")
	 public ModelAndView updateHomePlayer(@PathVariable Long id, @RequestParam("name") String name, 
			 @RequestParam("points") int points, @RequestParam("sex") String sex, 
			 @RequestParam("phone") String phone, @RequestParam("email") String email, 
			 @RequestParam("address") String address, @RequestParam("registrationNumber") String registrationNumber, 
			 @RequestParam("handed") String handed,@RequestParam("clothesSize") String clothesSize)
	 {
		homePlayerService.updateHomePlayer(id, name, points, sex, phone, 
				email, address, registrationNumber, handed, clothesSize);
		 return new ModelAndView("/homePlayersBrowse").addObject("homePlayers", homePlayerService.findAll());
	 }
	
	

}
