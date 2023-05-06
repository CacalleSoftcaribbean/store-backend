package com.backend.store.controller;

import com.backend.store.dto.UserDto;
import com.backend.store.facade.UserFacade;
import com.backend.store.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserFacade userFacade;
    @GetMapping("/user")
    public ResponseEntity<Message> selectAll(){
        Message message = new Message("1","Success", "");
        List<Map<String, Object>> list = null;
        try {
            list = userFacade.selectAll();
            message.setData(list);
        } catch (Exception e) {
            message.setId("404");
            message.setMessage(e.getMessage());
        }
        return ResponseEntity.ok(message);
    }

    @GetMapping("/user/{idUser}")
    public ResponseEntity<Message> selectId(@PathVariable Integer idUser){
        Message message = new Message("1","Success", "");
        UserDto user = new UserDto();
        user.setIdUser(idUser);
        try {
            UserDto userReturn = userFacade.selectId(user);
            message.setData(userReturn);
        } catch (Exception e) {
            message.setId("404");
            message.setMessage(e.getMessage());
        }
        return ResponseEntity.ok(message);
    }

    @PostMapping("/address")
    public ResponseEntity<Message> insert(@RequestBody UserDto userDto) {
        Message message = new Message("1","Successfully created", "");
        try {
            userFacade.insert(userDto);
            message.setData(userDto);
        } catch (Exception e) {
            message.setId("404");
            message.setMessage(e.getMessage());
        }
        return ResponseEntity.ok(message);
    }

    @PutMapping("/address")
    public ResponseEntity<Message> update(@RequestBody UserDto userDto){
        Message message = new Message("1","Successfully updated", "");
        try {
            userFacade.update(userDto);
            message.setData(userDto);
        } catch (Exception e) {
            message.setId("404");
            message.setMessage(e.getMessage());
        }
        return ResponseEntity.ok(message);
    }

    @DeleteMapping("/address")
    public ResponseEntity<Message> delete(@RequestBody UserDto userDto){
        Message message = new Message("1","Successfully eliminated", "");
        try {
            userFacade.delete(userDto);
            message.setData(userDto);
        } catch (Exception e) {
            message.setId("404");
            message.setMessage(e.getMessage());
        }
        return ResponseEntity.ok(message);
    }
}
