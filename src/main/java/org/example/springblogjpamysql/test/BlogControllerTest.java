package org.example.springblogjpamysql.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogControllerTest {

    // make method hello
    @GetMapping("/test/hello")
    public String hello() {
        return "Hello World!";
    }

}
