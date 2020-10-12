package sk.po.spse.beachclubapp.web.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import sk.po.spse.beachclubapp.service.PlayerService;

@RestController
public class PlayerWebController 
{
	@Autowired
	private PlayerService playerService;
	
	
	@GetMapping(value = "/players/add")
	public ModelAndView getAddPlayers() {
		return new ModelAndView("/playersAdd");
	}
	
	@GetMapping(value = "/players/browse")
	public ModelAndView getAllPlayers() {
		return new ModelAndView("/playersBrowse").addObject("players", playerService.findAll());
	}
	
	@GetMapping(value = "/players/delete")
	public ModelAndView deletePlayers() {
		return new ModelAndView("/playersDelete").addObject("players", playerService.findAll());
	}
	
	@GetMapping(value = "/players/update/{id}")
	public ModelAndView updatePlayer(@PathVariable Long id)
	{	
		 return new ModelAndView("/playersUpdate").addObject("player", playerService.findPlayer(id));
	 }

	 @GetMapping(value = "/players/browse/pair")
	public ModelAndView createPlayersPair() {
		return new ModelAndView("/playersBrowsePair")
				.addObject("players", playerService.findAll())
				.addObject("firstPlayerId", "")
				.addObject("secondPlayerId", "");
	 }

}
