package com.pojo;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Contact {
    private int contactId;
    private String phone;
    private String emailAddress;
    private String premanentAddress;
}
