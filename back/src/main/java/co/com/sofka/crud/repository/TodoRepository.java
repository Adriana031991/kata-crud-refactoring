package co.com.sofka.crud.repository;

import co.com.sofka.crud.entity.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Integer> {
}
