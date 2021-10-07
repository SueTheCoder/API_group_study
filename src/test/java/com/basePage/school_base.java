package com.basePage;

import com.utilities.ConfigurationReader;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.*;

public interface school_base {
    @BeforeAll
    public static void setup(){
        baseURI = ConfigurationReader.getProperty("schoolURL");
    }

    @AfterAll
    public static void teardown(){
        reset();
    }
}
