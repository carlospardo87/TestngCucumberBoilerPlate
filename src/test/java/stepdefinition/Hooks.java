package stepdefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BaseStepDef {

    @Before
    public void  setupTest() {
        setUp();
    }

    @After
    public void afterScenario(Scenario scenario) {
        tearDown(scenario);
    }

}
