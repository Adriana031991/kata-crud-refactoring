export const actionType = {
    LIST_CREATED: "item.LIST_CREATED",
    LIST_FINDED: "item.LIST_FINDED",
    LIST_DELETE: "item.LIST_DELETE",
    LIST_UPDATE: "item.LIST_UPDATE",
    LIST_ON_EDITED: "item.LIST_ON_EDITED"
};

export default {
    saved : (listId, item) => ({type: actionType.LIST_CREATED, item, listId}),
    finded : (listId, items) => ({type: actionType.LIST_FINDED, listId, items}),
    deleted : (listId, itemId) => ({type: actionType.LIST_DELETE, itemId, listId}),
    update: (listId, item) => ({type: actionType.LIST_ON_EDITED, item, listId}),
    onEdited: (listId, item) => ({type: actionType.LIST_ON_EDITED, item, listId})
};

//la accion onEdited hace persistencia de la tera (es decir, que el todo seleciconado se muestre(persista) en el espacio de creacion de todos para poder ser editado- que el usuario lo vea)