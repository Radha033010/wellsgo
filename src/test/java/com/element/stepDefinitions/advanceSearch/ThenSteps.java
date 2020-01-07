package com.element.stepDefinitions.advanceSearch;

import com.element.stepDefinitions.StepDefinitionsBase;
import com.element.utils.CucumberTestContext;
import com.element.utils.Dataprovider;
import cucumber.api.java.en.Then;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ThenSteps extends StepDefinitionsBase {
    public ThenSteps(CucumberTestContext context) throws Throwable {
        super(context);
    }

    @Then("I should see search results as zero")
    public void iShouldSeeSearchResultsAsZero() {
        Pages().companyDetails().testZeroResults();
    }

    @Then("I should see {string} in Jurisidication list")
    public void iShouldSeeInJurisidicationList(String arg0) throws InterruptedException {
        Pages().companyDetails().countrySearch(arg0);
    }

    @Then("I should see {string} at Screening Candidates")
    public void iShouldSeeAtScreeningCandidates(String arg0) throws InterruptedException {
        Pages().companyDetails().companyScreeningCandidate(arg0);
        Pages().companyDetails().sendKeyAtfirstNameCompanyScreeningCandidate("vTest");
    }

    @Then("I should see Company Details section with all information like {string}, Company Status, Alias Name etc")
    public void iShouldSeeCompanyDetailsSectionWithAllInformationLikeCompanyStatusAliasNameEtc(String companyName) throws InterruptedException, ParseException, IOException {
        Pages().companyDetails().verifyEntityDetails("EntityName", companyName);
        Pages().companyDetails().verifyEntityDetails("Contact Address", companyName);
        Pages().companyDetails().verifyEntityDetails("AddressLine", companyName);
        Pages().companyDetails().verifyEntityDetails("Head Quarters", companyName);
        Pages().companyDetails().verifyEntityDetails("Risk Score", companyName);
        Pages().companyDetails().verifyEntityDetails("Screening Results", companyName);
        Pages().companyDetails().verifyEntityDetails("Risk Rating", companyName);
        Pages().companyDetails().verifyEntityDetails("Related Entities", companyName);
        Pages().companyDetails().verifyEntityDetails("ASSOCIATED LOCATIONS", companyName);
        Pages().companyDetails().verifyEntityDetails("Who Are We", companyName);
        Pages().companyDetails().verifyEntityDetails("Leadership", companyName);
        Pages().companyDetails().verifyEntityDetails("Stock Performance", companyName);
        Pages().companyDetails().verifyEntityDetails("Visual Link Analysis", companyName);
        Pages().companyDetails().verifyEntityDetails("Associated Companies", companyName);
    }

    @Then("I should see compliance Details section with all information like {string} , Company Status, City etc")
    public void iShouldSeeComplianceDetailsSectionWithAllInformationLikeCompanyStatusCityEtc(String companyName) throws InterruptedException, ParseException, IOException {
        Pages().companyDetails().verifyComplianceDetails("EntityName", companyName);
        Pages().companyDetails().verifyComplianceDetails("Company Status", companyName);
        Pages().companyDetails().verifyComplianceDetails("Alias Name", companyName);
        Pages().companyDetails().verifyComplianceDetails("Registered Address", companyName);
        Pages().companyDetails().verifyComplianceDetails("Street Address", companyName);
        Pages().companyDetails().verifyComplianceDetails("City", companyName);
        Pages().companyDetails().verifyComplianceDetails("Postal Code", companyName);
        Pages().companyDetails().verifyComplianceDetails("Country", companyName);
        Pages().companyDetails().verifyComplianceDetails("Industry-Type", companyName);
        Pages().companyDetails().verifyComplianceDetails("Legal Type", companyName);
        Pages().companyDetails().verifyComplianceDetails("Stock Exchange", companyName);
        Pages().companyDetails().verifyComplianceDetails("Stock Ticker", companyName);
        Pages().companyDetails().verifyComplianceDetails("Date of Incorporation", companyName);
        Pages().companyDetails().verifyComplianceDetails("IPO Date", companyName);
        Pages().companyDetails().verifyComplianceDetails("Registered Phone Number", companyName);
        Pages().companyDetails().verifyComplianceDetails("Registered Fax Number", companyName);
        Pages().companyDetails().verifyComplianceDetails("Headquater Phone Number", companyName);
        Pages().companyDetails().verifyComplianceDetails("Headquarters Fax Number", companyName);
        Pages().companyDetails().verifyComplianceDetails("Domiciled In", companyName);
        Pages().companyDetails().verifyComplianceDetails("Website", companyName);
        Pages().companyDetails().verifyComplianceDetails("Regulation Status", companyName);
        Pages().companyDetails().verifyComplianceDetails("Regulation Status Effective Date", companyName);
    }

    @Then("I should see Company Identifiers section with all information like {string} , VAT, LEI etc")
    public void iShouldSeeCompanyIdentifiersSectionWithAllInformationLikeVATLEIEtc(String companyName) throws Throwable  {
        Pages().companyDetails().verifyComplianceCompanyIdentifiers("VAT/TIN", companyName);
        Pages().companyDetails().verifyComplianceCompanyIdentifiers("LEI", companyName);
        Pages().companyDetails().verifyComplianceCompanyIdentifiers("Trade/Commerce", companyName);
        Pages().companyDetails().verifyComplianceCompanyIdentifiers("International Securities Identification Number", companyName);
        Pages().companyDetails().verifyComplianceCompanyIdentifiers("BIC / Swift Codes", companyName);
    }

    @Then("I should see the update source link")
    public void iShouldSeeTheUpdateSourceLink() throws Throwable{
        Pages().sourceEntity().verifyUpdateSource("Global Financial Intelligence");
    }

    @Then("^I should see the the extra body screenshot information$")
    public void iShouldSeeTheTheExtraBodyScreenshotInformation() throws Throwable{
        Pages().sourceEntity().screenExtraBody();
    }

    @Then("I should see the added page {string} in attachment window")
    public void iShouldSeeTheAddedPageInAttachmentWindow(String arg0) throws Throwable {
        Pages().sourceEntity().VerifyAddPage(arg0);
    }

    @Then("I verify the All hyperlink on Company details Section")
    public void iVerifyTheAllHyperlinkOnCompanyDetailsSection()  throws Throwable{
        Pages().sourceEntity(). Hyperlink();
        Pages().sourceEntity().uploadDocumentCompanyInformation("path");
    }

    @Then("I should see proper error message on pop up screen")
    public void iShouldSeeProperErrorMessageOnPopUpScreen()throws Throwable {
    }

    @Then("I should see the complex indicator button should enabled")
    public void iShouldSeeTheComplexIndicatorButtonShouldEnabled() throws Throwable{
        Pages().sourceEntity().verifyComplexEnable();
    }
}
