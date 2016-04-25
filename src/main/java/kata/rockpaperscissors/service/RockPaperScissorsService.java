package kata.rockpaperscissors.service;

import java.util.Random;
import kata.rockpaperscissors.model.Outcome;
import kata.rockpaperscissors.model.Strategy;
import org.springframework.stereotype.Service;

/**
 * Executes the RPC game logic by comparing the input parameters and returning the proper outcome.
 */
@Service
public class RockPaperScissorsService {

	private Random random = new Random();

	public Strategy getRandomStrategy() {
		Strategy[] strategies = Strategy.values();

		return strategies[random.nextInt(strategies.length)];
	}

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
