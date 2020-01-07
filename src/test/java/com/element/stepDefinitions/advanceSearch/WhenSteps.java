package com.element.stepDefinitions.advanceSearch;

import com.element.stepDefinitions.StepDefinitionsBase;
import com.element.utils.CucumberTestContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;


public class WhenSteps extends StepDefinitionsBase {
    public WhenSteps(CucumberTestContext context) throws Throwable {
        super(context);
    }
    @And("I click on the Advance Search")
    public void iClickOnTheAdvanceSearch() throws InterruptedException {
        Pages().companyDetails().advanceSearch();
        Thread.sleep(2000);
    }

    @And("I enter the Company Name as {string} and Jurisdictions as {string}")
    public void iEnterTheCompanyNameAsAndJurisdictionsAs(String company, String country) throws InterruptedException {
        Pages().companyDetails().advanceSearch(company,country);
    }

    @When("I search the entity and go to overview page of the entity")
    public void iSearchTheEntityAndGoToOverviewPageOfTheEntity() throws InterruptedException {
        Pages().companyDetails().searchCompany_list();
        Pages().companyDetails().overViewPage();
    }

    @When("I search the entity and go to compliance tab of the entity")
    public void iSearchTheEntityAndGoToComplianceTabOfTheEntity() throws InterruptedException {
        Pages().companyDetails().searchCompany_list();
        Pages().companyDetails().complianceTab();
    }

    @When("I search the entity")
    public void iSearchTheEntity() throws InterruptedException {
        Pages().companyDetails().clickOnSearch();

    }


    @When("I  go to Company Status and Change the source to Global Financial Intelligence")
    public void iGoToCompanyStatusAndChangeTheSourceToGlobalFinancialIntelligence() throws Throwable {
        Pages().sourceEntity().changeSource();

    }

    @When("I Go to User-Input and Add the new source link company")
    public void iGoToUserInputAndAddTheNewSourceLinkCompany()  throws Throwable{
        Pages().sourceEntity().addSource();
    }

    @When("I add the new note")
    public void iAddTheNewNote() throws Throwable{
        Pages().sourceEntity().AddNote();
    }

    @When("I search the Source link as {string} and upload the document")
    public void iSearchTheSourceLinkAsAndUploadTheDocument(String arg0)throws Throwable {
        Pages().sourceEntity().FileUpload(arg0);
    }

    @When("I Add the large file size")
    public void iAddTheLargeFileSize()throws Throwable {
        Pages().sourceEntity().uploadLargeImage("large");
    }

    @When("I click on create custom-chart and click on the complex structure toggle button")
    public void iClickOnCreateCustomChartAndClickOnTheComplexStructureToggleButton() throws Throwable{
        Pages().sourceEntity().createCustomChart();
        Pages().sourceEntity().clickComplex();
    }
}
