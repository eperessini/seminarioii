package com.undec.gedufy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
public class GedufyBackendApplication {

    @PostConstruct
    void init() {
        TimeZone.setDefault(TimeZone.getTimeZone("GMT-3"));
    }

    public static void main(String[] args) {
        SpringApplication.run(GedufyBackendApplication.class, args);
    }

}
