package gpes.test;

import gpes.test.steps.GameLogicSteps;

import org.jbehave.scenario.Scenario;

public class GameLogicScenario extends Scenario {
	public GameLogicScenario() {
		addSteps(new GameLogicSteps());
	}

}
