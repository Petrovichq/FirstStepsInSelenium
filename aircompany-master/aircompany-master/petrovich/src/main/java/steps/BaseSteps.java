package steps;

import org.openqa.selenium.WebDriver;

public class BaseSteps {
    public WebDriver driver;

    public BaseSteps(WebDriver driver) {
        this.driver = driver;
    }

}
