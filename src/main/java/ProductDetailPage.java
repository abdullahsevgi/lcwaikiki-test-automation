import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductDetailPage extends BasePage{

    static String productDetailPrice;
    By addProductToCartLocator = By.id("pd_add_to_cart");
    By productSizeLocator = By.xpath("(//a[@key='1'])[1]");
    By productPriceLocator = By.xpath("(//span[@class='price'])[2]");

/*
    By getProductSizeCheckLocator = By.className("sizeHeight stlookSize   top spot");
    By getProductSizeListLocator = By.id("option-size");
*/

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public boolean ProductDetailPageControl() {
        return isDisplayed(addProductToCartLocator);
    }

    public void addToCart() {

        click(productSizeLocator);
        click(addProductToCartLocator);

        productDetailPrice=find(productPriceLocator).getText();
    }

}
