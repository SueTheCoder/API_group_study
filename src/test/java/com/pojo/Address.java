package com.pojo;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Address {

    private int addressId;
    private String street;
    private String city;
    private String state;
    private int zipCode;

}
