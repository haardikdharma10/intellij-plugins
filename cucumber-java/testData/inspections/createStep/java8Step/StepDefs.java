package cucumber.examples.java.calculator;

import cucumber.api.java.en.Given;
import cucumber.api.java8.En;

public class CreateAllStepDefs implements En {
    public CreateAllStepDefs() {
        Given("I have (\\d+) cukes in my belly", (Integer cukes) -> {

        });
    }
}
