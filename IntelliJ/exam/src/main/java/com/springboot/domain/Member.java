package com.springboot.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
public class Member {
    private String id;
    private int passwd;
    private String city;
    private String sex;
    private String[] hobby;
    private String greetings;
}
