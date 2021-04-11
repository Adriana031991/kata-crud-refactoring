package co.com.sofka.crud.service;

import co.com.sofka.crud.dto.ResponseDto;
import co.com.sofka.crud.dto.TodoDto;
import co.com.sofka.crud.entity.List;
import co.com.sofka.crud.entity.Todo;
import co.com.sofka.crud.exception.ValidationException;
import co.com.sofka.crud.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public ResponseDto todo() {
        return new ResponseDto(todoRepository.findAll(), "probando ejercicios");
    }


    public ResponseDto saveTodo(TodoDto todoDto){
        //creacion y actualizacion de tareas

        Todo todo = new Todo();
        todo.setName(todoDto.getName());

        List list = new List();
        list.setId(todoDto.getList().getId());
        list.setName(todoDto.getList().getName());

        todo.setList(list);
        todoRepository.save(todo);

        return new ResponseDto("Se ha creado todo");
    }


    public ResponseDto updateTodo(TodoDto todoDto){
        //actualizacion de tareas
        if(todoDto.getId() ==null)
            throw new ValidationException("Debe especificar el todo a actualizar");

        if(todoDto.getList() ==null)
            throw new ValidationException("Debe especificar la lista de todo a actualizar");

        if(todoDto.getList().getId() == null)
            throw new ValidationException("Debe especificar el id de la lista de todo a actualizar");

        if(todoRepository.findById(todoDto.getId()).isEmpty())
            throw new ValidationException("El todo a actualizar no existe");


        Todo todo = new Todo();
        todo.setId(todoDto.getId());
        todo.setName(todoDto.getName());
        todo.setCompleted(todoDto.isCompleted());

        List list = new List();
        list.setId(todoDto.getList().getId());
        list.setName(todoDto.getList().getName());

        todo.setList(list);
        todoRepository.save(todo);

        return new ResponseDto("Se ha actualizado todo");
    }


    public ResponseDto deleteById(Integer id){
        todoRepository.deleteById(id);
        return new ResponseDto("ListTodo eliminado correctamente");

    }

    public ResponseDto get(Integer id) {

        return new ResponseDto(todoRepository.findById(id).orElseThrow(()->{
            throw new ValidationException("El todo a consultar no existe");
        }));
    }

}
