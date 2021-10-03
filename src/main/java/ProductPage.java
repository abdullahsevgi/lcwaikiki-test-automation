import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductPage extends BasePage{

    By seeMoreButtonLocator = By.className("lazy-load-text");
    By productPageLocator = By.id("filter-label");
    By productNameLocator = By.cssSelector("a[class='a_model_item']");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void daha_fazla_gor() {
        click(seeMoreButtonLocator);
    }

    public boolean ProductPageControl() {
        return isDisplayed(productPageLocator);
    }

    public void productSelect(int i) {
        allProducts().get(i).click();
    }

    private List<WebElement> allProducts(){
        return findAll(productNameLocator);
    }

    public int productListSize = allProducts().size();
}
