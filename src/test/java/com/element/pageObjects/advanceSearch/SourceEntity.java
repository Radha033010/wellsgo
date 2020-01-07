package com.element.pageObjects.advanceSearch;


import com.element.helper.DropFileHelper;
import com.element.helper.JavaScriptHelper;
import com.element.helper.WaitHelper;
import com.element.pageObjects.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

public class SourceEntity extends BasePage {

    @FindBy(xpath = "//h3[text()='Company details']/parent::div")
    WebElement CompanyDetails;

    @FindBy(xpath = "(//p[contains(text(),'Company Status')]/following::div[1]//i)[2]")
    WebElement companyStatusResources;

    @FindBy(xpath = "//input[@ng-value='userModifiedValue']/parent::label")
    WebElement adminUserInput;

    @FindBy(xpath = "//span[contains(text(),'Secondary')]/parent::a")
    WebElement ExpandSecondary;

    @FindBy(xpath = "//p[contains(text(),'Global Financial Intelligence')]/following::label[1]")
    WebElement Enable_GFI;

    @FindBy(xpath = "//button[contains(text(),'Save')]")
    WebElement Save;

    @FindBy(xpath = "//span[contains(text(),'Global Financial Intelligence')]")
    WebElement VerifyUpdatedSource;

    @FindBy(xpath = "//input[@placeholder='source']")
    WebElement sourceInput;

    @FindBy(xpath = "//ul[contains(@class,'custom-list')]//input[@type='text']")
    WebElement sourceURL;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement Apply;

    @FindBy(id = "entityClipboard")
    WebElement attachment;

    @FindBy(xpath = "(//h5[text()='My Sticky Notes'])[2]/parent::div//ul//li[1]")
    WebElement addedNote;

    @FindBy(xpath = "//div[contains(@class,'textarea-body')]")
    WebElement extraBody;

    //add note
    @FindBy(xpath = "(//button[contains(@class,'sm-btns btn-blue')])[1]")
    WebElement note;

    //title
    @FindBy(id = "getTitle")
    WebElement noteTitle;

    @FindBy(xpath = "//button[text()='Save']")
    WebElement saveNote;


    @FindBy(xpath = "//i[contains(@class,'fa pad-r0')]/parent::a")
    WebElement notedSourceLink;

    @FindBy(xpath = "//span[text()='Title']/parent::div//input")
    WebElement notedSourceTitle;

    @FindBy(xpath = "//input[@placeholder='source']")
    WebElement inputSourceNote;

    @FindBy(xpath = "(//i[contains(@class,'fa-link ng-scope')])[1]")
    WebElement SelectLink;

    @FindBy(xpath = "(//h5[text()='My Sticky Notes'])[2]/parent::div//ul//li[1]//i[contains(@class,'text-coral-red')]")
    WebElement deleteNote;

    @FindBy(xpath = " //button[text()='Yes']")
    WebElement deleteNoteYes;


    //upload file in source link on menu top
    @FindBy(xpath = "//i[contains(@class,'c-pointer fa-link')]")
    WebElement topMenuSource;

    @FindBy(id = "upload-doc-file-title")
    WebElement FileTitle;

    @FindBy(css = ".btn-update")
    WebElement uploadNewFile;

    //delete add page source
    @FindBy(xpath = "//h5[text()='My Evidence section']/parent::div//ul//li[1]//i[contains(@class,'text-coral-red')]")
    WebElement deletePage;
    DropFileHelper dropFileHelper = new DropFileHelper();

    JavaScriptHelper javaScriptHelper = new JavaScriptHelper(driver);
    WaitHelper waitHelper = new WaitHelper(driver);

    public SourceEntity(WebDriver driver) {
        super(driver);
    }

    public void changeSource() throws InterruptedException {
        waitAndClick(companyStatusResources, 20);
        if (adminUserInput.isSelected()) {
            waitAndClick(adminUserInput, 20);
            Thread.sleep(1000);
        }
        waitAndClick(ExpandSecondary, 30);
        waitAndClick(Enable_GFI, 20);
        Thread.sleep(1000);
        javaScriptHelper.scrollToElemetAndClick(Save);
        Thread.sleep(1000);
        javaScriptHelper.scrollDown();
        Thread.sleep(1000);
        new Actions(driver).moveToElement(companyStatusResources).build().perform();
        Thread.sleep(2000);

    }

    public void verifyUpdateSource(String GFI) {
        waitAndAssert(VerifyUpdatedSource, 30, GFI);
    }

    public void addSource() throws InterruptedException {
        waitHelper.waitForElementVisible(By.xpath("(//p[contains(text(),'Company Status')]/following::div[1]//i)[2]"), 40, 10);
        waitAndClick(companyStatusResources, 20);
        if (!adminUserInput.isSelected()) {
            waitAndClick(adminUserInput, 20);
            Thread.sleep(1000);
        }
        waitAndSendKey(sourceInput, "newSource", 20);
        waitAndSendKey(sourceURL, "https://stackoverflow.com/", 20);
        waitAndClick(Apply, 10);
        waitAndClick(Save, 10);
        Thread.sleep(3000);
        waitAndClick(CompanyDetails, 20);
        Thread.sleep(4000);
        waitAndAssert(sourceInput, 20, "newSource");
    }

    public void AddNote() throws InterruptedException {
        waitAndClick(attachment, 20);
        Thread.sleep(2000);
        waitHelper.waitForElementVisible(By.xpath("(//button[contains(@class,'sm-btns btn-blue')])[1]"), 40, 10);
        waitAndClick(note, 30);
        waitAndSendKey(noteTitle, "shadabNote", 20);
        waitAndClick(saveNote, 20);

    }

    public void screenExtraBody() {
//        waitHelper.waitForElementVisible(By.xpath("//i[contains(@class,'fa pad-r0')]/parent::a"), 30, 5);
//        boolean extra = driver.findElement(By.xpath("//i[contains(@class,'fa pad-r0')]/parent::a")).isDisplayed();
//        System.out.println(extra);
    }

    public void addStickyNote() {
        waitAndClick(notedSourceLink, 20);
        waitAndSendKey(notedSourceTitle, "Shadab", 20);
        waitAndSendKey(inputSourceNote, "ABC123", 20);
        waitAndClick(SelectLink, 20);
        waitAndClick(Apply, 20);
    }

    public void deleteAddedNote() {
        waitAndClick(deleteNote, 10);
        waitAndClick(deleteNoteYes, 20);
    }

    public void FileUpload(String SourceSearch) throws InterruptedException, AWTException {
        waitAndClick(topMenuSource, 10);
        waitAndSendKey(sourceInput, SourceSearch, 20);
        waitHelper.waitForElementVisible(By.xpath("(//span[text()='" + SourceSearch + "']//following::i[contains(@class,'icon-cloud-upload')])[1]"), 40, 10);
        WebElement uploadFile = driver.findElement(By.xpath("(//span[text()='" + SourceSearch + "']//following::i[contains(@class,'icon-cloud-upload')])[1]"));
        waitAndClick(uploadFile, 10);
        waitAndSendKey(FileTitle, "Shadab", 20);
        Thread.sleep(1000);
        waitAndClick(uploadNewFile, 20);
        Thread.sleep(2000);
        String path = "F:\\29NovTIMIB\\element-automated-testing\\src\\test\\resources\\filestoupload\\shadabjohny.jpg";
        StringSelection strSel = new StringSelection(path);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strSel, null);
        //Create an object for robot class
        Robot robot = new Robot();
        //Control key in the keyboard
        //Ctrl+V
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(3000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(5000);

        String filename = "shadabjohny.jpg";
//        WebElement uploadedFile = driver.findElement(By.xpath("//td[text()='shadabjohny.jpg']"));
//        waitAndAssert(uploadedFile,20,filename);

        WebElement checkbox = driver.findElement(By.xpath("//span[text()='" + SourceSearch + "']//preceding-sibling::div[2]//input"));
        javaScriptHelper.clickElement(checkbox);
        Thread.sleep(5000);
        waitHelper.waitForElementVisible(By.xpath("//*[@id='screen_shot']//div//button"), 40, 5);
        WebElement addPage = driver.findElement(By.xpath("//*[@id='screen_shot']//div//button"));
        waitAndClick(addPage, 15);

        WebElement addPageSign = driver.findElement(By.xpath("//li[@ng-if='value.showHideAddtoPage']"));
        if (addPageSign.isSelected()) {
            System.out.println("added the addpage");
            System.out.println(addPageSign.isSelected());
        }
    }

    public void VerifyAddPage(String name) throws InterruptedException {
        waitAndClick(attachment, 20);
        Thread.sleep(5000);
        WebElement addPageLink = driver.findElement(By.xpath("//span[text()='" + name + "']"));
        javaScriptHelper.scrollToElemet(addPageLink);
        waitAndAssert(addPageLink, 20, name);
        waitAndClick(deletePage, 20);
        waitAndClick(deleteNoteYes, 20);
    }

    //Verify Hyperlink on company Details Section
    public void Hyperlink() throws InterruptedException {
        try {
            List<WebElement> linkElements = driver.findElements(By.xpath("//h3[text()='Company details']//following::div[2]//div[contains(@class,'company-details-wrapper ')]//div[contains(@class,'center')]//button//span[contains(@class,'text-dark-cream mar')]"));
            int linkCount = linkElements.size();
            System.out.println(linkElements.size());
            //extract the link texts of each link element
            for (WebElement e : linkElements) {
                String link = e.getText();
                System.out.println(link);
                int i = Integer.parseInt(link);
                if (i != 0) {
                    waitAndClick(e, 10);
                    Thread.sleep(1000);
                    WebElement cancel = driver.findElement(By.xpath("//button[text()='Cancel']"));
                    waitAndClick(cancel, 20);
                    Thread.sleep(1000);
                }
            }

        } catch (Exception et) {
        }
    }

    //Company information section attach the document
    public void uploadDocumentCompanyInformation(String path) throws InterruptedException, AWTException {
        waitHelper.waitForElementVisible(By.xpath("//*[@id='entity-company-content']/div[1]/div/div/div/div[2]/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/i[2]"), 40, 10);
        WebElement companyInfoAttache = driver.findElement(By.xpath("//*[@id='entity-company-content'" +
                "]/div[1]/div/div/div/div[2]/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/i[2]"));
        new Actions(driver).moveToElement(companyInfoAttache).build().perform();
        Thread.sleep(1000);
        waitAndClick(companyInfoAttache, 20);
        Thread.sleep(1000);
        waitAndClick(driver.findElement(By.xpath("(//span[@class='fa fa-upload'])[2]//parent::button")), 10);
        waitAndClick(uploadNewFile, 20);
        path = System.getProperty("user.dir") + "\\src\\test\\resources\\filestoupload\\shadabjohny.jpg";
        Thread.sleep(3000);
        dropFileHelper.systemFile(path);
        waitAndAssert(driver.findElement(By.xpath("//span[contains(@class,'clipboard-item-name ng-binding ng-scope')]")), 20, "Shadabjohny.jpg");
        waitHelper.waitForElementVisible(By.xpath("(//h5[text()='My Uploaded Document'])[2]/parent::div//ul//li[1]//i[contains(@class,'text-coral-red')]"), 40, 5);
        waitAndClick(driver.findElement(By.xpath("(//h5[text()='My Uploaded Document'])[2]/parent::div//ul//li[1]//i[contains(@class,'text-coral-red')]")), 20);
        waitAndClick(deleteNoteYes, 10);

    }

    public void uploadLargeImage(String large) throws InterruptedException, AWTException {
        waitAndClick(driver.findElement(By.xpath("//h4[contains(text(),'Company Information')]//parent::div//following::i[3][contains(@class,'fa fa-paperclip')]")), 20);
        waitAndClick(driver.findElement(By.xpath("(//span[@class='fa fa-upload'])[2]//parent::button")), 10);
        waitAndClick(uploadNewFile, 20);
        Thread.sleep(3000);
        large = System.getProperty("user.dir") + "\\src\\test\\resources\\filestoupload\\21mbfile.jpg";
        dropFileHelper.systemFile(large);
    }


    //Ownership Structure section
    public void createCustomChart() throws InterruptedException {
        new WebDriverWait(driver, 300).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[@ng-show='pageloader.treeGraphloader']")));
        WebElement custom = driver.findElement(By.xpath("//button[text()='Create Custom-Chart']"));
        System.out.println(custom.getText());
        waitAndClick(custom, 60);
        Thread.sleep(2000);

    }

    public void clickComplex() throws InterruptedException {
        try {
            waitHelper.waitForElementVisible(By.id("complex_structure_indicator"), 40, 5);
        } catch (TimeoutException e) {
            System.out.println(e);
        }
        WebElement Complex = driver.findElement(By.id("complex_structure_indicator"));
        javaScriptHelper.clickElement(Complex);
        waitAndClick(driver.findElement(By.xpath("//button[text()='OK']")), 20);
        waitAndClick(driver.findElement(By.xpath("//button[text()='OK']")), 20);
    }

    public void verifyComplexEnable() {
        Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'Complex Structure')]//following::input[contains(@class,'ng-not-empty')]")).isEnabled());
        waitAndClick(driver.findElement(By.xpath("//i[contains(@ng-click,'deleteCustomView')]")), 20);
        waitAndClick(driver.findElement(By.xpath("//button[text()='OK']")), 20);
    }
}