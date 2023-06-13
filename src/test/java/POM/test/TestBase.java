package POM.test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import java.util.concurrent.TimeUnit;

public class TestBase {
    static WebDriver driver = null;
    public  String baseUrl = "https://katalon-demo-cura.herokuapp.com/";
    public static ExtentReports extent;
    public static ExtentSparkReporter spark;

    @BeforeTest
    public void report1()
    {
        extent = new ExtentReports();
        spark = new ExtentSparkReporter("./Reports/MyReport.html");
        extent.attachReporter(spark);
    }

    @BeforeSuite
    public void initialization()
    {
        try
        {
            System.out.println("Initialization started...");
            WebDriverManager.chromedriver().setup();
            //WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get(baseUrl);
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            String actualUrl = driver.getCurrentUrl();
            String expectedUrl = "https://katalon-demo-cura.herokuapp.com/";
            Assert.assertEquals(actualUrl, expectedUrl);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @AfterSuite
    public void tearDown()
    {
        System.out.println("Test Completed");
        driver.quit();
    }
}