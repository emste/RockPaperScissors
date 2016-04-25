package kata.rockpaperscissors.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Each enum value represents a strategy that can be picked by either player.
 */
public enum Strategy {

	ROCK,
	PAPER,
	SCISSORS,
	WELL;

	// stores a mapping between a strategy and it's inferior counterpart
	private static final Map<Strategy, List<Strategy>> strategyMapping = new HashMap<Strategy, List<Strategy>>() {
		{
			put(ROCK, Arrays.asList(SCISSORS));
			put(PAPER, Arrays.asList(ROCK, WELL));
			put(SCISSORS, Arrays.asList(PAPER));
			put(WELL, Arrays.asList(ROCK, SCISSORS));
		}
	};

	public boolean isSuperiorTo(Strategy otherStrategy) {
		return strategyMapping.get(this).contains(otherStrategy);
	}
}
