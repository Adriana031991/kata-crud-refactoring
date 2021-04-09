package co.com.sofka.crud.Repository;

import co.com.sofka.crud.Entity.ListTodo;
import org.springframework.data.repository.CrudRepository;

public interface ListTodoRepository extends CrudRepository<ListTodo, Long> {
}
