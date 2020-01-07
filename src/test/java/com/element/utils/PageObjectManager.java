package com.element.utils;


import com.element.pageObjects.advanceSearch.CompanyDetails;
import com.element.pageObjects.advanceSearch.SourceEntity;
import com.element.pageObjects.bEentityPage.BEentityPage;
import com.element.pageObjects.HomePage;
import com.element.pageObjects.LoginPage;
import com.element.pageObjects.compliance.AddFile;
import com.element.pageObjects.compliance.AddNote;
import com.element.pageObjects.compliance.AuditTrail;
import com.element.pageObjects.sourceManagement.SourceManagement;
import org.openqa.selenium.WebDriver;


public class PageObjectManager {
    private WebDriver driver;


    private LoginPage loginPage;
    private HomePage homePage;
    private CompanyDetails companyDetails;
    private SourceManagement sourceManagement;
    private BEentityPage bEentityPage;
    private SourceEntity sourceEntity;
    private AddNote addNote;
    private AddFile addFile;
    private AuditTrail auditTrail;
    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage loginPage() {
        return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
    }

    public HomePage homePage() {
        return (homePage == null) ? homePage = new HomePage(driver) : homePage;
    }

    public CompanyDetails companyDetails() {
        return (companyDetails == null) ? companyDetails = new CompanyDetails(driver) : companyDetails;
    }

    public SourceManagement sourceManagement() {
        return (sourceManagement == null) ? sourceManagement = new SourceManagement(driver) : sourceManagement;
    }

    public BEentityPage bEentityPage() {
        return (bEentityPage == null) ? bEentityPage = new BEentityPage(driver) : bEentityPage;
    }
    public SourceEntity sourceEntity() {
        return (sourceEntity == null) ? sourceEntity = new SourceEntity(driver) : sourceEntity;
    }
    public AddNote addNote() {
        return (addNote == null) ? addNote = new AddNote(driver) : addNote;
    }

    public AddFile addFile() {
        return (addFile == null) ? addFile = new AddFile(driver) : addFile;
    }

    public AuditTrail auditTrail(){
        return (auditTrail==null)? auditTrail=new AuditTrail(driver):auditTrail;
    }
}
