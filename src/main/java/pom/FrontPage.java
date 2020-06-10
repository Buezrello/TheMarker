package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FrontPage {

    public FrontPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//button[contains(@aria-label, 'החיפוש')])[1]")
    private WebElement btnSearch;

    public void clickBtnSearch() {
        btnSearch.click();
    }
}
