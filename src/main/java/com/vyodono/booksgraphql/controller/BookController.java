package com.vyodono.booksgraphql.controller;

import com.vyodono.booksgraphql.exception.BookNotFoundException;
import com.vyodono.booksgraphql.model.Book;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/books")
public class BookController {

    @QueryMapping
    public Mono<Book> book(@Argument String id) {
        if (id.equals("00000000-0000-0000-0000-000000000000")) {
            return Mono.just(new Book(UUID.fromString(id), "Niketche"));
        }

        return Mono.error(new BookNotFoundException(UUID.fromString(id)));
    }
}
