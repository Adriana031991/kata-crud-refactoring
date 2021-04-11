package co.com.sofka.crud.controller;

import co.com.sofka.crud.dto.ListDto;
import co.com.sofka.crud.dto.ResponseDto;
import co.com.sofka.crud.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/list")
public class ListController {

    @Autowired
    private ListService listService;

    @GetMapping()
    public ResponseDto list() {
        return listService.list();
    }

    @PostMapping()
    public ResponseDto save(@RequestBody ListDto listTodo) {
        return listService.save(listTodo);
    }

    @PutMapping()
    public ResponseDto update(@RequestBody ListDto dtOlistTodo) {
        if (dtOlistTodo.getId() != null) {
            return listService.save(dtOlistTodo);
        }
        throw new RuntimeException("No existe el id para actualziar");
    }

    @DeleteMapping(value = "/{id}")
    public ResponseDto deleteById(@PathVariable("id") Integer id) {
        return listService.deleteById(id);
    }

    @GetMapping(value = "/{id}")
    public ResponseDto get(@PathVariable("id") Integer id) {
        return listService.get(id);
    }
}
