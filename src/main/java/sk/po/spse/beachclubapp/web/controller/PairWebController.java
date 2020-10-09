package sk.po.spse.beachclubapp.web.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import sk.po.spse.beachclubapp.service.PairService;
import sk.po.spse.beachclubapp.service.PlayerService;

@RestController
public class PairWebController 
{
	
	@Autowired
	private PairService pairService;
	
	
	@GetMapping(value = "/pairs/add")
	public ModelAndView getAddPairs() {
		return new ModelAndView("/pairsAdd");
	}
	
	@GetMapping(value = "/pairs/browse")
	public ModelAndView getAllPairs() {
		return new ModelAndView("/pairsBrowse").addObject("pairs", pairService.findAll());
	}
	
	@GetMapping(value = "/pairs/delete")
	public ModelAndView deletePairs() {
		return new ModelAndView("/pairsDelete").addObject("pairs", pairService.findAll());
	}
	
	@GetMapping(value = "/pairs/update/{id}")
	public ModelAndView updatePair(@PathVariable Long id)
	{	
		 return new ModelAndView("/pairsUpdate").addObject("pairs", pairService.findRole(id));
	 }

}
