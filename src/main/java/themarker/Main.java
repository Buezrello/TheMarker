package themarker;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import pom.FoundResult;
import pom.FrontPage;
import pom.SearchPage;

import static constants.HebrewEnglishConstants.GLOBS;
import static constants.HebrewEnglishConstants.URL_MARKER;

public class Main {

    public static void main(String[] args) throws IllegalAccessException {

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get(URL_MARKER);
        driver.manage().window().maximize();

        FrontPage frontPage = new FrontPage(driver);

        frontPage.clickBtnSearch();

        SearchPage searchPage = new SearchPage(driver);

        searchPage.searchText(GLOBS);

        FoundResult foundResult = new FoundResult(driver);
        int numberOfArticles = foundResult.amountArticles();

        for (int i=0; i<numberOfArticles; ++i) {
            foundResult.clickArticle(i);
            driver.navigate().back();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            foundResult = new FoundResult(driver);
        }

        /////

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        if(driver != null) {
            driver.quit();
        }
    }
}
