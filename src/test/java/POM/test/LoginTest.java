package POM.test;

import POM.pages.AppointmentPage;
import POM.pages.HomePage;
import POM.pages.LoginPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;

public class LoginTest extends TestBase {
    public static ExtentReports extent;
    public static ExtentSparkReporter spark;
    public static ExtentTest test;
    private Logger logger = LogManager.getLogger("Info");
    @BeforeTest
    public void report()
    {
        extent = new ExtentReports();
        spark = new ExtentSparkReporter("./Reports/spark.html");
        extent.attachReporter(spark);
    }

    @Test
    public void init()
    {
        try
        {
            logger.info("<<<<<<<<<<<<<<<<<<<Executing Test>>>>>>>>>>>>>>>>>>>>>>>>>");

            //Object of the HomePage
            HomePage homePage = PageFactory.initElements(driver, HomePage.class);
            homePage.menuButtonClick();
            homePage.makeAppointmentClick();
            test = extent.createTest("Verification of Home page").assignAuthor("Thapelo Matji")
                    .log(Status.PASS,"Navigated to the home page and performed actions");

            //Object of the LoginPage
            LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
            Thread.sleep(500);
            loginPage.setUsername("John Doe");
            Thread.sleep(500);
            loginPage.setPassword("ThisIsNotAPassword");
            Thread.sleep(500);
            loginPage.loginButton();
            test = extent.createTest("Verification of login page")
                    .log(Status.PASS,"Navigated to the Login page and performed actions");

            //Object of the Make appointment page
            AppointmentPage appointmentPage = PageFactory.initElements(driver, AppointmentPage.class);
            Thread.sleep(500);
            appointmentPage.facilityDropDownButton();
            Thread.sleep(500);
            appointmentPage.reAdmissionCheckBoxButton();
            Thread.sleep(500);
            appointmentPage.healthcareRadioButton();
            Thread.sleep(500);
            appointmentPage.setVisitDate("23/10/2023");
            Thread.sleep(500);
            appointmentPage.commentTextField("This is a comment text field...");
            Thread.sleep(500);
            appointmentPage.bookAppointmentButton();
            Thread.sleep(500);

            //Capture screenshot after making an Appointment
            TakesScreenshot screenshot = (TakesScreenshot)driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("./Screenshots/TestScreenshot.png"));
            logger.info("Screenshot captured.........");

            appointmentPage.goToHomePageButtonClick();
            Thread.sleep(500);
            test = extent.createTest("Verification of Appointment page")
                    .log(Status.PASS,"Navigated to the Appointment page and performed actions");
            extent.flush();

        } catch (InterruptedException e)
        {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}