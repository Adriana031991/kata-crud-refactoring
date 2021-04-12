import React, { useState, useContext, useRef } from 'react';
import todoConsumer from "./toDoConsumer";
import events from "./toDoEvents";
import Store from "../Store"

export default ({ listId, todo }) => {
    const formRef = useRef(null);
    const { dispatch } = useContext(Store);
    const item = todo.item[listId] ? todo.item[listId] : {};
    // dado el identificador que es la lista, vamos a obtener todos los items pero vamos a actualizar uno y si uno de ellos existe, se va a obtener el item 
    const [state, setState] = useState(item);
    //se obtiene un objeto por defecto de el estado interno[setState]
    //aqui se comparte los estados para diferentes dominios
    //buscamos separar los estados (mantenerlos aislados)


    const onAdd = (event) => {
        event.preventDefault();

        const request = {
            name: state.name,
            id: null,
            completed: false
        };

        todoConsumer.save(listId, request).then((response) => {
            if (response.ok) {
                response.json().then((result) => {
                    dispatch(events.saved(listId, result));
                    setState({ name: "" });
                    formRef.current.reset();
                });
            }
        });
    }

    const onEdit = (event) => {
        event.preventDefault();

        const request = {
            name: state.name,
            id: item.id,
            completed: item.completed
        };

        todoConsumer.update(listId, request).then((response) => {
            if (response.ok) {
                response.json().then((result) => {
                    dispatch(events.saved(listId, result));
                    setState({ name: "" });
                    formRef.current.reset();
                });
            }
        });
    }


    return <form ref={formRef}>
        <input
            type="text"
            name="name"
            placeholder="¿Qué piensas hacer hoy?"
            defaultValue={item.name}
            onChange={(event) => {
                setState({ ...state, name: event.target.value })
            }}  ></input>
        {item.id && <button onClick={onEdit}>Actualizar</button>}
        {!item.id && <button onClick={onAdd}>Crear</button>}
    </form>
};