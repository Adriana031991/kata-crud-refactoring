package co.com.sofka.crud.ToDoList;

import co.com.sofka.crud.ToDo.Todo;
import org.hibernate.boot.model.relational.Sequence;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ListTodo {

    @Id
    @GeneratedValue
    private Long newId;
    private String newName;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Todo> listSubTodo;

    public void listSubTodo(Set<Todo> listSubTodo) {
        this.listSubTodo = listSubTodo;
    }

    public Long getNewId() {
        return newId;
    }

    public void setNewId(Long newId) {
        this.newId = newId;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }


}
