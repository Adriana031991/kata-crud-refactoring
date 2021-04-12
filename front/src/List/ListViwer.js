import React, { useContext, useEffect, useState } from 'react';
import ToDoForm from "../toDo/toDoFormViwer";
import ToDoList from "../toDo/toDoListViwer";
import listConsumer from "./listConsumer";
import events from "./listEvents";
import Store from "../Store"


export default () => {
    const { state: {list, todo}, dispatch } = useContext(Store);
    const [isLoaded, setLoaded] = useState(false);
    useEffect(() => {
        listConsumer.findAll().then((response) => {
            if(response.ok) {
                response.json().then((list) => {
                    dispatch(events.finded(list));
                    console.log("successful list");
                });
            }
            setLoaded(true);
        })
    }, [dispatch]);

    const onDelete = (listId) => {
        listConsumer.delete(listId).then((response) => {
            if(response.ok) {
                dispatch(events.deleted(listId));
        }        
    })
};


    return <div>
        {!isLoaded && <div>Loading...</div>}
        {list.elements.lenght === 0 && <div>empty list!</div>}
        {list.elements.map((element) => {
            return <div key={element.id} id={"list-to-do"+element.id}>
                <fieldset>
                    <legend>
                        {element.name.toUpperCase()}
                        <button onClick={() => onDelete(element.id)}>Eliminar</button>
                    </legend>
                <ToDoForm listId={element.id} todo={todo}/>
                <ToDoList listId={element.id} todo={todo}/>
                </fieldset>
            </div>
        })}
        </div>
}
        