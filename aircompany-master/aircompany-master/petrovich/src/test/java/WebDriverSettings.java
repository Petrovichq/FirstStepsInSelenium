import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class WebDriverSettings {
    public WebDriver driver;

    @BeforeTest
    public void WebSettings() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://onliner.by/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    @AfterTest
    void closeBrowser()
    {
        driver.quit();
    }
}
