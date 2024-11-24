package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.AllureUtils;

public class GooglePage extends BasePage {

    public GooglePage(WebDriver driver) {
        super(driver);
    }

    @Step("Opening Google")
    public GooglePage openPage() {
        String URL = "http://google.com";
        driver.get(URL);
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    @Step("Input {keyword} into search window")
    public GooglePage inputKeyWord(String keyword) {
        By searchInput = By.name("q");
        findElement(searchInput).sendKeys(keyword);
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    @Step("Click to search button")
    public GooglePage search() {
        findElement(By.name("btnK")).click();
        AllureUtils.takeScreenshot(driver);
        return this;
    }
}
