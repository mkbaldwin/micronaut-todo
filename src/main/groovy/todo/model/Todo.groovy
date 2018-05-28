package todo.model

import javax.persistence.*

@Entity
@Table(name = "TODO")
class Todo {
  @Id
  @GeneratedValue
  @Column(name = "id", updatable = false, nullable = false)
  int id

  @Column(name = "TITLE")
  String title

  @Column(name = "COMPLETE")
  boolean complete
}
