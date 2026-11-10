package org.timothydickyherlambang.rscorebackend.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(
        title = "RS Core Backend API",
        version = "v1",
        description = "REST API for managing medical checkup"))
public class OpenApiConfig {
}
