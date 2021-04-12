
import React from 'react';
import { StoreProvider } from "./Store";
import ListView from "./List/ListViwer";
import FormView from "./toDo/toDoFormViwer";

function App() {
    return <StoreProvider>
        <div className="title">
            <h3>Dashboard</h3>
        </div>
        <div className="container">
            <div className="content">
                <FormView />
                <ListView />
            </div>
        </div>
    </StoreProvider>
}

export default App;