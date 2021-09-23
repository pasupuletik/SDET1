package PostMan;


import com.jayway.jsonpath.JsonPath;
import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.PostPojo;


import static io.restassured.RestAssured.given;

public class ApiTesting {
    Response response;
    PostPojo postPojo;


    @Test
    public void GetCalla() {
        response = given().
                when().
                header("Content-Type", "application/json").
                get("https://reqres.in/api/users/2");
        String responseBoby = response.getBody().asString();
       // System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(),200);
        String emailValue = JsonPath.read(responseBoby,"$.data.email");
        System.out.println(emailValue);
    }

    @Test
    public void get2call(){
        response = given().
                when().
                header("Content-Type", "application/json").
                get("https://reqres.in/api/users/2");
        String responseBoby = response.getBody().asString();
        String emailValue = JsonPath.read(responseBoby,"$.data[1]");
    }


    @Test
    public void PostCall(){
        postPojo= new PostPojo();
        postPojo.setName("morpheus");
        postPojo.setJob("leader");
        Response response = given().
                when().
                header("Content-Type","application/json").
                body(postPojo).
                post("https://reqres.in/api/users");
        String responseBoby = response.getBody().asString();

        System.out.println(response.getStatusCode());
        System.out.println(postPojo.getName());
        String emailValue = JsonPath.read(responseBoby,"$.data.email");
        System.out.println(emailValue);
    }

            @Test
            public void PutCall(){
                Response response = given().
                        when().
                        header("Content-Type","application/json").
                        body("{\n" +
                                "    \"name\": \"morpheus\",\n" +
                                "    \"job\": \"leader\"\n" +
                                "}").
                        put("https://reqres.in/api/users/2");
                String responseBoby = response.getBody().asString();
                System.out.println(responseBoby);
            }


            @Test
            public void deleteCall(){
        Response response = given().when().header("Content-Type","application/json").delete("https://reqres.in/api/users/2");
                System.out.println(response.getStatusCode());
                Assert.assertEquals(response.getStatusCode(),204);
            }
}
