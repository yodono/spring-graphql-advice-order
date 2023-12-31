# spring-graphql-advice-order
When you have many @ControllerAdvice classes, the @Order given to each bean is not respected.

## Steps to reproduce
Start `booksgraphql`, open GraphiQL at `http://localhost:8080/graphiql`

Run a query that will trigger a RuntimeException
```graphql
# e.g invalid UUID
query {
    book(id: "1") {
      id,
      name
    }
}
```
Notice that it will return "**Internal Error**" as message. Even though `@Order(Ordered.HIGHEST_PRECEDENCE)` is set in the book handler, it does not run first.

---

Run a query that will trigger a BookNotFoundException
```graphql
# e.g non existing UUID
query {
    book(id: "00000000-0000-0000-0000-000000000001") {
      id,
      name
    }
}
```
Notice that it will return "**Internal Error**" as message, since the error extends RuntimeException which is caught first in the global handler.