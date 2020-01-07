package com.element.stepDefinitions.login;

import com.element.stepDefinitions.CommonSteps;
import com.element.stepDefinitions.StepDefinitionsBase;
import com.element.utils.CucumberTestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class GivenSteps extends StepDefinitionsBase {
    public GivenSteps(CucumberTestContext context) throws Throwable {
        super(context);
    }

    @Given("^I logged in as Admin user$")
    public void i_am_logged_in_as_an_Admin() throws Throwable {
        CommonSteps givenSteps = new CommonSteps(cucumberTestContext);
        givenSteps.i_open_the_param_page("login");
        Pages().loginPage().loginAdmin(cucumberTestContext);

    }

    @Given("I logged in as analyst user")
    public void iLoggedInAsAnalystUser() throws Throwable {
        CommonSteps givenSteps = new CommonSteps(cucumberTestContext);
        givenSteps.i_open_the_param_page("login");
       Pages().loginPage().loginAnalyst(cucumberTestContext);

    }

}