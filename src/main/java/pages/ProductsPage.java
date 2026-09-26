package pages;

import com.ws.driver.DriverScript;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ProductsPage extends DriverScript {
    @FindBy(xpath="//select[@class='product_sort_container']")
    private WebElement productSortDropdown;
    @FindBy(xpath="//div[@class='inventory_item_name ']")
    public List<WebElement> productItemNames;
    @FindBy(xpath="//div[@class='inventory_item_price']")
    private List<WebElement> productPricesText;
    @FindBy(xpath="(//div[@class='inventory_item_name '])[1]")
    private WebElement saucelabsbackpackitem;
    @FindBy(id="react-burger-menu-btn")
    private WebElement openmenubutton;
    @FindBy(id="inventory_sidebar_link")
    private WebElement allitemssidebarlink;
    @FindBy(id="dynamic_catalog_sidebar_link")
    private WebElement dynamiccataloglink;
    @FindBy(id="about_sidebar_link")
    private WebElement aboutsidebarlink;
    @FindBy(id="logout_sidebar_link")
    private WebElement logoutsidebarlink;
    @FindBy(id="reset_sidebar_link")
    private WebElement resetsidebarlink;
    @FindBy(id="react-burger-cross-btn")
    private WebElement closemenubutton;
    @FindBy(xpath="//span[text()='Products']")
    private WebElement productsheader;

    public ProductsPage(){
        PageFactory.initElements(driver,this);
    }
    public void openmenubuttonclick(){
        openmenubutton.click();
        allitemssidebarlink.isDisplayed();
        dynamiccataloglink.isDisplayed();
        aboutsidebarlink.isDisplayed();
        logoutsidebarlink.isDisplayed();
        resetsidebarlink.isDisplayed();
    }
    public boolean isclosemenubuttondisplayed(){
        return closemenubutton.isDisplayed();
    }
    public void allitemssidebarlinkclick(){
        allitemssidebarlink.click();

    }
    public boolean isproductsheaderdisplayed(){
        return productsheader.isDisplayed();
    }
    public void clickaboutlink(){
        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement aboutLink = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("about_sidebar_link"))
        );
        wait.until(
                ExpectedConditions.elementToBeClickable(By.id("about_sidebar_link"))
        );
        actions.moveToElement(aboutLink).click().perform();

    }
    public void clicklogoutlink(){
        Actions actions = new Actions(driver);
        actions.moveToElement(logoutsidebarlink).click().perform();
    }
    public void selectProductSortOption(String option){
        //productSortDropdown.sendKeys(option);
        Select selObject = new Select(productSortDropdown);
        selObject.selectByVisibleText(option);
    }
    public List<String> getProductsList(){
        List<String> actualList = new ArrayList<>();
        for(WebElement productName:productItemNames){
            actualList.add(productName.getText());
        }
        return actualList;
    }
    public List<Double> getProductsPriceList(){
        List<Double> actualPriceList = new ArrayList<>();
        for(WebElement priceText:productPricesText){
            String priceString = priceText.getText().replace("$", "");
            actualPriceList.add(Double.parseDouble(priceString));
        }
        return actualPriceList;
    }
    public void clickProduct(String productname){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement product= wait.until(
                ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@class='inventory_item_name ' and text()='" + productname + "']"))));
        product.click();
    }
}
