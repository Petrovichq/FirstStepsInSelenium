import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GoTo{
    private WebDriver driver;
    private List<WebElement> middleRowLinks;

//    middleRowLinks = driver.findElements(By.cssSelector(".project-navigation__sign"));

    public GoTo(WebDriver driver) {
        this.driver = driver;
    }

    boolean atPage(){
        return driver.getTitle().equals("Onliner");
    }

    enum highRow {CATALOG,NEWS,AUTO,HOUSES,SERVICES,FLEA_MARKET,FORUM}

    void goToSection(highRow h){
        List<WebElement> highRowButtons = driver.findElements(By.cssSelector("b-main-navigation__text"));
        switch (h){
            case CATALOG: highRowButtons.get(0).click();
                break;
            case NEWS: highRowButtons.get(1).click();
                break;
            case AUTO: highRowButtons.get(2).click();
                break;
            case HOUSES: highRowButtons.get(3).click();
                break;
            case SERVICES: highRowButtons.get(4).click();
                break;
            case FLEA_MARKET: highRowButtons.get(5).click();
                break;
            case FORUM: highRowButtons.get(6).click();
                break;
        }
    }

    void goToProjectNavigation(int number){ middleRowLinks.get(number - 1); }

    private int projectNavigationSize(){ return middleRowLinks.size(); }

    List<WebElement> bMainNavigationDropdownTitle = driver.findElements(By.cssSelector(".b-main-navigation__dropdown-title"));
//    bMainNavigationDropdownTitle
//    b-main-navigation__dropdown-news-link
//    b-main-navigation__dropdown-advert-sign
//    b-main-navigation__dropdown-advert-item
//    b-main-navigation__dropdown-button
//    b-teasers-2__teaser
}
