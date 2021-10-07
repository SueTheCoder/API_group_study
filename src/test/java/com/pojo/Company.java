package com.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Company {

    private int companyId;
    private String companyName;
    private String title;
    private String startDate;
    private Address address;
}
