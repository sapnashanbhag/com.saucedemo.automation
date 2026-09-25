package pages;

import com.ws.driver.DriverScript;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage extends DriverScript {
    @FindBy(xpath="//div[@class='inventory_details_name large_size']") private WebElement inventorytext;
    @FindBy(id="back-to-products") private WebElement backtoproductsbutton;
    public ProductDetailsPage(){
        PageFactory.initElements(driver,this);
    }
    public void clickbackbutton(){
        backtoproductsbutton.click();
    }
    public String getProductName(){
        return inventorytext.getText();
    }
}
