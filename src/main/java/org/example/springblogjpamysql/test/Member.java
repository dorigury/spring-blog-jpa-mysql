package org.example.springblogjpamysql.test;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Member {
    private int id;
    private String username;
    private String password;
    private String email;
}
