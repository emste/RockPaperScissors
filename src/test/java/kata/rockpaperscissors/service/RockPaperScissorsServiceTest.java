package kata.rockpaperscissors.service;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import java.util.Set;
import kata.rockpaperscissors.model.Outcome;
import kata.rockpaperscissors.model.Strategy;
import org.junit.Test;

import static kata.rockpaperscissors.model.Outcome.COMPUTER_WINS;
import static kata.rockpaperscissors.model.Outcome.DRAW;
import static kata.rockpaperscissors.model.Outcome.PLAYER_WINS;
import static kata.rockpaperscissors.model.Strategy.PAPER;
import static kata.rockpaperscissors.model.Strategy.ROCK;
import static kata.rockpaperscissors.model.Strategy.SCISSORS;
import static kata.rockpaperscissors.model.Strategy.WELL;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RockPaperScissorsServiceTest {

	private RockPaperScissorsService rockPaperScissorsService = new RockPaperScissorsService();
	private Set<Strategy> allowedStrateies = ImmutableSet.of(ROCK, PAPER, SCISSORS);

	@Test
	public void testDraw() {

		// given
		Strategy playerStrategy = PAPER;
		Strategy computerStrategy = PAPER;

		// when
		Outcome outcome = rockPaperScissorsService.play(allowedStrateies, playerStrategy, computerStrategy);

		// then
		assertThat(outcome, is(DRAW));
	}

	@Test
	public void testPlayerWins() {

		// given
		Strategy playerStrategy = SCISSORS;
		Strategy computerStrategy = PAPER;

		// when
		Outcome outcome = rockPaperScissorsService.play(allowedStrateies, playerStrategy, computerStrategy);

		// then
		assertThat(outcome, is(PLAYER_WINS));
	}

	@Test
	public void testComputerWins() {

		// given
		Strategy playerStrategy = ROCK;
		Strategy computerStrategy = PAPER;

		// when
		Outcome outcome = rockPaperScissorsService.play(allowedStrateies, playerStrategy, computerStrategy);

		// then
		assertThat(outcome, is(COMPUTER_WINS));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidStrategy() {
		// given
		Strategy playerStrategy = WELL;
		Strategy computerStrategy = PAPER;

		// when
		Outcome outcome = rockPaperScissorsService.play(allowedStrateies, playerStrategy, computerStrategy);

		// then
		assertThat(outcome, is(COMPUTER_WINS));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRandomStrategyWithEmptySet() {
		rockPaperScissorsService.getRandomStrategy(Sets.newHashSet());
	}
}
