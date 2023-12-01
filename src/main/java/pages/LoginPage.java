package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.MethodHandles;

public class LoginPage extends MethodHandles {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final By usernameField= By.id("Email");
    private final By passwordField = By.id("Password");

    private final By loginButton =By.cssSelector("button.button-1.login-button");

    private void insertUsername(String username){
        sendKeys(usernameField,username);
    }
    private void insertPassword(String password){
        sendKeys(passwordField,password);
    }
    private void clickOnLoginButton(){
        click(loginButton);
    }
    public void loginFeature(String username,String password){
        insertUsername(username);
        insertPassword(password);
        clickOnLoginButton();

    }
}
