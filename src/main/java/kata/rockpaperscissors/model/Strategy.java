package kata.rockpaperscissors.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Each enum value represents a strategy that can be picked by either player.
 */
public enum Strategy {

	ROCK,
	PAPER,
	SCISSORS;

	// stores a mapping between a strategy and it's inferior counterpart
	private static final Map<Strategy, Strategy> strategyMapping = new HashMap<Strategy, Strategy>() {
		{
			put(ROCK, SCISSORS);
			put(PAPER, ROCK);
			put(SCISSORS, PAPER);
		}
	};

	public boolean isSuperiorTo(Strategy otherStrategy) {
		return strategyMapping.get(this) == otherStrategy;
	}
}
