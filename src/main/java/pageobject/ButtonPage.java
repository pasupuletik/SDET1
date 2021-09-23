package pageobject;

import base.baseMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ButtonPage extends baseMethods {
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(xpath="//span[text()='Buttons']")
    WebElement btn_button;

    @FindBy(id="doubleClickBtn")
    WebElement btn_doubleClick;

    @FindBy(id="rightClickBtn")
    WebElement btn_rightclick;

    public ButtonPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void clickButtonOption()
    {
       this.btn_button.click();
    }
    public void clickingButtons()
    {
        this.btn_button.click();
        Actions action = new Actions(driver);
        action.moveToElement(this.btn_doubleClick).doubleClick();
        action.moveToElement(this.btn_rightclick).contextClick();
    }

    @Override
    public boolean isAt() {
        wait = new WebDriverWait(this.driver,15);
        return this.wait.until((d)->this.btn_doubleClick.isDisplayed());
    }
}
