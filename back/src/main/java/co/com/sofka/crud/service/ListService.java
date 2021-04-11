package co.com.sofka.crud.service;


import co.com.sofka.crud.dto.ListDto;
import co.com.sofka.crud.dto.ResponseDto;
import co.com.sofka.crud.entity.List;
import co.com.sofka.crud.repository.ListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListService {


    @Autowired
    private ListRepository listRepository;

    public ResponseDto list() {
        return new ResponseDto(listRepository.findAll(), "probando ejercicios");
    }

    public ResponseDto save(ListDto listDto) {

        List list = new List();
        list.setId(listDto.getId());
        list.setName(listDto.getName());


        list = listRepository.save(list);

        return new ResponseDto(list, "Se ha creado la lista correctamente");
    }

    public ResponseDto delete(ListDto listDto) {
        List list = new List();
        list.setId(listDto.getId());
        listRepository.delete(list);
        return new ResponseDto("ListTodo eliminado correctamente");
    }

    public ResponseDto deleteById(Integer id){
        listRepository.deleteById(id);
        return new ResponseDto("ListTodo eliminado correctamente");

    }

    public ResponseDto get(Integer id) {

        return new ResponseDto(listRepository.findById(id).orElseThrow());
    }

}
