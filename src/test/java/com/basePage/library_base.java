package com.basePage;

import com.utilities.ConfigurationReader;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.reset;
import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
public interface library_base {

    @BeforeAll
    public static void setup(){
        baseURI = ConfigurationReader.getProperty("libraryURL");

    }

    @AfterAll
    public static void teardown(){
        reset();
    }


    public static String getToken(){
        String token = given().accept(ContentType.JSON)
                .formParams("email", ConfigurationReader.getProperty("librarian_email"),
                        "password", ConfigurationReader.getProperty("librarian_pass"))
                .when().post("/login")
                .then().statusCode(200).extract().jsonPath().getString("token");
        return token;
    }


}
