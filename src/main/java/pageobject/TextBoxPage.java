package pageobject;

import base.baseMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TextBoxPage extends baseMethods {

    WebDriver driver;
    WebDriverWait wait;
    @FindBy(xpath="//span[text()='Text Box']")
    WebElement btn_textbox;

    @FindBy(id="userName")
    WebElement txt_userName;
    @FindBy(id="userEmail")
    WebElement txt_email;
    @FindBy(id="currentAddress")
    WebElement txt_address1;
    @FindBy(id="permanentAddress")
    WebElement txt_address2;
//    @FindBy(id="submit")
//    WebElement btn_submit;


    public TextBoxPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public void clickTextButton(){
        this.btn_textbox.click();
    }
    public void enterDetails(){
      //  this.btn_textbox.click();
        this.txt_userName.sendKeys("Keerthi");
        this.txt_email.sendKeys("kee@gmail.com");
        this.txt_address1.sendKeys("columbus");
        this.txt_address2.sendKeys("ohio");
        WebElement element = driver.findElement(By.xpath("//*[@id='submit']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
        //this.btn_submit.click();
    }


    @Override
    public boolean isAt() {
        wait = new WebDriverWait(this.driver,15);
        return this.wait.until((d)->this.txt_userName.isDisplayed());

    }
}
