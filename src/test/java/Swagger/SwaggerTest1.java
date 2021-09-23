package Swagger;

import SwaggerPojo.Category;
import SwaggerPojo.Root;
import SwaggerPojo.Tags;
import io.restassured.response.Response;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class SwaggerTest1 {
    Root root;
    Category category;
    Tags tags;
    @Test
    public void PutSwagger() {
        root = new Root();
        tags =new Tags();
        category=new Category();

        List<Tags> value1 = new ArrayList<>();
        value1.add(tags);

        List<String> photo = new ArrayList<>();
        photo.add("String");

        category.setId(100);
        category.setName("kee");

        root.setId(0);
        root.setName("keerthi");
        root.setCategory(category);
        root.setTags(value1);
        root.setPhotoUrls(photo);
        root.setStatus("avaliable");

        Response response = given().
                when().
                header("Content-Type", "application/json").
                body(root).
                put("https://petstore.swagger.io/v2/pet");
        String responseBoby = response.getBody().asString();
        System.out.println(responseBoby);
    }

    @Test
    public void PostSwagger() {
        root = new Root();
        tags =new Tags();
        category=new Category();

        List<Tags> value1 = new ArrayList<>();
        value1.add(tags);

        List<String> photo = new ArrayList<>();
        photo.add("String");

        category.setId(14);
        category.setName("Hello");

        root.setId(1);
        root.setName("world");
        root.setCategory(category);
        root.setTags(value1);
        root.setPhotoUrls(photo);
        root.setStatus("notavaliable");

        Response response = given().
                when().
                header("Content-Type", "application/json").
                body(root).
                post("https://petstore.swagger.io/v2/pet");
        String responseBoby = response.getBody().asString();
        System.out.println(responseBoby);
    }


}

