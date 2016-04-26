package kata.rockpaperscissors.service;

import java.util.ArrayList;
import java.util.Random;
import java.util.Set;
import kata.rockpaperscissors.model.Outcome;
import kata.rockpaperscissors.model.Strategy;
import org.springframework.stereotype.Service;

/**
 * Executes the RPC game logic by comparing the input parameters and returning the proper outcome.
 */
@Service
public class RockPaperScissorsService {

	private Random random = new Random();

	public Strategy getRandomStrategy(Set<Strategy> allowedStrategies) {

		if (allowedStrategies.isEmpty()) {
			throw new IllegalArgumentException("There needs to be at least one allowed strategy!");
		}

		int randomIndexInBound = random.nextInt(allowedStrategies.size());

		return new ArrayList<>(allowedStrategies).get(randomIndexInBound);
	}

	public Outcome play(Set<Strategy> allowedStrategies, Strategy playerChoosenStrategy, Strategy computerChoosenStrategy) {

		if (!allowedStrategies.contains(playerChoosenStrategy) || !allowedStrategies.contains(computerChoosenStrategy)) {
			throw new IllegalArgumentException("Only allowed strategies must be used: " + allowedStrategies.toString());
		}

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
