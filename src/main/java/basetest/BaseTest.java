package basetest;

import browsertype.BrowserType;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import report.ExtentManager;

public class BaseTest {

    private static WebDriver driver;
    private static BaseTest instance = null;

    public static BaseTest getInstance() {
        if (instance == null) {
            instance = new BaseTest();
        }
        return instance;
    }

    @Parameters("browserName")
    @BeforeMethod
    public void beforeMethod(String browserName, ITestResult result) {
        setupDriver(BrowserType.valueOf(browserName));
        ExtentManager.getInstance().createTest(result.getTestClass().getXmlTest().getName(),result.getMethod().getDescription());
    }

    @AfterMethod
    public void afterMethod() {
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterClass
    public void afterClass() {
        ExtentManager.getInstance().saveReport();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public void createStep(String comment, boolean statusSteps, boolean screenShots) {
        ExtentManager.getInstance().createStep(comment, statusSteps, screenShots);
    }

    private static void getBrowser(BrowserType browserType) {

        switch (browserType) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case EDGE:
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                driver = null;
        }
    }

    private void setupDriver(BrowserType browserType) {
        getBrowser(browserType);
        driver.manage().window().maximize();
    }


}
