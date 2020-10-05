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

import sk.po.spse.beachclubapp.entity.Player;
import sk.po.spse.beachclubapp.service.PlayerService;
@RestController
public class PlayerController 
{
	@Autowired
	private PlayerService playerService;
	
	@PostMapping("/players")
	public ModelAndView addPlayer(@RequestParam("name") String name, @RequestParam("points") int points, @RequestParam("sex") String sex)
	{
		playerService.createPlayer(name, points, sex);
		return new ModelAndView("/playersBrowse").addObject("players", playerService.findAll());
	}
	
	
	@GetMapping("/players")
	public List<Player> getPlayers()
	{
		return playerService.findAll();
		
	}
	
	 @GetMapping(path="/players/{id}")
	 public Player getPlayer(@PathVariable("id") Long id)
	 {
		return playerService.findPlayer(id);
	 }
	
	 @PostMapping("/players/{id}")
	 public ModelAndView deletePlayer(@PathVariable Long id)
	 {
		 playerService.deletePlayer(id); 
		 
		 return new ModelAndView("/playersBrowse").addObject("players", playerService.findAll());
	 }
	 
	 @PostMapping("/players/update/{id}")
	 public ModelAndView updatePlayer(@PathVariable Long id, @RequestParam("name") String name, @RequestParam("points") int points, @RequestParam("sex") String sex)
	 {
		playerService.updatePlayer(id, name, points, sex);	
		
		return new ModelAndView("/playersBrowse").addObject("players", playerService.findAll());
	 }
	
	
}
