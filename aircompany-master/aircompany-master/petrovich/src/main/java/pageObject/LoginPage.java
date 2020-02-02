package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class LoginPage extends BasePage {
    private WebDriver driver;
    private String originalWindowDescription;

    @FindBy(css = ".auth-button_primary")
    private WebElement insertButton;
    @FindBy(css = "[placeholder=\"Ник или e-mail\"]")
    private WebElement userNameLocator;
    @FindBy(css = "[type=\"password\"]")
    private WebElement passwordLocator;
    @FindBy(css = "[href=\"https://profile.onliner.by/registration\"]")
    private WebElement registrationLocator;
    @FindBy(css = "[href=\"https://profile.onliner.by/recover-password\"]")
    private WebElement forgetLocator;
    @FindBy(css = ".auth-form__description_error")
    private WebElement insertErrorMessage;
    @FindBy(css = ".auth-form__title_condensed-default")
    private WebElement formTitleMessage;
    @FindBy(css = ".auth-form__button_fb")
    private WebElement fbLocator;
    @FindBy(css = ".auth-form__button_vk")
    private WebElement vkLocator;
    @FindBy(css = ".auth-form__button_gg")
    private WebElement googleLocator;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        originalWindowDescription = driver.getWindowHandle();
    }

    public void clickInsertButton() {
        insertButton.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public String errorMessage() {
        return insertErrorMessage.getText();
    }

    public void insertName(String name) {
        userNameLocator.sendKeys(name);
    }

    public void insertPassword(String password) {
        passwordLocator.sendKeys(password);
    }

    public void clickForgetPassword() {
        forgetLocator.click();
    }

    public String FormTitle() {
        return formTitleMessage.getText();
    }

    public void registration() {
        registrationLocator.click();
    }

    public void facebookInsert() {
        fbLocator.click();
    }

    public void vkInsert() {
        vkLocator.click();
    }

    public void googleInsert() {
        googleLocator.click();
    }

    public String SuccessInsertPageTitle() {
        Set<String> newWindowDescriptors = driver.getWindowHandles();
        newWindowDescriptors.remove(originalWindowDescription);
        String newWindowDescriptor = newWindowDescriptors.iterator().next();
        driver.switchTo().window(newWindowDescriptor);
        return driver.getTitle();
    }
}
