package com.backend.store.controller;

import com.backend.store.dto.PersonDto;
import com.backend.store.facade.PersonFacade;
import com.backend.store.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class PersonController {
    @Autowired
    private PersonFacade personFacade;

    @GetMapping ("/person")
    public ResponseEntity<Message> selectAll(){
        Message message = new Message("1","Success", "");
        List<Map<String, Object>> list = null;
        try {
            list = personFacade.selectAll();
            message.setData(list);
        } catch (Exception e) {
            message.setId("404");
            message.setMessage(e.getMessage());
        }
        return ResponseEntity.ok(message);
    }

    @GetMapping("/person/{idPerson}")
    public ResponseEntity<Message> selectId(@PathVariable Integer idPerson){
        Message message = new Message("1","Success", "");
        PersonDto person = new PersonDto();
        person.setIdPerson(idPerson);
        try {
            PersonDto personReturn = personFacade.selectId(person);
            message.setData(personReturn);
        } catch (Exception e) {
            message.setId("404");
            message.setMessage(e.getMessage());
        }
        return ResponseEntity.ok(message);
    }

    @PostMapping("/person")
    public ResponseEntity<Message> insert(@RequestBody PersonDto personDto) {
        Message message = new Message("1","Successfully created", "");
        try {
            personFacade.insert(personDto);
            message.setData(personDto);
        } catch (Exception e) {
            message.setId("404");
            message.setMessage(e.getMessage());
        }
        return ResponseEntity.ok(message);
    }

    @PutMapping("/person")
    public ResponseEntity<Message> update(@RequestBody PersonDto personDto){
        Message message = new Message("1","Successfully updated", "");
        try {
            personFacade.update(personDto);
            message.setData(personDto);
        } catch (Exception e) {
            message.setId("404");
            message.setMessage(e.getMessage());
        }
        return ResponseEntity.ok(message);
    }

    @DeleteMapping ("/person")
    public ResponseEntity<Message> delete(@RequestBody PersonDto personDto){
        Message message = new Message("1","Successfully eliminated", "");
        try {
            personFacade.delete(personDto);
            message.setData(personDto);
        } catch (Exception e) {
            message.setId("404");
            message.setMessage(e.getMessage());
        }
        return ResponseEntity.ok(message);
    }
}
