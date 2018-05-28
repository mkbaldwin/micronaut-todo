package todo.controller

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces
//@Controller("/")
class IndexController {

  @Get("/")
  @Produces(MediaType.TEXT_PLAIN)
  String index() {
    return "Hello World";
  }
}