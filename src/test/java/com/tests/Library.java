package com.tests;

import com.basePage.library_base;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

public class Library implements library_base {

    @Tag("smoke")
    @Test
    @DisplayName("get_book_categories")
    public void get_book_categories(){
        given().header("x-library-token", library_base.getToken())
                .when().get("/get_book_categories").prettyPeek()
                .then().statusCode(200).contentType("application/json; charset=utf-8");
    }
}
