package tests.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import steps.GoogleSteps;
import utils.AllureUtils;

import static utils.AllureUtils.takeScreenshot;

@Listeners(TestListener.class)
public class BaseTest {
    
    public WebDriver driver;
    protected GoogleSteps steps;
    
    @BeforeMethod(description = "Opening Browser")
    public void createDriver(ITestContext context) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-extensions");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--headless");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        steps = new GoogleSteps(driver);
        context.setAttribute("driver", driver);
    }

    @AfterMethod(alwaysRun = true, description = "Closing Browser")
    public void closeDriver(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE && driver != null) {
            takeScreenshot(driver);
        }
        if (driver != null) {
            driver.quit();
        }
    }
}
