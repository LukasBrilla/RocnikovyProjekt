package sk.po.spse.beachclubapp.web.controller;

import javafx.collections.transformation.SortedList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import sk.po.spse.beachclubapp.entity.Pair;
import sk.po.spse.beachclubapp.service.PairService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

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
	
	@GetMapping(value = "/pairs/browseTournament")
	public ModelAndView getAllPairsOnTournament() {
		return new ModelAndView("/pairsBrowseTournament")
				.addObject("pairs", pairService.findAll())
				.addObject("registeredPairs", new ArrayList<Pair>());
	}

	@PostMapping(value = "/pairs/tournament/add")
	public ModelAndView addPairToRegistered(@RequestParam("pairId") Long pairId,
											@RequestParam("pairs") String pairs,
											@RequestParam("registeredPairs") String registeredPairs) {
		Pair pair = pairService.findById(pairId);
		Set<Pair> prs = getPairsFromStringIds(pairs);
		Set<Pair> regPrs = getPairsFromStringIds(registeredPairs);
		regPrs.add(pair);
		prs.remove(pair);
		return new ModelAndView("/pairsBrowseTournament")
				.addObject("pairs", prs)
				.addObject("registeredPairs", regPrs);
	}

	@PostMapping(value = "/pairs/tournament/delete")
	public ModelAndView deletePairFromRegistered(@RequestParam("pairId") Long pairId,
												 @RequestParam("pairs") String pairs,
												 @RequestParam("registeredPairs") String registeredPairs) {
		Pair pair = pairService.findById(pairId);
		Set<Pair> prs = getPairsFromStringIds(pairs);
		Set<Pair> regPrs = getPairsFromStringIds(registeredPairs);
		prs.add(pair);
		regPrs.remove(pair);
		return new ModelAndView("/pairsBrowseTournament")
				.addObject("pairs", prs)
				.addObject("registeredPairs", regPrs);
	}



	@GetMapping(value = "/pairs/tournament")
	public ModelAndView getSortedPairsOnTournament(@RequestParam("registeredPairs") String registeredPairs) {
		return new ModelAndView("/sortedPairsTournament").addObject("sortedPairs",
				new TreeSet(getPairsFromStringIds(registeredPairs)));
		
	}

	@GetMapping(value = "/pairs/delete")
	public ModelAndView deletePairs() {
		return new ModelAndView("/pairsDelete").addObject("pairs", pairService.findAll());
	}
	
	@GetMapping(value = "/pairs/update/{id}")
	public ModelAndView updatePair(@PathVariable Long id)
	{	
		 return new ModelAndView("/pairsUpdate").addObject("pair", pairService.findById(id));
	}




	private Set<Pair> getPairsFromStringIds(String ids) {
		Set<Pair> result = new HashSet<>();
		if (ids.length() <= 2) {
			return result;
		}
		String[] splitPair = ids.substring(1, ids.length() - 1).split(",");
		for (String s : splitPair) {
			result.add(pairService.findById(Long.parseLong(s.trim())));
		}
		return result;
	}

}
