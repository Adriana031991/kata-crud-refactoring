package co.com.sofka.crud.controller;

import co.com.sofka.crud.dto.ResponseDto;
import co.com.sofka.crud.dto.TodoDto;
import co.com.sofka.crud.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/todo")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @PostMapping()
    public ResponseDto addTodo(@RequestBody TodoDto todoDto){

        return todoService.saveTodo(todoDto);

    }
    @PutMapping()
    public ResponseDto updateTodo(@RequestBody TodoDto todoDto){
        return todoService.updateTodo(todoDto);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseDto deleteById(@PathVariable("id") Integer id) {
        return todoService.deleteById(id);
    }

    @GetMapping()
    public ResponseDto getTodo() {
        return todoService.todo();
    }

    @GetMapping(value = "/{id}")
    public ResponseDto get(@PathVariable("id") Integer id) {
        return todoService.get(id);
    }

}
