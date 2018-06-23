package todo.model

import javax.persistence.Column
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@grails.gorm.annotation.Entity
@Table(name = "TODO")
class Todo {
  @Id
  @GeneratedValue
  @Column(name = "ID", updatable = false, nullable = false)
  int id

  @Column(name = "TITLE")
  String title

  @Column(name = "COMPLETE")
  boolean complete
}
