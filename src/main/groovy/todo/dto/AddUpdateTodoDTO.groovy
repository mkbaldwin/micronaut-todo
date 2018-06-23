package todo.dto

import groovy.transform.ToString

@ToString
class AddUpdateTodoDTO {
  String title
  boolean complete
}
