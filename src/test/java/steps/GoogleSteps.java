package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.GooglePage;

public class GoogleSteps {
    private GooglePage page;

    public GoogleSteps(WebDriver driver) {
        page = new GooglePage(driver);
    }
    
    @Step("Searching for '{keyword}' in Google")
    public GoogleSteps searchForKeyWord(String keyword) {
        page
                .openPage()
                .inputKeyWord(keyword)
                .search();
        return this;
    }
}
