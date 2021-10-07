package com.tests;

import com.basePage.school_base;
import groovyjarjarantlr.LexerSharedInputState;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

public class School implements school_base {

    @Tag("smoke")
    @Tag("regression")
    @Test
    @DisplayName("Retrieve all students")
    public void retrieveAllStudents(){

        Response response = given().accept(ContentType.JSON) // .log().all()
                .when().get("/student/all"); //.prettyPeek();

        JsonPath jsonPath = response.jsonPath();    // de-serialization JSON to JAVA

        System.out.println("jsonPath.getInt(\"students[0].studentId\") = " + jsonPath.getInt("students[0].studentId"));
        assertThat(jsonPath.getInt("students[0].studentId"), is(24333));

        System.out.println("jsonPath.getString(\"students[1].lastName\") = " + jsonPath.getString("students[1].lastName"));
        String Clark = jsonPath.getString("students[1].lastName");
        assertThat(Clark, is("Clark"));

        System.out.println("jsonPath.getInt(\"students[0].contact.contactId\") = " + jsonPath.getInt("students[0].contact.contactId"));
        System.out.println("jsonPath.getString(\"students[15].contact.phone\") = " + jsonPath.getString("students[15].contact.phone"));
        System.out.println("jsonPath.getInt(\"students[0].company.companyId\") = " + jsonPath.getInt("students[0].company.companyId"));
        System.out.println("jsonPath.getInt(\"students[0].company.address.addressId\") = " + jsonPath.getInt("students[0].company.address.addressId"));
        // System.out.println("jsonPath.getList(\"students.firstName\") = " + jsonPath.getList("students.firstName"));

        List<Map<String, Object>> studentList = jsonPath.getList("students");
        //System.out.println("studentList = " + studentList);

        Map<String, Object> objectMap = jsonPath.getMap("students[0]");
        for (Entry<String, Object> s : objectMap.entrySet()) {
            System.out.println(s);
        }


    }
}
