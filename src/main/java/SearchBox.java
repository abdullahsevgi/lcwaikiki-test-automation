import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchBox extends BasePage{

    By searchBoxLocator = By.id("search");
    By searchButtonLocator = By.className("search-button");
    public SearchBox(WebDriver driver) {
        super(driver);
    }

    public void search(String string) {

        type(searchBoxLocator, string);
        click(searchButtonLocator);
    }
}
