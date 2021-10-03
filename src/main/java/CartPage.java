import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage{

    By cartPriceLocator = By.cssSelector("span[class='rd-cart-item-price mb-15']");
    By countUpLocator = By.cssSelector("a[class='oq-up plus']");
    By CartCountControl = By.cssSelector("input[class='item-quantity-input ignored']");
    By cartEmptyLocator = By.cssSelector("a[title='Sil']");
    By cartEmptyVerifyLocator = By.cssSelector("a[class='inverted-modal-button sc-delete ins-init-condition-tracking']");
    By goShippingLocator = By.cssSelector("a[class='homepage-link mt-20']");
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String cartPriceLocator(){
        return find(cartPriceLocator).getText();
    }

    public void countUpProduct() {
        click(countUpLocator);
    }

    public String CartCountControl() {
        return find(CartCountControl).getAttribute("value");
    }

    public void emptyToCart() throws InterruptedException {
        Thread.sleep(2000);
        click(cartEmptyLocator);
        Thread.sleep(2000);
        click(cartEmptyVerifyLocator);
    }

    public boolean CartIsEmpty() {
        return find(goShippingLocator).isDisplayed();
    }
}
