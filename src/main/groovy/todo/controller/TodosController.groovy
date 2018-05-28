package todo.controller

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces
import todo.model.Todo
import todo.service.TodoService

import javax.inject.Inject

@Controller("/api/todos")
class TodosController {
  TodoService todoService

  @Inject
  TodosController(TodoService todoService) {
    this.todoService = todoService
  }

  @Get("/list")
  List<Todo> listTodos() {
    todoService.getAllTodos()
  }

  @Get("/todo/{id}")
  Todo getTodo(int id) {
    todoService.getTodo(id)
  }



  @Get("/test")
  @Produces(MediaType.TEXT_PLAIN)
  String populateTestData() {
    todoService.populateTestData()
    "OK"
  }
}
