package pages;

import com.ws.driver.DriverScript;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends DriverScript {
    @FindBy(id="user-name") private WebElement usernameInput;
    @FindBy(id="password") private WebElement passwordInput;
    @FindBy(id="login-button") private WebElement loginButton;
    @FindBy(xpath="//h3[text()='Epic sadface: Username and password do not match any user in this service']") private WebElement incorrectCredentialsText;
    @FindBy(xpath="//h3[text()='Epic sadface: Username is required']") private WebElement usernameRequiredText;
    @FindBy(xpath="//h3[text()='Epic sadface: Password is required']") private WebElement passwordRequiredText;
    public LoginPage(){
        PageFactory.initElements(driver,this);
    }
    public void enterUsername(String username){
        usernameInput.sendKeys(username);
    }
    public void enterPassword(String password){
        passwordInput.sendKeys(password);
    }
    public void clickLoginButton(){
        loginButton.click();
    }
    public String getIncorrectCredentialsText(){
        return incorrectCredentialsText.getText();
    }
    public String getUsernameRequiredText(){
        return usernameRequiredText.getText();
    }
    public String getPasswordRequiredText(){
        return passwordRequiredText.getText();
    }

}
