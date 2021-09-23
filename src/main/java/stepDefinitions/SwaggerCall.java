//package stepDefinitions;
//
//import SwaggerPojo.Category;
//import SwaggerPojo.Root;
//import SwaggerPojo.Tags;
//import base.DriverFactory;
//import base.DriverType;
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import io.restassured.RestAssured;
//import io.restassured.response.Response;
//import org.openqa.selenium.WebDriver;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//import static io.restassured.RestAssured.given;
//
//public class SwaggerCall {
//    WebDriver driver;
//Response response;
//    Root root;
//    Category category;
//    Tags tags;
//
//    @Given("^I am navigating to the (.*)$")
//    public void iAmGettingTheSwaggerPage() {
//        driver.get("https://petstore.swagger.io/#/pet");
//    }
//
//    @When("I am creating a pojos class and passing the values")
//    public void iAmCreatingAPojosClassAndPassingTheValues() {
//
//        root = new Root();
//        tags =new Tags();
//        category=new Category();
//
//        List<Tags> value1 = new ArrayList<>();
//        value1.add(tags);
//
//        List<String> photo = new ArrayList<>();
//        photo.add("String");
//
//        category.setId(100);
//        category.setName("kee");
//
//        root.setId(0);
//        root.setName("keerthi");
//        root.setCategory(category);
//        root.setTags(value1);
//        root.setPhotoUrls(photo);
//        root.setStatus("avaliable");
//         response = given().
//                when().
//                header("Content-Type", "application/json").
//                body(root).
//                put("https://petstore.swagger.io/v2/pet");
//    }
//
//    @Then("Getting the responce and statuscode")
//    public void gettingTheResponceAndStatuscode() {
//        String responseBoby = response.getBody().asString();
//        System.out.println(responseBoby);
//        System.out.println(response.getStatusCode());
//    }
//
//
//}
