package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

class BasePage {

    WebDriver driver;
    
    BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement findElement(By locator) {
        try {
            return driver.findElement(locator);
        } catch (NoSuchElementException ex) {
            Assert.fail("Элемент не найден по локатору " + locator);
        }
        return null;
    }
}
