package report;

import basetest.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


import org.apache.commons.io.IOUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.FileInputStream;
import java.util.Base64;
import java.util.logging.Logger;

public class ExtentManager {

    private static ExtentReports extentReports;
    private static ExtentManager instance = null;
    private ExtentTest extentTest;
    private ExtentTest nodeTest;
    private String previousScenarioName = "";

    private Logger logger;

    public static ExtentManager getInstance() {
        if (instance == null) {
            instance = new ExtentManager();
        }
        return instance;
    }

    private static synchronized ExtentReports getExtentReports() {

        if (extentReports == null) {
            String workingDir = System.getProperty("user.dir");
            ExtentSparkReporter htmlReport = new ExtentSparkReporter(workingDir + "\\reports\\ExtentReport.html");
            htmlReport.config().setDocumentTitle("Test-Automation");
            htmlReport.config().setReportName("Regresion");
            htmlReport.config().setTheme(Theme.STANDARD);
            extentReports = new ExtentReports();
            extentReports.attachReporter(htmlReport);
            extentReports.setSystemInfo("Environment", "Test");
            extentReports.setReportUsesManualConfiguration(true);
        }

        return extentReports;
    }

    public void createStep(String comment, boolean statusSteps, boolean screenShots) {

        if (statusSteps && !screenShots) {
            nodeTest.log(Status.PASS, comment);
        } else if (!statusSteps && !screenShots) {
            nodeTest.log(Status.FAIL, comment);
        } else if (statusSteps) {
            nodeTest.log(Status.PASS, comment, MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenShot()).build());
        } else {
            nodeTest.log(Status.FAIL, comment, MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenShot()).build());
        }

    }

    public void saveReport() {
        getExtentReports().flush();
    }

    public void createTest(String scenarioName, String testName) {

        if (!previousScenarioName.equals(scenarioName)) {
            extentTest = getExtentReports().createTest(scenarioName);
        }
        previousScenarioName = scenarioName;
        nodeTest = extentTest.createNode(testName);

    }

    private String takeScreenShot() {
        String destination = "";
        try {
            File capture = ((TakesScreenshot) BaseTest.getDriver()).getScreenshotAs(OutputType.FILE);
            byte[] imageByte = IOUtils.toByteArray(new FileInputStream(capture));
            destination = Base64.getEncoder().encodeToString(imageByte);

        } catch (Exception e) {
            logger.info("Error al tomar captura de pantalla ");
        }

        return destination;
    }
}
