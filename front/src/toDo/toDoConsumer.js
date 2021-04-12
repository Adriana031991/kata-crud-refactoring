//relacion CRUD EN SI
const HOST_API = window._env.HOST_API || "http://localhost:8080/api/" 
export default {
    //encuentralos todos, sino los encuentra captura y muestra el error
    findAll: async () => {
        return fetch(HOST_API + "todo")
        .catch(error => console.error('Error:', error))
    },

    save: async (listId, request) => {
        return fetch(HOST_API+ listId+"todo", {
            method: "post",
            body: JSON.stringify(request),
            headers: {
                'Content-Type': 'aplication/json'
            }
        })
        .catch(error => console.error('Error:', error))
    },

    update: async (listId, request) => {
        return fetch(HOST_API+ listId+"todo", {
            method: "put",
            body: JSON.stringify(request),
            headers: {
                'Content-Type': 'aplication/json'
            }
        })
        .catch(error => console.error('Error:', error))
    },

    delete: async (listId) => {
        return fetch(HOST_API + listId+ "list", {
            method: "delete",
            headers:{
                'Content-Type': 'aplication/json'
            }
        })
        .catch(error => console.error('Error:', error));
    }
};