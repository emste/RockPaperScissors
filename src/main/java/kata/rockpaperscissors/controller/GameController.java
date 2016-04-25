package kata.rockpaperscissors.controller;

import kata.rockpaperscissors.model.GameRequest;
import kata.rockpaperscissors.model.Outcome;
import kata.rockpaperscissors.model.OutcomeResponse;
import kata.rockpaperscissors.model.Strategy;
import kata.rockpaperscissors.service.RockPaperScissorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {

	private final RockPaperScissorsService rockPaperScissorsService;

	@Autowired
	public GameController(RockPaperScissorsService rockPaperScissorsService) {
		this.rockPaperScissorsService = rockPaperScissorsService;
	}

	@RequestMapping(value = "/game/play", method = RequestMethod.POST)
	public OutcomeResponse play(@RequestBody GameRequest request) {

		Strategy computerStrategy = rockPaperScissorsService.getRandomStrategy();
		Outcome outcome = rockPaperScissorsService.play(request.getChoosenStrategy(), computerStrategy);

		return new OutcomeResponse(request.getChoosenStrategy(), computerStrategy, outcome);
	}
}
