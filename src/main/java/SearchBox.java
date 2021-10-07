import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchBox extends BasePage{

    By searchBoxLocator = By.xpath("//input[@id='search_input']");
    By searchButtonLocator = By.xpath("//button[contains(text(),'Ara')]");
    public SearchBox(WebDriver driver) {
        super(driver);
    }

    public void search(String string) {
        click(searchBoxLocator);
        type(searchBoxLocator, string);
        click(searchButtonLocator);
    }
}
