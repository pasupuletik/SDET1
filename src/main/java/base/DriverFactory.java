package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class DriverFactory {
    //creating driver map
    private static final Map<DriverType,Supplier<WebDriver>> driverMap= new HashMap<>();

    public static final Supplier<WebDriver> chromeDriverSupplier = ()->{
        System.setProperty("webdriver.chrome.driver","C:\\Users\\skota\\Downloads\\cc.exe");
        return new ChromeDriver();
    };
    public static final Supplier<WebDriver> firefoxDriverSupplier= ()->{
        System.setProperty("webdriver.chrome.driver","C:\\Users\\skota\\Downloads\\cc.exe");
        return new FirefoxDriver();
    };
    //Adding driver to map
    static{
        driverMap.put(DriverType.CHROME,chromeDriverSupplier);
        driverMap.put(DriverType.FIREFOX,firefoxDriverSupplier);
    }
    public static final WebDriver getDriver(DriverType type){
        return driverMap.get(type).get();
    }
}
