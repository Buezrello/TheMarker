package pom;

import constants.PathConstants;
import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FoundResult {

    private WebDriver driver;

    public FoundResult(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//section//article")
    private List<WebElement> articles;

    public int amountArticles() {
        Waits.fluentWaitElementClickable(driver, articles.get(0), 3);
        return articles.size();
    }

    public void clickArticle(int index) throws IllegalAccessException {
        if (index<0 || index>=articles.size())
            throw new IllegalAccessException(String.format("Article index %d incorrect, must be from 0 to %d",
                    index, articles.size()-1));

        Waits.fluentWaitElementClickable(driver, articles.get(index), 3);

        articles.get(index).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        Waits.fluentWaitElementClickable(driver, driver.findElement(PathConstants.buttonMasthead), 3);

    }
}
