package co.com.sofka.crud.ToDoList;

import co.com.sofka.crud.TodoDTO.DTOlistTodo;
import co.com.sofka.crud.TodoDTO.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListTodoService {

    private ListTodoService listTodoService;
    @Autowired
    private ListTodoRepository newRepository;

    public ResponseDto list() {
        return  new ResponseDto(newRepository.findAll());
    }

    public ResponseDto save(DTOlistTodo dtOlistTodo) {

        ListTodo listTodo = new ListTodo();
        listTodo.setNewId(dtOlistTodo.getNewId());
        listTodo.setNewName(dtOlistTodo.getNewName());

      /*  ListTodo lista1 = new ListTodo();
        lista1.setNewName(dtOlistTodo.getNewName());*/

        listTodo = newRepository.save(listTodo);
        /*return newRepository.save(lista1);*/

        return new ResponseDto(listTodo, "Se ha actualizado correctamente");
    }

    public void delete(Long newId) {
        newRepository.delete(get(newId));
    }

    public ListTodo get(Long newId) {
        return newRepository.findById(newId).orElseThrow();
    }

}
