package com.basePage;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import com.utilities.ConfigurationReader;

import static io.restassured.RestAssured.*;

public interface base_page {

    @BeforeAll
    public static void setup(){
        baseURI = ConfigurationReader.getProperty("baseURL");
    }

    @AfterAll
    public static void teardown(){
        reset();
    }

}
