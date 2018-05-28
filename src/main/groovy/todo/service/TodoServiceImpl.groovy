package todo.service

import grails.gorm.transactions.Transactional
import todo.model.Todo

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TodoServiceImpl implements  TodoService {
  List<Todo> dummyData = [
      new Todo(title: "Download Micronaut", complete: true),
      new Todo(title: "Learn Micronaut", complete: false),
      new Todo(title: "Build Application", complete: false),
      new Todo(title: "Profit", complete: false)
  ]

  @Inject
  TodoServiceImpl() {
  }

  @Transactional
  @Override
  def populateTestData() {
    dummyData.each {
      it.save()
    }
  }

  @Transactional
  @Override
  List<Todo> getAllTodos() {
    Todo.findAll()
  }

  @Transactional
  @Override
  Todo getTodo(int id) {
    Todo.findById(id)
  }
}
