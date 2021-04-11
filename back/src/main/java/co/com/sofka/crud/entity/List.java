package co.com.sofka.crud.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name = "list")
@Entity()
public class List {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 15, nullable = false)
    private String name;

    @OneToMany(mappedBy = "list")
    private Set<Todo> todoList = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Todo> getTodoList() {
        return todoList;
    }

    public void setTodoList(Set<Todo> todoList) {
        this.todoList = todoList;
    }

    public void addTodoList(Todo todo) {
        this.todoList.add(todo);

    }
}
