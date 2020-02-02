package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class MainPage extends BasePage {

    public static final int TIME = 10;
    private WebDriver driver;

    @FindBy(css = ".auth-bar__item--text")
    private WebElement insert;
    @FindBy(css = ".fast-search__input")
    private WebElement fastSearchBar;
    @FindBy(css = ".modal-iframe")
    private WebElement newFrame;
    @FindBy(css = ".search__input")
    private WebElement searchBar;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void OpenInsertForm() {
        insert.click();
    }

    public void Search(String searchItem) {
        try {
            fastSearchBar.sendKeys(searchItem);
        } catch (ElementNotInteractableException e) {
            driver.findElement(By.cssSelector(".button-style_primary")).click();
            fastSearchBar.sendKeys(searchItem);
        }
        driver.switchTo().frame(newFrame);
        searchBar.clear();
        searchBar.sendKeys(searchItem);
        driver.manage().timeouts().implicitlyWait(TIME, TimeUnit.SECONDS);
    }


}
