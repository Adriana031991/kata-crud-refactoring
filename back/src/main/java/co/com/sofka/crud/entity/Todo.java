package co.com.sofka.crud.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Table(name = "todo")
@Entity()
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 15, nullable = false)
    private String name;

    @Column(columnDefinition = "0")
    private boolean completed;

    @JsonBackReference
    @ManyToOne(targetEntity = List.class)
    private List list;

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

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
