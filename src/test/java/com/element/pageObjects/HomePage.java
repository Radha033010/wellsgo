package com.element.pageObjects;

        import com.element.helper.WaitHelper;
        import org.openqa.selenium.By;
        import org.openqa.selenium.NoSuchElementException;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.FindBy;

        import static org.testng.Assert.assertEquals;

public class HomePage extends BasePage {
    public WebDriver driver;
    @FindBy(xpath = "//*[contains(@class,'insurance-risk-tile')]")
    WebElement Risk;

    @FindBy(xpath = "//span[text()='Hey Admin User,']")
    WebElement AdminWelcome;

    @FindBy(xpath = "//span[text()='Hey Analyst User,']")
    WebElement analystWelcome;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void riskOption() {
        waitAndClick(Risk, 10);
    }

    public void adminUser(String adminUser) {
        waitAndAssert(AdminWelcome, 30, adminUser);
    }

    public void analystUser(String analystUser) {
        waitAndAssert(analystWelcome, 30, analystUser);
    }
}