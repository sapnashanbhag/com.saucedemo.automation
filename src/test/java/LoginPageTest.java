import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {


    @Test(priority=1)
    public void testValidLogin() {
        logger = report.createTest("Validate login");
        loginPage.enterUsername("standard_user");
        logger.pass("entered username");
        loginPage.enterPassword("secret_sauce");
        logger.pass("entered password");
        loginPage.clickLoginButton();
        logger.pass("clicked login button");
        String actualTitle = driver.getTitle();
        String expectedTitle = "Swag Labs";
        Assert.assertEquals(actualTitle, expectedTitle, "Actual and Expected Title does not match");
        logger.pass("validated user logged in");
    }

}
