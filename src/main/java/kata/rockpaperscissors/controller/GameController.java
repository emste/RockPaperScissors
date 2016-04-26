package kata.rockpaperscissors.controller;

import com.google.common.collect.ImmutableSet;
import java.util.Set;
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

import static kata.rockpaperscissors.model.Strategy.PAPER;
import static kata.rockpaperscissors.model.Strategy.ROCK;
import static kata.rockpaperscissors.model.Strategy.SCISSORS;
import static kata.rockpaperscissors.model.Strategy.WELL;

@RestController
public class GameController {

	private final Set<Strategy> basicStrategies = ImmutableSet.of(ROCK, PAPER, SCISSORS);
	private final Set<Strategy> extendedStratgies = ImmutableSet.of(ROCK, PAPER, SCISSORS, WELL);

	private final RockPaperScissorsService rockPaperScissorsService;

	@Autowired
	public GameController(RockPaperScissorsService rockPaperScissorsService) {
		this.rockPaperScissorsService = rockPaperScissorsService;
	}

	@RequestMapping(value = "/game/play", method = RequestMethod.POST)
	public OutcomeResponse play(@RequestBody GameRequest request) {

		return play(basicStrategies, request);
	}

	@RequestMapping(value = "/game/playExtended", method = RequestMethod.POST)
	public OutcomeResponse playExtended(@RequestBody GameRequest request) {

		return play(extendedStratgies, request);
	}

	private OutcomeResponse play(Set<Strategy> allowedStrategies, GameRequest request) {

		Strategy computerStrategy = rockPaperScissorsService.getRandomStrategy(allowedStrategies);
		Outcome outcome = rockPaperScissorsService.play(allowedStrategies, request.getChoosenStrategy(), computerStrategy);

		return new OutcomeResponse(request.getChoosenStrategy(), computerStrategy, outcome);
	}
}
