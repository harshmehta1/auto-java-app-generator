package com.neu.autojavaappgenerator;

import com.neu.autojavaappgenerator.Services.JsonReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@EntityScan("com.neu.autojavaappgenerator.Models")
@EnableJpaRepositories("com.neu.autojavaappgenerator.Repository")

public class AutojavaappgeneratorApplication {

    public static void main(String[] args) {

        SpringApplication.run(AutojavaappgeneratorApplication.class, args);


    }

}