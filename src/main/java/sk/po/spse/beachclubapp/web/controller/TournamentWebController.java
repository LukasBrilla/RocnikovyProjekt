package sk.po.spse.beachclubapp.web.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import sk.po.spse.beachclubapp.service.PlayerService;

@RestController
public class TournamentWebController 
{
	@GetMapping(value = "/tournament")
	public ModelAndView makeTournament() {
		return new ModelAndView("/tournament");
	}

}
