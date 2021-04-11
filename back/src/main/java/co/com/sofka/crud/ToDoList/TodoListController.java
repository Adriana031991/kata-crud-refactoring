package co.com.sofka.crud.ToDoList;

import co.com.sofka.crud.TodoDTO.DTOlistTodo;
import co.com.sofka.crud.TodoDTO.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TodoListController {

    @Autowired
    private ListTodoService newService;

    @GetMapping(value = "api/listed")
    public ResponseDto list() {
        return newService.list();
    }

    @PostMapping(value = "api/list")
    public ResponseDto save(@RequestBody DTOlistTodo listTodo) {
        return newService.save(listTodo);
    }

    @PutMapping(value = "api/list")
    public ResponseDto update(@RequestBody DTOlistTodo dtOlistTodo) {
        if (dtOlistTodo.getId() != null) {
            return newService.save(dtOlistTodo);
        }
        throw new RuntimeException("No existe el id para actualziar");
    }

    @DeleteMapping(value = "api/{id}/list")
    public void delete(@PathVariable("id") Long id) {
        newService.delete(id);
    }

    @GetMapping(value = "api/{id}/list")
    public ListTodo get(@PathVariable("id") Long id) {
        return newService.get(id);
    }
}
