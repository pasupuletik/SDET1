package smokeTests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.restassured.response.Response;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.post;

public class FirstAPITest1 {
    WebDriver driver;
    ExtentHtmlReporter htmlReporter;
    ExtentReports extent;
    ExtentTest test;


    @BeforeTest
    public void setup() {
        htmlReporter = new ExtentHtmlReporter("target/QAtoQE_Report.html");
        htmlReporter.setAppendExisting(true);

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        test = extent.createTest("FirstAPITest", "postMan");

    }
    @Test
    public void getCall()
    {
        this.test.log(Status.INFO, "get Request");
        Response response = given().
                            when().
                            header("Content-Type", "application/json").
                            get("https://reqres.in/api/users/2");
        String responseBoby = response.getBody().asString();
        System.out.println(response.getStatusCode());
        this.test.log(Status.INFO,responseBoby);
        extent.flush();
       // driver.close();
    }

    @Test
    public void postCall()
    {
        this.test.log(Status.INFO, "post Request");
            Response response = given().
                                when().
                                header("Content-Type","application/json").
                               body("{\n" +
                                   "  \"name\": \"morpheus\",\n" +
                                       "        \"job\":\"leader\",\n"+

                                            "}").
                                post("https://reqres.in/api/users");
            String responseBoby = response.getBody().asString();
            System.out.println(responseBoby);
        extent.flush();
       // driver.close();

        }
        @Test
        public void putCall(){

            this.test.log(Status.INFO, "put Request");
            Response response = given().
                    when().
                    header("Content-Type","application/json").
                    body("{\n" +
                            "    \"name\": \"morpheus\",\n" +
                            "    \"job\": \"zion resident\"\n" +
                            "}").
                    put("https://reqres.in/api/users/2");
            String responseBoby = response.getBody().asString();
            System.out.println(responseBoby);
            extent.flush();
           // driver.close();
        }

    @AfterMethod

    public void screenShot(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
               // Response response=response.getStatusCode();
                TakesScreenshot screenshot = (TakesScreenshot) driver;
                File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                File destFile = new File("target/" + result.getName() + ".png");
                FileUtils.copyFile(src, destFile);
                String path = "/QAtoQE_Framework/target/" + result.getName() + ".png";
                test.log(Status.FAIL, "<a href=' " + path + " '<img src='" + path + " 'height='100' width='100'/></a>");
               // System.out.println(response.getStatusCode());
                extent.flush();
                driver.close();
            } catch (Exception e) {
                System.out.println("Exception while taking screenshot" + e.getMessage());
            }
        }

    }
}

