package co.com.sofka.crud.Service;

import co.com.sofka.crud.Entity.ListTodo;
import co.com.sofka.crud.Repository.ListTodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListTodoService {

    @Autowired
    private ListTodoRepository newRepository;

    public Iterable<ListTodo> list(){
        return newRepository.findAll();
    }

    public ListTodo save(ListTodo newTodo){
        return newRepository.save(newTodo);
    }

    public void delete(Long newId){
        newRepository.delete(get(newId));
    }

    public ListTodo get(Long newId){
        return newRepository.findById(newId).orElseThrow();
    }

}
