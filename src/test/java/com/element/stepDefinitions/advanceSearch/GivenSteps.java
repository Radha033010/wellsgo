package com.element.stepDefinitions.advanceSearch;

import com.element.stepDefinitions.StepDefinitionsBase;
import com.element.utils.CucumberTestContext;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;



public class GivenSteps extends StepDefinitionsBase {
    public GivenSteps(CucumberTestContext context) throws Throwable {
        super(context);
    }



    @And("I click on risk option")
    public void iClickOnRiskOption() {
        Pages().homePage().riskOption();
    }

    @Given("I select Entity type as company")
    public void iSelectEntityTypeAsCompany() throws InterruptedException {
        Pages().companyDetails().Entity_type();
        Thread.sleep(2000);
    }


    @Given("I search the entity and go to Compliance page of the entity")
    public void iSearchTheEntityAndGoToCompliancePageOfTheEntity() {
    }


    @Given("I Open the Company for screening window")
    public void iOpenTheCompanyForScreeningWindow() throws InterruptedException {
        Pages().companyDetails().Entity_type();
        Thread.sleep(2000);
        Pages().companyDetails().advanceSearch("Apple", "United State");
        Pages().companyDetails().searchCompany_list();
        Pages().companyDetails().complianceTab();
        Pages().companyDetails().addScreeningCandidate();
    }
    @And("^I click on the '(.*)' option$")
    public void iLoggedInAsAdminAndIAmOnTheRiskPage(String riskPage) throws Throwable {
        Pages().homePage().riskOption();
    }


    @And("I add the source link on sticky noted")
    public void iAddTheSourceLinkOnStickyNoted() throws Throwable{
        Pages().sourceEntity().addStickyNote();
    }

    @And("I am able to delete the added note")
    public void iAmAbleToDeleteTheAddedNote() throws Throwable{
        Pages().sourceEntity().deleteAddedNote();
    }

}

