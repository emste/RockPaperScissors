package kata.rockpaperscissors.service;

import kata.rockpaperscissors.model.Outcome;
import kata.rockpaperscissors.model.Strategy;
import org.springframework.stereotype.Service;

@Service
public class RockPaperScissorsService {

	public Outcome play(Strategy playerChoosenStrategy, Strategy computerChoosenStrategy) {

		if (playerChoosenStrategy == computerChoosenStrategy) {
			return Outcome.DRAW;
		}

		if (playerChoosenStrategy.isSuperiorTo(computerChoosenStrategy)) {
			return Outcome.PLAYER_WINS;
		}

		if (computerChoosenStrategy.isSuperiorTo(playerChoosenStrategy)) {
			return Outcome.COMPUTER_WINS;
		}

		throw new IllegalStateException("There was neither a draw nor a winner. Invalid game state.");
	}
}
