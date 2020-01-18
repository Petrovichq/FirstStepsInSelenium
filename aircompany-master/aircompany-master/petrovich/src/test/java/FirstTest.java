import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FirstTest {
    private  WebDriver driver;

    @Test
    void test1() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://onliner.by/");

        findItem("Пылесос");
        addItemNumber(1);
        findItem("Пылесосы");
        addItemNumber(2);
        driver.get("https://cart.onliner.by/");
        List<WebElement> items = driver.findElements(By.cssSelector(".cart-form__offers-item_secondary"));
        System.out.println("Колличество покупок равно: " + items.size());
    }
    private void findItem(String item){
        try {
            driver.findElement(By.cssSelector(".fast-search__input")).sendKeys(item);
        }catch (ElementNotInteractableException e){
            driver.findElement(By.cssSelector(".button-style_primary")).click();
            driver.findElement(By.className("fast-search__input")).sendKeys(item);
        }
        driver.switchTo().frame(driver.findElement(By.cssSelector(".modal-iframe")));
        WebElement searchBox = driver.findElement(By.cssSelector(".search__input"));
        searchBox.clear();
        searchBox.sendKeys(item);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

    }
    private void addItemNumber(int number){
        List<WebElement> searchList = driver.findElements(By.className("product__title"));
        searchList.get(number - 1).click();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.findElement(By.cssSelector(".button_big")).click();
        driver.findElement(By.cssSelector(".offers-list__button_basket")).click();
    }
    @AfterTest
    void closeBrowser()
    {
        driver.quit();
    }
}
