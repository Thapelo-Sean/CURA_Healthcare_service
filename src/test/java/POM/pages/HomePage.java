package POM.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {
    public static final Logger logger = LogManager.getLogger("Info");

    WebDriver driver;
    public HomePage(WebDriver driver)
    {
        this.driver = driver;
    }

    //locate elements using @FindBy annotation
    @FindBy(how = How.ID, using = "menu-toggle") @CacheLookup
    WebElement MenuButton;
    @FindBy(how = How.LINK_TEXT, using = "Make Appointment") @CacheLookup
    WebElement makeAppointment;

    //Method to click the appointment button
    public void menuButtonClick()
    {
        try
        {
            logger.info("Methods to perform actions on home page is executing..........");
            MenuButton.click();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void makeAppointmentClick() throws InterruptedException {
        try
        {
            makeAppointment.click();
            Thread.sleep(500);
            logger.info("<<<<<<<<<<<<Methods to perform actions on home page executed>>>>>>>>>>>>>>>");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}