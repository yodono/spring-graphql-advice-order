package com.vyodono.booksgraphql.advice;

import com.vyodono.booksgraphql.exception.BookNotFoundException;
import graphql.GraphQLError;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.graphql.data.method.annotation.GraphQlExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class BookExceptionHandler {

    @GraphQlExceptionHandler(RuntimeException.class)
    public GraphQLError handle(RuntimeException ex) {
        return GraphQLError.newError().message("Book Error").build();
    }

    @GraphQlExceptionHandler(BookNotFoundException.class)
    public GraphQLError handle(BookNotFoundException ex) {
        return GraphQLError.newError().message("Book Not Found").build();
    }
}
