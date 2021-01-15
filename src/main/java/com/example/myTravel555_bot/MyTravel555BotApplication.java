package com.example.myTravel555_bot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.ApiContextInitializer;

@SpringBootApplication
public class MyTravel555BotApplication {

    public static void main(String[] args) {

        ApiContextInitializer.init();

        SpringApplication.run(MyTravel555BotApplication.class, args);
    }
}
