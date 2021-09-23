package stepDefinitions;

import base.DriverFactory;
import base.DriverType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import pageobject.TextBoxPage;

import java.io.IOException;

public class TextBoxSteps {
    WebDriver driver;
    TextBoxPage textBoxPage;


    @Given("^I am navigating to the (.*)$")
    public void navigatingtextBoxApplication(String URI)
    {
        driver= DriverFactory.getDriver(DriverType.CHROME);
        driver.get(URI);
    }
    @When("^I click on textbox option$")
    public void clickingTextboxOption()
    {
        textBoxPage = new TextBoxPage(driver);
        this.textBoxPage.clickTextButton();
        Assert.assertTrue(this.textBoxPage.isAt());
    }
    @And("^I enter all the textbox enterDetails$")
    public void textBoxDetails() throws InterruptedException, IOException {
        textBoxPage.enterDetails();

       // textBoxPage.screenShot(screenShotName, driver);
    }
    @Then("^I quit the application$")
    public void quitApplication()
    {
        driver.close();
    }


}
