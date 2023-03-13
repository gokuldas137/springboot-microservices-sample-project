package com.sampleproject.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {

        return builder
                .routes()
                .route(p -> p.path("/get")
                        .filters(f -> f
                                .addRequestHeader("NewHeader", "NewUri")
                                .addRequestParameter("Param", "Value"))
                        .uri("http://httpbin.org:80"))
                .route(p -> p.path("/course/**")
                        .uri("lb://course"))
                .route(p -> p.path("/courseMaterial/**")
                        .uri("lb://course-material"))
                .route(p -> p.path("/course-feign/**")
                        .uri("lb://course"))
                .route(p -> p.path("/student/**")
                        .uri("lb://student"))
                .build();
    }
}
