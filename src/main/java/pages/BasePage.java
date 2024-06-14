package pages;

import basetest.BaseTest;
import helpers.HelperFile;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.logging.Logger;


public class BasePage {
    protected WebDriver driver;
    private WebDriverWait wait;
    private static final int TIMEWAIT = 30;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEWAIT));
    }

    public void isElementPresent(By locator, String nameElement) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (Exception err) {
            BaseTest.getInstance().createStep("El sistema no muestra en pantalla el elemento: " + nameElement, false, true);
            Assert.fail();
        }
    }

    public void clickElement(By locator, String nameElement) {
        try {
            isElementPresent(locator, nameElement);
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            driver.findElement(locator).click();
        } catch (Exception err) {
            BaseTest.getInstance().createStep("Error al hacer click en el elemento: " + nameElement, false, true);
            Assert.fail();
        }
    }

    public void writeField(By locator, String value, String nameElement) {
        try {
            isElementPresent(locator, nameElement);
            driver.findElement(locator).sendKeys(value);
        } catch (Exception err) {
            BaseTest.getInstance().createStep("Error al escribir el valor: " + value + " en el elemento: " + nameElement, false, true);
            Assert.fail();
        }
    }

    public void isElementVisible(By locator, String nameElement) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception err) {
            BaseTest.getInstance().createStep("El sistema no muestra en pantalla el elemento: " + nameElement, false, true);
            Assert.fail();
        }
    }

    public void isNotElementVisible(By locator, String nameElement) {
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        } catch (Exception err) {
            BaseTest.getInstance().createStep("El sistema muestra en pantalla el elemento: " + nameElement, false, true);
            Assert.fail();
        }
    }

    public void go(String url) {
        driver.get(url);
    }

    private void jsExecuter(String script, By locator) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript(script, driver.findElement(locator));
        } catch (Exception err) {
            BaseTest.getInstance().createStep("Error al ejecutar el script " + script + " " + err.getMessage(), false, true);
            Assert.fail();
        }
    }

    public void clickExecuterJS(By locator, String nameElement) {
        try {
            isElementPresent(locator, nameElement);
            jsExecuter("arguments[0].click();", locator);
        } catch (Exception err) {
            BaseTest.getInstance().createStep("Error al hacer click en el elemento: " + nameElement, false, true);
            Assert.fail();
        }
    }

    public void confirmIsValueAEqualsValueB(String valueA, String valueB) {
        if (!valueA.equals(valueB)) {
            BaseTest.getInstance().createStep("Los valores ingresados no son iguales " + valueA + " ," + valueB, false, true);
            Assert.fail();
        }
    }

    public void confirmIsValueAEqualsValueB(int valueA, int valueB) {
        if (valueA != valueB) {
            BaseTest.getInstance().createStep("Los valores ingresados no son iguales " + valueA + " ," + valueB, false, true);
            Assert.fail();
        }
    }

    public void waitDownloadFile(String path, String nameFile) {
        try {
            wait.until((ExpectedCondition<Boolean>) isDownload -> HelperFile.getInstance().isExitFile(path, nameFile));

        } catch (Exception err) {
            BaseTest.getInstance().createStep("El archivo: " + nameFile + " no se encuentra en el path: " + path, false, true);
            Assert.fail();
        }
    }

    public void scrollToElement(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        } catch (Exception e) {
            BaseTest.getInstance().createStep("Error al hacer scroll element", false, true);
            Assert.fail();
        }
    }

    public void upLoadImagenDoc(String ruta, By locator, String nameElement) {
        try {
            BaseTest.getDriver().findElement(locator).sendKeys(ruta);
        } catch (Exception err) {
            BaseTest.getInstance().createStep("Error al cargar documento " + ruta + " " + nameElement, false, true);
            Assert.fail();
        }
    }

    public void selectOption(By locator, String value) {
        try {
            Select select = new Select(BaseTest.getDriver().findElement(locator));
            select.selectByValue(value);
        } catch (Exception e) {
            BaseTest.getInstance().createStep("Error al seleccionar el valor:" + value + " " + e.getMessage(), false, true);
            Assert.fail();
        }
    }


}
