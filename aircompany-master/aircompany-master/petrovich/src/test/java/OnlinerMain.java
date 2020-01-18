import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OnlinerMain {
    private By userNameLocator = By.xpath("//*[@id=\"auth-container\"]/div/div[2]/div/form/div[1]/div/div[2]/div/div/div/div/input");
    private By passwordLocator = By.xpath("//*[@id=\"auth-container\"]/div/div[2]/div/form/div[2]/div/div/div/div/input");

    private final WebDriver driver;
    private  String pageTitle ="OnlinerMain";

    OnlinerMain(WebDriver driver) {
        this.driver = driver;
    }
    void open(String url){
        driver.get(url);
    }
    boolean atPage(){
        return driver.getTitle().equals(pageTitle);
    }
    void defaultInsert(String login, String password){
        driver.findElement(By.cssSelector(".auth-bar__item--text")).click();
        driver.findElement(userNameLocator).sendKeys(login);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(By.cssSelector(".auth-form__button_width_full")).click();
    }
    void facebookInsert(){driver.findElement(By.cssSelector(".auth-bar__item--fb")).click();}
    void vkInsert(){driver.findElement(By.cssSelector(".auth-bar__item--vk")).click();}
    void googleInsert(){driver.findElement(By.cssSelector(".auth-bar__item--gg")).click();}
}
