package com.vyodono.booksgraphql.exception;

import java.util.UUID;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(UUID id) {
        super("Sorry, this book is not on our catalog: #" + id.toString());
    }
}
