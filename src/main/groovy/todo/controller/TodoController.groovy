package todo.controller

import grails.gorm.transactions.Transactional
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Put
import todo.dto.AddUpdateTodoDTO
import todo.model.Todo
import todo.service.TodoService

import javax.inject.Inject

@Controller("/api/todo")
class TodoController {
  TodoService todoService

  @Inject
  TodoController(TodoService todoService) {
    this.todoService = todoService
  }

  @Get("/{id}")
  Todo getTodo(int id) {
    todoService.getTodo(id)
  }

  @Transactional
  @Put("/{id}")
  void updateTodo(int id, @Body AddUpdateTodoDTO newTodo) {
    def existingTodo = todoService.getTodo(id)
    existingTodo.setTitle(newTodo.title)
    existingTodo.setComplete(newTodo.complete)
    existingTodo.save()
  }
}
