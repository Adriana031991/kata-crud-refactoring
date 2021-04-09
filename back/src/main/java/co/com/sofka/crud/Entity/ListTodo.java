package co.com.sofka.crud.Entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ListTodo {
    @Id
    @GeneratedValue
    private String newId;
    private String newName;
    private boolean newCompleted;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ListTodo> Todo;

    public String getNewId() {
        return newId;
    }

    public void setNewId(String newId) {
        this.newId = newId;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public boolean isNewCompleted() {
        return newCompleted;
    }

    public void setNewCompleted(boolean newCompleted) {
        this.newCompleted = newCompleted;
    }
}
