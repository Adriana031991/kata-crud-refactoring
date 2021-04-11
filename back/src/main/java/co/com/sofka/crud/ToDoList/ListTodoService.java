package co.com.sofka.crud.ToDoList;

import co.com.sofka.crud.TodoDTO.DTOlistTodo;
import co.com.sofka.crud.TodoDTO.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListTodoService {

    @Autowired
    private ListTodoRepository newRepository;

    public ResponseDto list() {
        return  new ResponseDto(newRepository.findAll());
    }

    public ResponseDto save(DTOlistTodo dtOlistTodo) {

        ListTodo listTodo = new ListTodo();
        listTodo.setNewId(dtOlistTodo.getId());
        listTodo.setNewName(dtOlistTodo.getName());
        listTodo = newRepository.save(listTodo);

        return new ResponseDto(listTodo, "Se ha actualizado correctamente");
    }

    public void delete(Long newId) {
        newRepository.delete(get(newId));
    }

    public ListTodo get(Long newId) {
        return newRepository.findById(newId).orElseThrow();
    }

}
