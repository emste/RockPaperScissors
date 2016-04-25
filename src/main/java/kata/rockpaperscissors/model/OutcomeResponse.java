package kata.rockpaperscissors.model;

public class OutcomeResponse {

	private final Strategy playerStrategy;

	private final Strategy computerStrategy;

	private final Outcome outcome;

	public OutcomeResponse(Strategy playerStrategy, Strategy computerStrategy, Outcome outcome) {
		this.playerStrategy = playerStrategy;
		this.computerStrategy = computerStrategy;
		this.outcome = outcome;
	}

	public Strategy getComputerStrategy() {
		return computerStrategy;
	}

	public Outcome getOutcome() {
		return outcome;
	}

	public Strategy getPlayerStrategy() {
		return playerStrategy;
	}
}
