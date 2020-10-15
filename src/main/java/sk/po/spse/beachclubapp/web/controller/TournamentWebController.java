package sk.po.spse.beachclubapp.web.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import sk.po.spse.beachclubapp.entity.Pair;
import sk.po.spse.beachclubapp.service.ExcelService;
import sk.po.spse.beachclubapp.service.HomePlayerService;
import sk.po.spse.beachclubapp.service.PairService;
import sk.po.spse.beachclubapp.service.PlayerService;

@RestController
public class TournamentWebController 
{
	@Autowired
	private PairService pairService;
	
	
	@Autowired
	private ExcelService excelService;
	
	@GetMapping(value = "/tournament")
	public ModelAndView makeTournament() {
		return new ModelAndView("/tournament");
	}
	
	@GetMapping(value = "/tournament-pairs")
	public ModelAndView inputPairsInExcel() {
		List<Pair> pairs = pairService.findAll();
		excelService.inputListInExcel(pairs, "Presov Beachvolley Cup");
	
		return new ModelAndView("/finalTournament").addObject("pairs", pairService.findAll());
	}
	

}
