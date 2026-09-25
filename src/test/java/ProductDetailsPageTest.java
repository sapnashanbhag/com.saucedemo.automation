import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductDetailsPageTest extends BaseTest {
    /*
    @BeforeMethod

    public void setUp(){
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
    }*/
    @Test(priority=1)
    public void testClickaProduct(){
        logger = report.createTest("Test Click a Product");
        loginPage.enterUsername("standard_user");
        logger.pass("entered username");
        loginPage.enterPassword("secret_sauce");
        logger.pass("entered Password");
        loginPage.clickLoginButton();
        logger.pass("logged in successfully");
        String expectedproductname = "Sauce Labs Bike Light";
        productsPage.clickProduct(expectedproductname);
        logger.pass("clicked the product"+expectedproductname);
        String actualproductname=productDetailsPage.getProductName();
        Assert.assertEquals(actualproductname,expectedproductname,"Product names do not match");
        logger.pass("Product Names in products page and product details page match");
        productDetailsPage.clickbackbutton();
        logger.pass("clicked back button successfully");
    }
}
