package com.covid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author SunilAnand
 * @since 2020-04-14
 **/
@SpringBootApplication(scanBasePackages = { "com.covid" })
public class CovidServiceApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(CovidServiceApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(CovidServiceApplication.class);
    }
}