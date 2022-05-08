package com.code.fasalfrescospringboot;

import com.code.fasalfrescospringboot.alfresco.common.*;
import org.alfresco.core.handler.NodesApi;
import org.alfresco.core.model.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FasAlfrescoSpringbootApplication extends SpringBootServletInitializer implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(FasAlfrescoSpringbootApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(FasAlfrescoSpringbootApplication.class);
    }


    @Autowired
    MoveNodeCmd copyNodeCmd;


    @Override
    public void run(String... args) throws Exception {

        copyNodeCmd.execute("ea802aa9-5ac4-41fe-938b-9cdeae14a043","e171c173-e7a6-4b64-82dd-5bf205c8b120");

          }
}
