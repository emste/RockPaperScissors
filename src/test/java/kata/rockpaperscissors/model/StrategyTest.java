package kata.rockpaperscissors.model;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static kata.rockpaperscissors.model.Strategy.PAPER;
import static kata.rockpaperscissors.model.Strategy.ROCK;
import static kata.rockpaperscissors.model.Strategy.SCISSORS;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class StrategyTest {

	@Parameters
	public static Collection<Object[]> data() {
		// the third element is the expected result when executing firstElement.isSuperiorTo(secondElement)
		return Arrays.asList(new Object[][]{
			{ROCK, PAPER, false},
			{ROCK, SCISSORS, true},
			{ROCK, ROCK, false},
			{PAPER, SCISSORS, false},
			{PAPER, ROCK, true},
			{PAPER, PAPER, false},
			{SCISSORS, ROCK, false},
			{SCISSORS, PAPER, true},
			{SCISSORS, SCISSORS, false}
		});
	}

	private Strategy firstStrategy;
	private Strategy secondStrategy;
	private boolean isFirstSuperior;

	public StrategyTest(Strategy firstStrategy, Strategy secondStrategy, boolean isFirstSuperior) {
		this.firstStrategy = firstStrategy;
		this.secondStrategy = secondStrategy;
		this.isFirstSuperior = isFirstSuperior;
	}

	@Test
	public void testSuperiority() {
		assertThat("Checking " + firstStrategy + " against " + secondStrategy,
			firstStrategy.isSuperiorTo(secondStrategy), is(isFirstSuperior));
	}

}
