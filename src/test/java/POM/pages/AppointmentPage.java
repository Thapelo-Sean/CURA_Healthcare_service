package POM.pages;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import static POM.test.TestBase.extent;

public class AppointmentPage {
    private Logger logger = LogManager.getLogger("Info");

    @BeforeTest
    public void report1()
    {
        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("./Reports/Appointment.html");
        extent.attachReporter(spark);
    }

    WebDriver driver;
    public AppointmentPage(WebDriver driver)
    {
        this.driver = driver;
    }

    //locate elements using the @FindBy annotation
    @FindBy(how = How.ID, using = "chk_hospotal_readmission") @CacheLookup
    WebElement reAdmissionCheckBoxButton;
    @FindBy(how = How.ID, using = "radio_program_medicaid") @CacheLookup
    WebElement healthcareRadioButton;
    @FindBy(how = How.ID, using = "txt_visit_date") @CacheLookup
    WebElement visitDate;
    @FindBy(how = How.ID, using = "txt_comment") @CacheLookup
    WebElement commentTextField;
    @FindBy(how = How.ID, using = "btn-book-appointment") @CacheLookup
    WebElement bookAppointmentButton;
    @FindBy(how = How.LINK_TEXT, using = "Go to Homepage") @CacheLookup
    WebElement goToHomePageButton;

    public void facilityDropDownButton() throws InterruptedException
    {
        try
        {
            logger.info("Methods to perform actions on my Appointment page is executing.......");
            Select select = new Select(driver.findElement(By.name("facility")));
            select.selectByValue("Hongkong CURA Healthcare Center");
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void reAdmissionCheckBoxButton() throws InterruptedException
    {
        try
        {
            reAdmissionCheckBoxButton.click();
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void healthcareRadioButton() throws InterruptedException
    {
        try
        {
            healthcareRadioButton.click();
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setVisitDate (String stringVisitDate) throws InterruptedException
    {
        visitDate.sendKeys(stringVisitDate);
        Thread.sleep(500);
    }

    public void commentTextField (String stringCommentTextField) throws InterruptedException
    {
        try
        {
            commentTextField.sendKeys(stringCommentTextField);
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void bookAppointmentButton() throws InterruptedException
    {
        try
        {
            bookAppointmentButton.click();
            extent.createTest("Book Appointment Test")
                    .log(Status.PASS, "Appointment booked")
                    .assignAuthor("Thapelo Matji")
                    .addScreenCaptureFromPath("./Reports/Appointment.png");
            extent.flush();
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void goToHomePageButtonClick() throws InterruptedException
    {
        try
        {
            goToHomePageButton.click();
            Thread.sleep(500);
            logger.info("<<<<<<<<<<<Methods performed on the appointment page executed>>>>>>>>>>>");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}