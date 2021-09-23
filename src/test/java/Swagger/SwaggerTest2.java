package Swagger;

import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SwaggerTest2 {
    WebDriver driver;
    @Test
    public void getCall(){
      //driver.findElement(By.partialLinkText("pending")).click();
        Response response = given().
                when().
                header("Content-Type","application/json").
                get("https://petstore.swagger.io/v2/pet/findByStatus?status=sold");
        String responseBoby = response.getBody().asString();
        System.out.println(responseBoby);
        System.out.println(response.statusCode());

    }


}
