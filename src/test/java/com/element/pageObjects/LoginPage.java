package com.element.pageObjects;


import com.element.utils.CucumberTestContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    @FindBy(id = "username")
    WebElement usernameTextbox;

    @FindBy(id = "password")
    WebElement passwordTextbox;

    @FindBy(id = "signIn")
    WebElement Loginbutton;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickLoginButton() {
        Loginbutton.click();
    }

    public void setUsername(String username) {
        usernameTextbox.clear();
        usernameTextbox.sendKeys(username);
    }

    public void setPassword(String password) {
        passwordTextbox.clear();
        passwordTextbox.sendKeys(password);
    }

    public void loginAdmin(CucumberTestContext cucumberTestContext) {
        String username = cucumberTestContext.getCredentialsManager().getAdminUsername();
        String password = cucumberTestContext.getCredentialsManager().getAdminPassword();
        login(username, password);
    }

    public void loginAnalyst(CucumberTestContext cucumberTestContext) {
        String username = cucumberTestContext.getCredentialsManager().getAnalystUsername();
        String password = cucumberTestContext.getCredentialsManager().getAnalystPassword();
        login(username, password);
    }

    public void login(CucumberTestContext cucumberTestContext, String uname) {
        String password = cucumberTestContext.getCredentialsManager().getGroupPermissionsPassword(uname);
        String userLogin = String.format("%s@gmail.com", uname.toLowerCase());
        login(userLogin, password);
    }

    public void login(String username, String password) {
        setUsername(username);
        setPassword(password);
        Loginbutton.click();
    }


}
