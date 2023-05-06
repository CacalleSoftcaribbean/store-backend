package com.backend.store.controller;

import com.backend.store.dto.RolDto;
import com.backend.store.facade.RolFacade;
import com.backend.store.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class RolController {
    @Autowired
    private RolFacade rolFacade;

    @GetMapping("/rol")
    public ResponseEntity<Message> selectAll(){
        Message message = new Message("1","Success", "");
        List<Map<String, Object>> list = null;
        try {
            list = rolFacade.selectAll();
            message.setData(list);
        } catch (Exception e) {
            message.setId("404");
            message.setMessage(e.getMessage());
        }
        return ResponseEntity.ok(message);
    }

    @GetMapping("/rol/{idRol}")
    public ResponseEntity<Message> selectId(@PathVariable Integer idRol){
        Message message = new Message("1","Success", "");
        RolDto rol = new RolDto();
        rol.setIdRol(idRol);
        try {
            RolDto rolReturn = rolFacade.selectId(rol);
            message.setData(rolReturn);
        } catch (Exception e) {
            message.setId("404");
            message.setMessage(e.getMessage());
        }
        return ResponseEntity.ok(message);
    }

    @PostMapping("/rol")
    public ResponseEntity<Message> insert(@RequestBody RolDto rolDto) {
        Message message = new Message("1","Successfully created", "");
        try {
            rolFacade.insert(rolDto);
            message.setData(rolDto);
        } catch (Exception e) {
            message.setId("404");
            message.setMessage(e.getMessage());
        }
        return ResponseEntity.ok(message);
    }

    @PutMapping("/rol")
    public ResponseEntity<Message> update(@RequestBody RolDto rolDto){
        Message message = new Message("1","Successfully updated", "");
        try {
            rolFacade.update(rolDto);
            message.setData(rolDto);
        } catch (Exception e) {
            message.setId("404");
            message.setMessage(e.getMessage());
        }
        return ResponseEntity.ok(message);
    }

    @DeleteMapping("/rol")
    public ResponseEntity<Message> delete(@RequestBody RolDto rolDto){
        Message message = new Message("1","Successfully eliminated", "");
        try {
            rolFacade.delete(rolDto);
            message.setData(rolDto);
        } catch (Exception e) {
            message.setId("404");
            message.setMessage(e.getMessage());
        }
        return ResponseEntity.ok(message);
    }
}
