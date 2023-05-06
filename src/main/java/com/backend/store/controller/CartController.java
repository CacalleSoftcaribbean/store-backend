package com.backend.store.controller;

import com.backend.store.dto.CartDto;
import com.backend.store.facade.CartFacade;
import com.backend.store.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class CartController {
    @Autowired
    private CartFacade cartFacade;
    @GetMapping("/cart")
    public ResponseEntity<Message> selectAll(){
        Message message = new Message("1","Success", "");
        List<Map<String, Object>> list = null;
        try {
            list = cartFacade.selectAll();
            message.setData(list);
        } catch (Exception e) {
            message.setId("404");
            message.setMessage(e.getMessage());
        }
        return ResponseEntity.ok(message);
    }

    @GetMapping("/cart/{idCart}")
    public ResponseEntity<Message> selectId(@PathVariable Integer idCart){
        Message message = new Message("1","Success", "");
        CartDto cart = new CartDto();
        cart.setIdCart(idCart);
        try {
            CartDto cartReturn = cartFacade.selectId(cart);
            message.setData(cartReturn);
        } catch (Exception e) {
            message.setId("404");
            message.setMessage(e.getMessage());
        }
        return ResponseEntity.ok(message);
    }

    @PostMapping("/cart")
    public ResponseEntity<Message> insert(@RequestBody CartDto cartDto) {
        Message message = new Message("1","Successfully created", "");
        try {
            cartFacade.insert(cartDto);
            message.setData(cartDto);
        } catch (Exception e) {
            message.setId("404");
            message.setMessage(e.getMessage());
        }
        return ResponseEntity.ok(message);
    }

    @PutMapping("/cart")
    public ResponseEntity<Message> update(@RequestBody CartDto cartDto){
        Message message = new Message("1","Successfully updated", "");
        try {
            cartFacade.update(cartDto);
            message.setData(cartDto);
        } catch (Exception e) {
            message.setId("404");
            message.setMessage(e.getMessage());
        }
        return ResponseEntity.ok(message);
    }

    @DeleteMapping("/cart")
    public ResponseEntity<Message> delete(@RequestBody CartDto cartDto){
        Message message = new Message("1","Successfully eliminated", "");
        try {
            cartFacade.delete(cartDto);
            message.setData(cartDto);
        } catch (Exception e) {
            message.setId("404");
            message.setMessage(e.getMessage());
        }
        return ResponseEntity.ok(message);
    }
}
