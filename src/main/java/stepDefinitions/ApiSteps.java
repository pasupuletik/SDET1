package stepDefinitions;

import com.jayway.jsonpath.JsonPath;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.Assert;
import org.testng.asserts.Assertion;
import pojos.PostPojo;


import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ApiSteps {
    Response response;
    PostPojo postPojo;
    @Given("I am baseURI of the regres application")
    public void BaseApplication(){
        RestAssured.baseURI = "https://regres.in";

    }

    @When("^I passing endpoint for single user$")
    public void setResponse(){
                 response =  given()
                         .when()
        .header("Content-Type", "application/json")
        .get("https://reqres.in/api/users/2");
                     }
@Then("I validate the status code")
    public void validationStatus(){
   Assert.assertEquals(response.getStatusCode(),200);
    }
    @And("I validate email")
    public void iValidateEmail() {
        String responseBoby = response.getBody().asString();
        String emailValue = JsonPath.read(responseBoby,"$.data.email");
        System.out.println(emailValue);
    }



    @When("I passing endpoint for create user")
    public void iPassingEndpointForCreateUser() {
        postPojo= new PostPojo();
        postPojo.setName("morpheus");
        postPojo.setJob("leader");


        response = given().
                when().
                header("Content-Type","application/json").
                body(postPojo).
                post("https://reqres.in/api/users");
    }
    @And("I Validate id")
    public void iValidateId() {
        String responseBoby = response.getBody().asString();
        String Id = JsonPath.read(responseBoby,"$.id");
        System.out.println(Id);

    }

    @Then("I validate the status code of")
    public void iValidateTheStatusCodeOf() {
        Assert.assertEquals(response.statusCode(),201);
    }



    @When("I passing endpoint for update user")
    public void iPassingEndpointForUpdateUser() {
        response = given().
                when().
                header("Content-Type","application/json").
                body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"zion resident\"\n" +
                        "}").
                put("https://reqres.in/api/users/2");
    }
    @And("validate updated time")
    public void validateUpdatedTime() {
        String responseBoby = response.getBody().asString();
        String update = JsonPath.read(responseBoby,"$.updatedAt");
        System.out.println(update);
    }

    @When("I passing endpoint for delete user")
    public void iPassingEndpointForDeleteUser() {
         response = given().
            when().
            header("Content-Type","application/json").
            delete("https://reqres.in/api/users/2");
    }

    @Then("I validate the status code for delete")
    public void iValidateTheStatusCodeForDelete() {
        Assert.assertEquals(response.statusCode(),204);
    }


    @When("I passing endpoint for postcall")
    public void iPassingEndpointForPostcall() {
        response = given().
                when().
                header("Content-Type","application/json").
                body("{\n" +
                        "    \"email\": \"eve.holt@reqres.in\",\n" +
                        "    \"password\": \"pistol\"\n" +
                        "}").
                post("https://reqres.in/api/register");
    }

    @And("validate key")
    public void validateToken() {
        String responseBoby = response.getBody().asString();
        String key = JsonPath.read(responseBoby,"$.id");
        System.out.println(key);

    }

    @When("I passing endpoint for list of users")
    public void iPassingEndpointForListOfUsers() {response =  given()
            .when()
            .header("Content-Type", "application/json")
            .get("https://reqres.in/api/unknown");
    }


}

