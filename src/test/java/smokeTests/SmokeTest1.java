package smokeTests;

import base.DriverFactory;
import base.DriverType;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.utils.FileUtil;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobject.ButtonPage;
import pageobject.TextBoxPage;
import java.util.Properties;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class SmokeTest1 {
    private WebDriver driver;

    TextBoxPage textBoxPage;
    ExtentHtmlReporter htmlReporter;
    ExtentReports extent;
    ExtentTest test;

    @BeforeTest
    public void setup() {
        htmlReporter = new ExtentHtmlReporter("target/QAtoQE_Report.html");
        htmlReporter.setAppendExisting(true);

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        test = extent.createTest("SmokeTest1", "testing textbox module");


        driver = DriverFactory.getDriver(DriverType.CHROME);
        driver.get("https://demoqa.com/elements");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void test1() throws InterruptedException, IOException {

        test.log(Status.INFO, "navigating to the text box module");
        textBoxPage = new TextBoxPage(driver);
        this.textBoxPage.clickTextButton();
        test.log(Status.PASS, "User navigating to textbox module succesfully");

        Assert.assertTrue(this.textBoxPage.isAt());
        test.log(Status.INFO, "Entering details in text module");
        Assert.assertTrue(true);

        extent.flush();
        driver.close();
        //textBoxPage.enterDetails();
    }

    //    @Test
//    public void test2(){
//        buttonPage = new ButtonPage(driver);
//        buttonPage.clickingButtons();
//        Assert.assertTrue(this.buttonPage.isAt());
//        buttonPage.clickingButtons();
//    }
    @AfterMethod

    public void screenShot(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                TakesScreenshot screenshot = (TakesScreenshot) driver;
                File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                File destFile = new File("target/" + result.getName() + ".png");
                FileUtils.copyFile(src, destFile);
                String path = "/QAtoQE_Framework/target/" + result.getName() + ".png";
                test.log(Status.FAIL, "<a href=' " + path + " '<img src='" + path + " 'height='100' width='100'/></a>");
                extent.flush();
                driver.close();
            } catch (Exception e) {
                System.out.println("Exception while taking screenshot" + e.getMessage());
            }
        }
    }
}



