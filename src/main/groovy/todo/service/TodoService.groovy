package todo.service

import todo.model.Todo

interface TodoService {
  List<Todo> getAllTodos()
  Todo getTodo(int id)
  void addTodo(String title, boolean complete)
}
