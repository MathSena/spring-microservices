package com.mathsena.departamentservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
        info = @Info(
                title = "Department Service REST APIs",
                description = "Department Service REST APIs Documentation",
                version="v1.0",
                contact = @Contact(
                        name = "Matheus Sena",
                        email = "mathsena07@hotmail.com"
                ),
                license = @License(
                        name = "Apache 2.0"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "Department-Service Doc"
        )
)
@SpringBootApplication
public class DepartamentServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DepartamentServiceApplication.class, args);
    }

}
