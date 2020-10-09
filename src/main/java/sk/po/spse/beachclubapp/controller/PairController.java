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

import sk.po.spse.beachclubapp.entity.Pair;
import sk.po.spse.beachclubapp.entity.Player;
import sk.po.spse.beachclubapp.service.PairService;
import sk.po.spse.beachclubapp.service.PlayerService;

@RestController
public class PairController 
{
	
	@Autowired
	private PairService pairService;
	
	@Autowired
	private PlayerService playerService;
	
	@PostMapping("/pairs")
	public ModelAndView addPair(@RequestParam("firstPlayerId") Long firstPlayerId, @RequestParam("secondPlayerId") Long secondPlayerId )
	{
		pairService.createPair(playerService.findPlayer(firstPlayerId), playerService.findPlayer(secondPlayerId));
		return new ModelAndView("/pairsBrowse").addObject("pairs", pairService.findAll());
	}

	
	@GetMapping("/pairs")
	 public List<Pair> getPairs()
	 {
		return pairService.findAll();
	 }
	 
	
	 @GetMapping(path="/pairs/{id}")
	 public Pair getPair(@PathVariable("id") Long id)
	 {
		return pairService.findById(id);
	 }
	 
	 
	 @PostMapping("/pairs/{id}")
	 public ModelAndView deletePair(@PathVariable Long id)
	 {
		 pairService.deletePair(id); 
		 
		 return new ModelAndView("/pairsBrowse").addObject("pairs", pairService.findAll());
	 }
	 
	 @PostMapping("/pairs/update/{id}")
	 public ModelAndView updatePair(@PathVariable Long id,@RequestParam("firstPlayerId") Long firstPlayerId, @RequestParam("secondPlayerId") Long secondPlayerId )
		{
			pairService.updatePair(id, playerService.findPlayer(firstPlayerId), playerService.findPlayer(secondPlayerId));
			return new ModelAndView("/pairsBrowse").addObject("pairs", pairService.findAll());
		}
	 
	 
}
