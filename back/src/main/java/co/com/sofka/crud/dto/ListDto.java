package co.com.sofka.crud.dto;

import java.util.HashSet;
import java.util.Set;

public class ListDto {

    private Integer id;
    private String name;

    private Set<TodoDto> todoList = new HashSet<>();

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

    public Set<TodoDto> getTodoList() {
        return todoList;
    }

    public void setTodoList(Set<TodoDto> todoList) {
        this.todoList = todoList;
    }
}
