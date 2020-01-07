package com.element.pageObjects.advanceSearch;

import com.element.helper.BrowserHelper;
import com.element.helper.JavaScriptHelper;
import com.element.helper.WaitHelper;
import com.element.pageObjects.BasePage;
import com.element.utils.JsonReader;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class CompanyDetails extends BasePage {
    // Reusable classes object
    JavaScriptHelper javaScriptHelper = new JavaScriptHelper(driver);
    JsonReader json = new JsonReader();
    BrowserHelper browserHelper = new BrowserHelper(driver);
    WaitHelper waitHelper = new WaitHelper(driver);
    static String jsonResults;
    WebElement webelement;

    @FindBy(xpath = "//p[text()='Advanced Search']/parent::button")
    WebElement Advance_search;

    @FindBy(xpath = "(//button[@id='single-button'])[1]")
    WebElement EntityType;

    @FindBy(linkText = "Company")
    WebElement company;

    @FindBy(xpath = "//input[@placeholder='Company Name']")
    WebElement Company_name;

    @FindBy(xpath = "//input[@placeholder='Jurisdiction Name']")
    WebElement Jurisdiction;

    @FindBy(xpath = "//button[@ng-click='updateCompanyParam()']")
    WebElement update;

    @FindBy(xpath = "//span[text()='SEARCH']")
    WebElement Search;

    @FindBy(xpath = "(//div[contains(@class,'center-content-wrapper')])[1]")
    WebElement searchFirstList;

    @FindBy(xpath = "//span[text()='Overview']")
    WebElement Overview;

    @FindBy(xpath = "//span[text()='Compliance']")
    WebElement Compliance;

    @FindBy(xpath = "//h3[@class='d-ib ng-binding']")
    WebElement zeroSearchResutls;

    @FindBy(xpath = "//span[text()='SEARCH']")
    WebElement searchBtn;

    @FindBy(xpath = "//i[@class='fa fa-plus-circle']")
    WebElement addScreeningCandidatebtn;

    @FindBy(xpath = "//input[@ng-model='customSelectedScreeningPerson'][2]")
    WebElement companyScreeningCandidate;

    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstNameCompanyScreeningCandidate;


    public CompanyDetails(WebDriver driver) {
        super(driver);
    }

    public void sendKeyAtfirstNameCompanyScreeningCandidate(String value) {
        waitAndSendKey(firstNameCompanyScreeningCandidate, value, 10);
    }

    public void advanceSearch() {
        waitAndClick(Advance_search, 10);
    }

    public void addScreeningCandidate() {
        waitAndClick(addScreeningCandidatebtn, 10);
    }

    public void Entity_type() {
        waitAndClick(EntityType, 20);
        waitAndClick(company, 20);
    }

    public void testZeroResults() {
        waitAndAssert(zeroSearchResutls, 10, "0 RESULTS");
    }

    public void advanceSearch(String company, String country) throws InterruptedException {
        waitAndClick(Company_name, 10);
        Company_name.sendKeys(company);
        waitAndClick(Jurisdiction, 10);
        Jurisdiction.sendKeys(country);
        WebElement Jurisdiction_list = driver.findElement(By.xpath("//*[text()='" + country + "']"));
        waitAndClick(Jurisdiction_list, 10);
        Thread.sleep(2000);
        waitAndClick(update, 10);
    }

    public void companyScreeningCandidate(String country) throws InterruptedException {
        waitAndClick(companyScreeningCandidate, 10);
        companyScreeningCandidate.sendKeys(country);
        WebElement companyScreening_list = driver.findElement(By.xpath("//*[text()='" + country + "']"));
        waitAndClick(companyScreening_list, 10);

    }

    public void countrySearch(String country) throws InterruptedException {
        waitAndClick(Jurisdiction, 10);
        Jurisdiction.sendKeys(country);
        WebElement Jurisdiction_list = driver.findElement(By.xpath("//*[text()='" + country + "']"));
        waitAndClick(Jurisdiction_list, 10);
        Thread.sleep(2000);
        waitAndClick(update, 10);
    }

    public void searchCompany_list() throws InterruptedException {
        waitAndClick(Search, 20);
        waitAndClick(searchFirstList, 20);
        browserHelper.SwitchToWindow(1);
    }

    public void clickOnSearch() {
        waitAndClick(Search, 10);
    }

    public void overViewPage() throws InterruptedException {
        browserHelper.SwitchToWindow(1);
        waitHelper.waitForElementVisible(By.xpath("//div[@class='tabs-section']//i[@class='fa fa-search']"), 40, 10);
        WebElement search_icon = driver.findElement(By.xpath("//div[@class='tabs-section']//i[@class='fa fa-search']"));
        new Actions(driver).moveToElement(search_icon).build().perform();
        Thread.sleep(1000);
        waitAndClick(Overview, 10);
    }

    public void complianceTab() throws InterruptedException {
        waitHelper.waitForElementVisible(By.xpath("//div[@class='tabs-section']//i[@class='fa fa-search']"), 100, 10);
        WebElement search_icon = driver.findElement(By.xpath("//div[@class='tabs-section']//i[@class='fa fa-search']"));
        new Actions(driver).moveToElement(search_icon).build().perform();
        Thread.sleep(1000);
        waitAndClick(Compliance, 10);
    }

    public int returnList(String companyName) {
        int list = 0;
        switch (companyName) {
            case "Banque Raiffeisen":
                list = 0;
                return list;
            case "Central Bank of Nigeria":
                list = 1;
                return list;
            case "AIB MORTGAGE BANK":
                list = 2;
                return list;
        }
        return list;
    }

    public void verifyEntityDetails(String title, String companyName) throws InterruptedException, IOException, ParseException {
        int list = returnList(companyName);
        String feature = "ComapnyOverview";
        String jsonPath = "src/test/resources/filestoupload/ComapnyOverview.json";
        switch (title) {
            case "EntityName":
                waitHelper.waitForElementVisible(By.xpath("//h2[contains(@class,'company-title')]"), 40, 10);
                webelement = driver.findElement(By.xpath("//h2[contains(@class,'company-title')]"));
                System.out.println(webelement.getText());
                Thread.sleep(1000);
                jsonResults = json.jsonReader(title, list, feature, jsonPath);
                assertEquals(webelement.getText(), jsonResults);
                break;
            case "AddressLine":
                webelement = driver.findElement(By.xpath("//p[@class='text-uppercase ng-binding']"));
                System.out.println(webelement.getText());
                jsonResults = json.jsonReader(title, list, feature, jsonPath);
                System.out.println("jsonResults:" + jsonResults);
                assertEquals(webelement.getText(), jsonResults);
                break;
            case "Risk Score":
                webelement = driver.findElement(By.xpath("(//h3[contains(text(),'Risk Score ')])[1]"));
                javaScriptHelper.scrollIntoView(webelement);
                System.out.println(webelement.getText());
                jsonResults = json.jsonReader(title, list, feature, jsonPath);
                assertEquals(webelement.getText(), jsonResults);
                break;
            default:
                webelement = driver.findElement(By.xpath("//*[contains(text(),'" + title + "')]"));
                javaScriptHelper.scrollIntoView(webelement);
                Thread.sleep(1000);
                System.out.println(webelement.getText());
                jsonResults = json.jsonReader(title, list, feature, jsonPath);
                assertEquals(webelement.getText(), jsonResults);
                break;
        }
    }

    public void verifyComplianceDetails(String title, String companyName) throws InterruptedException, IOException, ParseException {
        int list = returnList(companyName);
        String feature = "Compliance";
        String jsonPath = "src/test/resources/filestoupload/ComplianceDetails.json";
        switch (title) {
            case "EntityName":
                waitHelper.waitForElementVisible(By.xpath("//h2[contains(@class,'company-title')]"), 40, 10);
                WebElement webelement = driver.findElement(By.xpath("//h2[contains(@class,'company-title')]"));
                jsonResults = json.jsonReader(title, list, feature, jsonPath);
                assertEquals(webelement.getText(), jsonResults);
                break;
            default:
                webelement = driver.findElement(By.xpath("//p[contains(text(),'" + title + "')]"));
                javaScriptHelper.scrollIntoView(webelement);
                jsonResults = json.jsonReader(title, list, feature, jsonPath);
                assertEquals(webelement.getText(), jsonResults);
                WebElement webelement2 = driver.findElement(By.xpath("(//p[contains(text(),'" + title + "')]//following::div)[1]//span[@class='ng-binding ng-scope']"));
                jsonResults = json.jsonReader(title + "Value", list, feature, jsonPath);
                assertEquals(webelement2.getText(), jsonResults);
                break;
        }
    }

    public void verifyComplianceCompanyIdentifiers(String title, String companyName) throws InterruptedException, IOException, ParseException {
        int list = returnList(companyName);
        String feature = "Company Identifiers";
        String jsonPath = "src/test/resources/filestoupload/CompanyIdentifiersDetails.json";
        WebElement webelement = driver.findElement(By.xpath("//p[contains(text(),'" + title + "')]"));
        javaScriptHelper.scrollIntoView(webelement);
        jsonResults = json.jsonReader(title, list, feature, jsonPath);
        assertEquals(webelement.getText(), jsonResults);
        WebElement webelement2 = driver.findElement(By.xpath("(//p[contains(text(),'" + title + "')]//following::div)[1]//span[@class='ng-binding ng-scope']"));
        jsonResults = json.jsonReader(title + "Value", list, feature, jsonPath);
        assertEquals(webelement2.getText(), jsonResults);
    }
}