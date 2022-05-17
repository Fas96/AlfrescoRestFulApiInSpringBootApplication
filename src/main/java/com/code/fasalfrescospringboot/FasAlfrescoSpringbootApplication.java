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
    SearchCmd findNodesCmd;


//    execute(String username, String pwd, String firstname, String lastname, String email)
    @Override
    public void run(String... args) throws Exception {
//        listAuditAppsCmd.execute("eea473d5-d3d2-473b-bd7f-49ec03179648");
        findNodesCmd.execute("book-production","Baseball Game");

    }
}
