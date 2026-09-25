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
   /* @Test(priority=5)
    public void clickallproducts(){
        System.out.println(productsPage.productItemNames.size());

        for(int i=0;i<productsPage.productItemNames.size();i++)
        {
            productsPage.productItemNames =
                    driver.findElements(By.xpath("//div[@class='inventory_item_name ']"));

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            wait.until(ExpectedConditions.elementToBeClickable((productsPage.productItemNames.get(i))));
            productsPage.productItemNames.get(i).click();
            String expectedproductname = driver.findElement(By.xpath("//div[@class='inventory_details_name large_size']")).getText();
            System.out.println(driver.findElement(By.xpath("//div[@class='inventory_details_name large_size']")).getText());

            WebElement actualproductname = wait.until(ExpectedConditions.elementToBeClickable(productsPage.productItemNames.get(i)));
            Assert.assertEquals(actualproductname.getText(),expectedproductname,"Actual and Expected product do not match");
            driver.navigate().back();
        }
    }
    */
    @Test(priority = 4)
    public void clickaproduct(){
        productsPage.clickProduct("Sauce Labs Bike Light");
    }
}