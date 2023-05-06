package com.backend.store.controller;

import com.backend.store.dto.ProductDto;
import com.backend.store.facade.ProductFacade;
import com.backend.store.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductFacade productFacade;
    @GetMapping("/product")
    public ResponseEntity<Message> selectAll(){
        Message message = new Message("1","Success", "");
        List<Map<String, Object>> list = null;
        try {
            list = productFacade.selectAll();
            message.setData(list);
        } catch (Exception e) {
            message.setId("404");
            message.setMessage(e.getMessage());
        }
        return ResponseEntity.ok(message);
    }

    @GetMapping("/product/{idProduct}")
    public ResponseEntity<Message> selectId(@PathVariable Integer idProduct){
        Message message = new Message("1","Success", "");
        ProductDto product = new ProductDto();
        product.setIdProduct(idProduct);
        try {
            ProductDto productReturn = productFacade.selectId(product);
            message.setData(productReturn);
        } catch (Exception e) {
            message.setId("404");
            message.setMessage(e.getMessage());
        }
        return ResponseEntity.ok(message);
    }

    @PostMapping("/product")
    public ResponseEntity<Message> insert(@RequestBody ProductDto productDto) {
        Message message = new Message("1","Successfully created", "");
        try {
            productFacade.insert(productDto);
            message.setData(productDto);
        } catch (Exception e) {
            message.setId("404");
            message.setMessage(e.getMessage());
        }
        return ResponseEntity.ok(message);
    }

    @PutMapping("/product")
    public ResponseEntity<Message> update(@RequestBody ProductDto productDto){
        Message message = new Message("1","Successfully updated", "");
        try {
            productFacade.update(productDto);
            message.setData(productDto);
        } catch (Exception e) {
            message.setId("404");
            message.setMessage(e.getMessage());
        }
        return ResponseEntity.ok(message);
    }

    @DeleteMapping("/product")
    public ResponseEntity<Message> delete(@RequestBody ProductDto productDto){
        Message message = new Message("1","Successfully eliminated", "");
        try {
            productFacade.delete(productDto);
            message.setData(productDto);
        } catch (Exception e) {
            message.setId("404");
            message.setMessage(e.getMessage());
        }
        return ResponseEntity.ok(message);
    }
}
