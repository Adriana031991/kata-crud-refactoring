import React, { useContext, useEffect, useState } from 'react';
import todoConsumer from "./toDoConsumer";
import events from "./toDoEvents";
import Store from "../Store"


export default ({ listId, todo }) => {
    const { dispatch } = useContext(Store);
    const [isLoaded, setLoaded] = useState(false);
    //compartiendo los estados
    const list = todo.elements.filter((element) => {
        return element.listId === listId;
    });

    useEffect(() => {
        todoConsumer.findAll(listId).then((response) => {
            if (response.ok) {
                response.json().then((items) => {
                    console.log("successful toDo");
                    setLoaded(true);
                    dispatch(events.finded(listId, items));
                })
            }
        });
    }, [listId, dispatch]);

    const onDelete = (itemId) => {
        todoConsumer.delete(itemId).then((response) => {
            if (response.ok) {
                dispatch(events.deleted(listId, itemId));
            }
        })
    };
    //este onedit es solo visual (el elemento obtiene el elemento)
    const onEdit = (item) => {
        dispatch(events.onEdited(listId, item))
    };

    const onChange = (event, item) => {
        const request = {
            name: item.name,
            id: item.id,
            completed: event.target.checked//lo unico que cambia es el estado del checkbox
        };
        //esta parte actualiza el checkbox
        todoConsumer.update(listId, request).then((response) => {
            if (response.ok) {
                response.json().then(() => {
                    dispatch(events.update(listId, request));
                })
            }
        });
    };
    const decorationDone = {
        TextDecoration: "line-throught",
        color: '#c3c3c3'
    }


    return <div>
        {!isLoaded && <div>Loading...</div>}
        <table >
            <thead>
                <tr>
                    <td>ID</td>
                    <td>Tarea</td>
                    <td>¿Completado?</td>
                </tr>
            </thead>
            <tbody>
                {list.map((todo) => {
                    return <tr key={todo.id} style={todo.completed ? decorationDone : {}}>
                        <td>{todo.id}</td>
                        <td>{todo.name}</td>
                        <td><input type="checkbox" defaultChecked={todo.completed} onChange={(event) => onChange(event, todo)}></input></td>
                        <td><button onClick={() => onDelete(todo.id)}>Eliminar</button></td>
                        <td><button disbled={todo.completed} onClick={() => onEdit(todo)}>Editar</button></td>
                        {/* esta ultima  dice que habilita el edit si no esta completado*/}
                    </tr>
                })}
            </tbody>
        </table>
    </div>
}
