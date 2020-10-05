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
	public Pair addPair(@RequestParam("firstPlayerId") Long firstPlayerId, @RequestParam("secondPlayerId") Long secondPlayerId )
	{
		return pairService.createPair(playerService.findPlayer(firstPlayerId), playerService.findPlayer(secondPlayerId));
	}

	
	@GetMapping("/pairs")
	 public List<Pair> getPairs()
	 {
		return pairService.findAll();
	 }
	 
	
	 @GetMapping(path="/pairs/{id}")
	 public Pair getPair(@PathVariable("id") Long id)
	 {
		return pairService.findRole(id);
	 }
	 
	 
	 @DeleteMapping("/pairs/{id}")
	 public String deletePair(@PathVariable Long id)
	 {
		 if (pairService.deletePair(id)) 
		 {
			 return "Done !";
		 } 
		 else
		 {
			 return "Wrong id !";
		 }
	 }
	 
	 @PutMapping("/pairs/{id}")
	 public Pair updatePair(@PathVariable Long id,@RequestParam("firstPlayerId") Long firstPlayerId, @RequestParam("secondPlayerId") Long secondPlayerId )
		{
			return pairService.updatePair(id, playerService.findPlayer(firstPlayerId), playerService.findPlayer(secondPlayerId));
		}
	 
	 
}
