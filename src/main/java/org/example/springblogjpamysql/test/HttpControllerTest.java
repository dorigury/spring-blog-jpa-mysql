package org.example.springblogjpamysql.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class HttpControllerTest {

    @GetMapping("/http")
    public String getTest(@RequestParam String id, @RequestParam String username) {

        System.out.println("id = " + id + ", username = " + username);

        return "http test get";
    }

    @GetMapping("/http/get")
    public String getTest(Member m) {

        System.out.println("m = " + m);

        return "http test get";
    }

    @PostMapping("/http")
    public String postTest(Member m) {

        System.out.println("m = " + m);

        return "http test post";
    }

    @PostMapping("/http/string")
    public String postTest(@RequestBody String text) {

        System.out.println("text = " + text);

        return "http text post";
    }

    @PostMapping("/http/json")
    public String jsonTest(@RequestBody Member m) {

        System.out.println("m = " + m);

        return "http text post";
    }
}
