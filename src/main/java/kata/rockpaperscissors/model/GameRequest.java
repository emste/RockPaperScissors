package kata.rockpaperscissors.model;

public class GameRequest {

	private Strategy choosenStrategy;

	public Strategy getChoosenStrategy() {
		return choosenStrategy;
	}

	public void setChoosenStrategy(Strategy choosenStrategy) {
		this.choosenStrategy = choosenStrategy;
	}
}
