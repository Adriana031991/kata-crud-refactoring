import React, { useState, useContext, useRef } from 'react';
import listConsumer from "./listConsumer";
import events from "./listEvents";
import Store from "../store"

export default () => {
    const formRef = useRef(null);
    const { dispatch } = useContext(Store);
    const [state, setState] = useState({name: ""});

    const onCreate = (event) => {
        event.preventDefault();
        listConsumer.save({ name: state.name, id: null})
        .then((response) => {
            if (response.ok){
                response.json().then((newList) => {
                    dispatch(events.saved(newList));
                    formRef.current.reset();
                    setState({name: ""})
                })
            }
        });
    };

    return <form ref={formRef}>
        <input
            type="text"
            name="name"
            placeholder="Lista de TO-DO"
            onChange={(event) => {
                setState({ name: event.target.value })
            }}  ></input>
        <button onClick={onCreate}>Crear Nueva Lista</button>
    </form>
};