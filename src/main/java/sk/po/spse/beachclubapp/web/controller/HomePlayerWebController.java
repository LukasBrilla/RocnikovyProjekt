package sk.po.spse.beachclubapp.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import sk.po.spse.beachclubapp.service.EmployeeService;
import sk.po.spse.beachclubapp.service.HomePlayerService;

@RestController
public class HomePlayerWebController 
{
	@Autowired
	private HomePlayerService homePlayerService;
	
	
	@GetMapping(value = "/home-players/add")
	public ModelAndView getAddHomePlayers() {
		return new ModelAndView("/homePlayersAdd");
	}
	
	@GetMapping(value = "/home-players/browse")
	public ModelAndView getAllHomePlayers() {
		return new ModelAndView("/homePlayersBrowse").addObject("homePlayers", homePlayerService.findAll());
	}
	
	@GetMapping(value = "/home-players/delete")
	public ModelAndView deleteHomePlayers() {
		return new ModelAndView("/homePlayersDelete").addObject("homePlayers", homePlayerService.findAll());
	}
	
	@GetMapping(value = "/home-players/update/{id}")
	public ModelAndView updateHomePlayer(@PathVariable Long id)
	{	
		 return new ModelAndView("/homePlayersUpdate").addObject("homePlayer", homePlayerService.findHomePlayer(id));
	 }

}
