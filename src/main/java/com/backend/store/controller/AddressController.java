package com.backend.store.controller;

import com.backend.store.dto.AddressDto;
import com.backend.store.facade.AddressFacade;
import com.backend.store.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class AddressController {
    @Autowired
    private AddressFacade addressFacade;

    @GetMapping("/address/selectAll")
    public ResponseEntity<Message> selectAll(){
        Message message = new Message("1","Success", "");
        List<Map<String, Object>> list = null;
        try {
            list = addressFacade.selectAll();
            message.setData(list);
        } catch (Exception e) {
            message.setId("404");
            message.setMessage(e.getMessage());
        }
        return ResponseEntity.ok(message);
    }

    @GetMapping("/address/selectId/{idAddress}")
    public ResponseEntity<Message> selectId(@PathVariable Integer idAddress){
        Message message = new Message("1","Success", "");
        AddressDto address = new AddressDto();
        address.setIdAddress(idAddress);
        try {
            AddressDto addressReturn = addressFacade.selectId(address);
            message.setData(addressReturn);
        } catch (Exception e) {
            message.setId("404");
            message.setMessage(e.getMessage());
        }
        return ResponseEntity.ok(message);
    }

    @PostMapping("/address/insertAddress")
    public ResponseEntity<Message> insert(@RequestBody AddressDto addressDto) {
        Message message = new Message("1","Successfully created", "");
        try {
            addressFacade.insert(addressDto);
            message.setData(addressDto);
        } catch (Exception e) {
            message.setId("404");
            message.setMessage(e.getMessage());
        }
        return ResponseEntity.ok(message);
    }

    @PostMapping("/address/update")
    public ResponseEntity<Message> update(@RequestBody AddressDto addressDto){
        Message message = new Message("1","Successfully updated", "");
        try {
            addressFacade.update(addressDto);
            message.setData(addressDto);
        } catch (Exception e) {
            message.setId("404");
            message.setMessage(e.getMessage());
        }
        return ResponseEntity.ok(message);
    }

    @PostMapping("/address/delete")
    public ResponseEntity<Message> delete(@RequestBody AddressDto addressDto){
        Message message = new Message("1","Successfully eliminated", "");
        try {
            addressFacade.delete(addressDto);
            message.setData(addressDto);
        } catch (Exception e) {
            message.setId("404");
            message.setMessage(e.getMessage());
        }
        return ResponseEntity.ok(message);
    }
}
