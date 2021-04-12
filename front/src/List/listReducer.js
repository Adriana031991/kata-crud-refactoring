import {actionType } from './listEvents'
/* se basa en un mapa no en un switch. donde cada propiedad es el tipo de acicon dado del dominio. tiene una funcion pura de cada elemento tipado ([actionType.LIST_FINDED][actionType.LIST_CREATED][actionType.LIST_DELETE])
*/

export default () => {
    const action = {};

    action[actionType.LIST_FINDED] = (state, action) => {
        return { ...state, list: {elements: action.list}}
    };

    action[actionType.LIST_CREATED] = (state, action) => {
        const list = state.list.elements;
        list.push(action.item);
        return {...state, list: {elements: list}};
    };

    action[actionType.LIST_DELETE] = (state, action) => {
        const list = state.list.elements.filter((element) => {
            return element.id !== action.listId;
        });
        return {...state, list: {elements: list}};
    };
    return action;
}
