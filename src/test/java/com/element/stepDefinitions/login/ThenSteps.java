package com.element.stepDefinitions.login;

import com.element.stepDefinitions.StepDefinitionsBase;
import com.element.utils.CucumberTestContext;
import cucumber.api.java.en.Then;

public class ThenSteps  extends StepDefinitionsBase {
    public ThenSteps(CucumberTestContext context) throws Throwable {
        super(context);
    }

    @Then("I should see {string} welcome message for admin user")
    public void iShouldSeeWelcomeMessageForAdminUser(String adminUser) {
        Pages().homePage().adminUser(adminUser);
    }

    @Then("I should see {string} welcome message for analyst user")
    public void iShouldSeeWelcomeMessageForAnalystUser(String analystUser) {
        Pages().homePage().analystUser(analystUser);
    }
}
