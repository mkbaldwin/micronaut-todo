package todo.service

import todo.model.Todo

import javax.inject.Inject
import javax.inject.Singleton
import javax.persistence.EntityManager
import javax.transaction.Transactional

@Singleton
class TodoServiceImpl implements  TodoService {
  List<Todo> dummyData = [
      new Todo(title: "Download Micronaut", complete: true),
      new Todo(title: "Learn Micronaut", complete: false),
      new Todo(title: "Build Application", complete: false)
  ]

  EntityManager entityManager

  @Inject
  TodoServiceImpl(EntityManager entityManager) {
    this.entityManager = entityManager
  }

  @Transactional
  @Override
  def populateTestData() {
    dummyData.each {
      entityManager.persist(it)
    }
  }

  @Transactional
  @Override
  List<Todo> getAllTodos() {
    entityManager.findAll()
  }

  @Transactional
  @Override
  Todo getTodo(int id) {
    //dummyData.find { it.id == id}
    entityManager.find(Todo.class, id)
  }
}
