package kata.rockpaperscissors.controller;

import kata.rockpaperscissors.model.GameRequest;
import kata.rockpaperscissors.model.OutcomeResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {

	@RequestMapping(value = "/game/play", method = RequestMethod.POST)
	public OutcomeResponse play(@RequestBody GameRequest request) {

		return new OutcomeResponse();
	}
}
