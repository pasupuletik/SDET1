package base;

import com.aventstack.extentreports.utils.FileUtil;
import org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public abstract class baseMethods {

    WebDriver driver;
public abstract boolean isAt();
//public void screenshot (String filename, WebDriver driver) throws IOException
//{
//    File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//    FileUtils.copyFile(src,new File("target/"+fileName+".png"));
//
//}
//public String getproperties(String keyValus) throws IOException {
//
//}


}
