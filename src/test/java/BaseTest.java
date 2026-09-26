import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.ws.driver.DriverScript;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.ProductsPage;
import utils.HelperUtil;

import java.io.IOException;

public class BaseTest extends DriverScript {
    LoginPage loginPage;
    ProductsPage productsPage;
    ProductDetailsPage productDetailsPage;
    public static ExtentReports report;
    public static ExtentTest logger;

    @BeforeSuite
    public void SetupReport(){
        ExtentHtmlReporter extent = new ExtentHtmlReporter("" + "F:/SeleniumTraining/seleniumworkspace/com.saucedemo.automation/src/test/resources/testreports/autoreport.html");
        report = new ExtentReports();
        report.attachReporter(extent);
    }


    @BeforeMethod
    public void setUp() {
        InitApplication();
        loginPage = new LoginPage();
        productsPage = new ProductsPage();
        productDetailsPage = new ProductDetailsPage();
    }
    @AfterMethod
    public void tearDown(ITestResult result) throws InterruptedException{
        if(result.getStatus()==ITestResult.FAILURE)
        {
            try {
                logger.fail("Validation failed",
                        MediaEntityBuilder.createScreenCaptureFromPath(HelperUtil.captureScreenshots(driver)).build());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        Thread.sleep(3000);
        report.flush();
        quitDriver();
    }
}
