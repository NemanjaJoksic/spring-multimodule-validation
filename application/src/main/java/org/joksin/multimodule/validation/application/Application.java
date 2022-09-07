package org.joksin.multimodule.validation.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan ("org.joksin.multimodule.validation")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
