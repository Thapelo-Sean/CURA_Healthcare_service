package POM.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

    private static final Logger logger = LogManager.getLogger("Info");

    WebDriver driver;
    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }

    //Locate elements using the @FindBy annotation
    @FindBy(how = How.ID, using = "txt-username") @CacheLookup
    WebElement username;
    @FindBy(how = How.ID, using = "txt-password") @CacheLookup
    WebElement password;
    @FindBy(how = How.ID, using = "btn-login") @CacheLookup
    WebElement loginButton;

    //Method to set Username
    public void setUsername (String stringUsername) throws InterruptedException {
        try
        {
            logger.info("Methods to perform actions on the Login page is executing...........");
            username.clear();
            username.sendKeys(stringUsername);
            logger.info("Valid username entered.");
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    //Method to set Password
    public void setPassword (String stringPassword) throws InterruptedException {
        try
        {
            password.clear();
            password.sendKeys(stringPassword);
            logger.info("Valid password entered");
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //Method to click on log in button
    public void loginButton()
    {
        try
        {
            loginButton.click();
            logger.info("<<<<<<<<<<<<<Methods performed on Login page executed>>>>>>>>>>>>");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}