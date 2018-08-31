package com.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@EnableSwagger2
public class SampleApiApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        //it starts Spring Framework. Time to work.
        //can also be new SpringApplication(SampleApiApplication.cass).run(args)
        SpringApplication.run(SampleApiApplication.class, args);

    }
}
