package todo.controller

import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import todo.dto.AddUpdateTodoDTO
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

  @Get("/")
  List<Todo> listTodos() {
    todoService.getAllTodos()
  }

  @Post("/")
  Todo addTodo(@Body AddUpdateTodoDTO newTodo) {
    todoService.addTodo(newTodo.title, newTodo.complete)
  }
}
