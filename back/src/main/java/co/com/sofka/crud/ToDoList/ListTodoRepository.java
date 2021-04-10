package co.com.sofka.crud.ToDoList;

import co.com.sofka.crud.ToDoList.ListTodo;
import org.springframework.data.repository.CrudRepository;

public interface ListTodoRepository extends CrudRepository<ListTodo, Long> {
}
