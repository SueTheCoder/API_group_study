package com.tests;

import com.basePage.school_base;
import com.pojo.Address;
import com.pojo.Company;
import com.pojo.Contact;
import com.pojo.Students;
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
/*
        // JsonPath examples
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
 */
        // POJO examples
        Contact contactPOJO = jsonPath.getObject("students[0].contact", Contact.class);
        System.out.println("contactPOJO = " + contactPOJO);

        Company companyPOJO = jsonPath.getObject("students[0].company", Company.class);
        System.out.println("companyPOJO = " + companyPOJO);

        Address addressPOJO = jsonPath.getObject("students[0].company.address", Address.class);
        System.out.println("addressPOJO = " + addressPOJO);

        Students student1 = new Students();
        student1.setStudentId(1);
        student1.setFirstName("Sue");
        System.out.println("student1.getFirstName() = " + student1.getFirstName());
        System.out.println("student1.getStudentId() = " + student1.getStudentId());

        // it = iterator -> short way to loop
        String andrew = jsonPath.getString("students.find{it.lastName == 'Clark'}.firstName");
        System.out.println("andrew = " + andrew);

        int sueID = jsonPath.getInt("students.find{it.firstName == 'Sue'}.studentId");
        System.out.println("sueID = " + sueID);

        int johnID = jsonPath.getInt("students.find{it.firstName == 'John'}.studentId");
        System.out.println("johnID = " + johnID);


    }
}
