package kata.rockpaperscissors.model;

/**
 * Each enum value represents a strategy that can be picked by either player.
 */
public enum Strategy {

	ROCK,
	PAPER,
	SCISSORS;

	public boolean isSuperiorTo(Strategy otherStrategy) {
		return false;
	}
}
