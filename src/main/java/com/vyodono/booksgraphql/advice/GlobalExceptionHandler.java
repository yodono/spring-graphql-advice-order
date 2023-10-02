package com.vyodono.booksgraphql.advice;

import graphql.GraphQLError;
import org.springframework.graphql.data.method.annotation.GraphQlExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalExceptionHandler {

    @GraphQlExceptionHandler(RuntimeException.class)
    public GraphQLError handle(RuntimeException ex) {
        return GraphQLError.newError().message("Internal Error").build();
    }
}
