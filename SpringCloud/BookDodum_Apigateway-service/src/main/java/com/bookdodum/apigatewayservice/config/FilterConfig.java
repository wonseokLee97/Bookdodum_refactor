package com.bookdodum.apigatewayservice.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class FilterConfig {

//    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        // filter를 통해 request, response Header 에 K-V 형식의 데이터를 추가할 수 있다.
        return builder.routes()
                .route(r -> r.path("/user-service/**")
                        .filters(f -> f.addRequestHeader("user-request", "user-request-header")
                                       .addResponseHeader("user-response", "user-response-header"))
                        .uri("http://localhost:8081"))

                .route(r -> r.path("/second-service/**")
                        .filters(f -> f.addRequestHeader("second-request", "second-request-header")
                                .addResponseHeader("second-response", "second-response-header"))
                        .uri("http://localhost:8082"))
                .build();
    }
}
