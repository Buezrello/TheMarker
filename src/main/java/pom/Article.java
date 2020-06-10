package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Article {

    private WebDriver driver;

    public Article(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//article//header//h1[@data-test='articleHeaderTitle']")
    private WebElement title;
    @FindBy(xpath = "//article//header//p[@data-test='articleHeaderSubtitle']")
    private WebElement subTitle;

}
