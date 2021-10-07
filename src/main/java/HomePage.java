import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Stack;

public class HomePage extends BasePage{

    By loginLocator = By.xpath("//span[contains(text(),'Giriş Yap')]");
    SearchBox searchBox;
    By productCountInCart = By.cssSelector("span#spanCart");

    public HomePage(WebDriver driver) {

        super(driver);
        searchBox = new SearchBox(driver);
    }

    public String homePageControl() {
       return driver.getCurrentUrl();
    }

    public void loginClick() {
        click(loginLocator);
    }

    public SearchBox searchBox() {
        return this.searchBox;
    }

    public String ProductCountControl() {

        return find(productCountInCart).getText();
    }

    public void goToCart() {
        click(productCountInCart);
    }
}
