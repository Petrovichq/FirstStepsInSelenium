package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObject.MainPage;
import pageObject.LoginPage;

public class MainPageSteps extends BaseSteps {

    private MainPage mainPage;


    public MainPageSteps(MainPage mainPage, WebDriver driver) {
        super(driver);
        this.mainPage = mainPage;
    }

    public LoginSteps openLoginPage() {
        mainPage.OpenInsertForm();
        return new LoginSteps(PageFactory.initElements(driver, LoginPage.class), driver);
    }

}
