import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    By LoginPageLocator = By.className("header-icon-label");


    By mailLocator = By.id("LoginEmail");
    By passwordLocator = By.id("Password");
    By loginButtonLocator = By.id("loginLink");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(){

        type(mailLocator,"testautomationtr@gmail.com");
        type(passwordLocator,"Test123456.");
        click(loginButtonLocator);

    }

    public String LoginPageControl() {
        return find(LoginPageLocator).getText();
    }

}
