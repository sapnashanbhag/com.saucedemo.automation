import org.jspecify.annotations.NonNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

public class ProductsPageTest extends BaseTest {
    @BeforeMethod
    public void setup(){
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
    }
    @Test(priority=1)
     public void testSortByNameAtoZ(){
        logger=report.createTest("Validate sort by name A to Z");
        productsPage.selectProductSortOption("Name (A to Z)");
        List<String> expectedlist=productsPage.getProductsList();
        Collections.sort(expectedlist);
        List<String> actualList=productsPage.getProductsList();
        Assert.assertEquals(actualList,expectedlist,"Actual and Expected List does not match");
        logger.pass("validated sort by name A to Z");
    }
    @Test(priority=2)
    public void testSortByNameZtoA(){
        logger=report.createTest("Validate sort by name Z to A");
        productsPage.selectProductSortOption("Name (Z to A)");
        List<String> expectedlist=productsPage.getProductsList();
        Collections.sort(expectedlist,Collections.reverseOrder());
        List<String> actualList=productsPage.getProductsList();
        Assert.assertEquals(actualList,expectedlist,"Actual and Expected List does not match");
        logger.pass("validated sort by name Z to A");
    }
    @Test(priority=3)
    public void testSortByPriceLowToHigh() {
        logger = report.createTest("Validate sort by price Low to High");
        productsPage.selectProductSortOption("Price (low to high)");
        List<Double> expectedlist = productsPage.getProductsPriceList();
        Collections.sort(expectedlist);
        List<Double> actualList = productsPage.getProductsPriceList();
        Assert.assertEquals(actualList, expectedlist, "Actual and Expected List does not match");
        logger.pass("validated sort by price Low to High");
    }
    @Test(priority=4)
    public void testSortByPriceHighToLow() {
        logger = report.createTest("Validate sort by price High to Low");
        productsPage.selectProductSortOption("Price (high to low)");
        List<Double> expectedlist = productsPage.getProductsPriceList();
        Collections.sort(expectedlist, Collections.reverseOrder());
        List<Double> actualList = productsPage.getProductsPriceList();
        Assert.assertEquals(actualList, expectedlist, "Actual and Expected List does not match");
        logger.pass("validated sort by price High to Low");
    }
    @Test(priority = 4)
    public void clickaproduct(){
        productsPage.clickProduct("Sauce Labs Bike Light");
    }
    @Test(priority=5)
    public void clickleftnavigationmenu(){
        productsPage.openmenubuttonclick();
        boolean flag = productsPage.isclosemenubuttondisplayed();
        Assert.assertTrue(flag,"CloseMenu Button is not displayed");
    }
    @Test(priority=6)
    public void clickallitemssidebarlink(){
        productsPage.openmenubuttonclick();
        productsPage.allitemssidebarlinkclick();
        boolean flag = productsPage.isproductsheaderdisplayed();
        Assert.assertTrue(flag,"Products header is not displayed");
    }
    @Test(priority=7)
    public void aboutsidebarlinkclick() throws InterruptedException{
        productsPage.openmenubuttonclick();
        Thread.sleep(3000);

        productsPage.clickaboutlink();
        Thread.sleep(3000);
        String expectedurl = "https://saucelabs.com/";
        String actualurl = driver.getCurrentUrl();
        Assert.assertEquals(actualurl,expectedurl,"Actual url and expected url do not match");
        driver.navigate().back();
        Assert.assertTrue(productsPage.isproductsheaderdisplayed(),"Back Navigation is not working");
    }

    @Test(priority=8)
    public void testlogoutlinkclick(){
        productsPage.openmenubuttonclick();
        productsPage.clicklogoutlink();
        String actualurl = driver.getCurrentUrl();
        Assert.assertTrue(actualurl.contains("https://www.saucedemo.com/"),"actual and expected url do not match");
    }
}