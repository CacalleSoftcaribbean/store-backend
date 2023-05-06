package com.backend.store.controller;

import com.backend.store.dto.PurchaseDto;
import com.backend.store.facade.PurchaseFacade;
import com.backend.store.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class PurchaseController {
    @Autowired
    private PurchaseFacade purchaseFacade;

    @GetMapping("/purchase")
    public ResponseEntity<Message> selectAll(){
        Message message = new Message("1","Success", "");
        List<Map<String, Object>> list = null;
        try {
            list = purchaseFacade.selectAll();
            message.setData(list);
        } catch (Exception e) {
            message.setId("404");
            message.setMessage(e.getMessage());
        }
        return ResponseEntity.ok(message);
    }

    @GetMapping("/purchase/{idPurchase}")
    public ResponseEntity<Message> selectId(@PathVariable Integer idPurchase){
        Message message = new Message("1","Success", "");
        PurchaseDto purchase = new PurchaseDto();
        purchase.setIdPurchase(idPurchase);
        try {
            PurchaseDto purchaseReturn = purchaseFacade.selectId(purchase);
            message.setData(purchaseReturn);
        } catch (Exception e) {
            message.setId("404");
            message.setMessage(e.getMessage());
        }
        return ResponseEntity.ok(message);
    }

    @PostMapping("/purchase")
    public ResponseEntity<Message> insert(@RequestBody PurchaseDto purchaseDto) {
        Message message = new Message("1","Successfully created", "");
        try {
            purchaseFacade.insert(purchaseDto);
            message.setData(purchaseDto);
        } catch (Exception e) {
            message.setId("404");
            message.setMessage(e.getMessage());
        }
        return ResponseEntity.ok(message);
    }

    @PutMapping("/purchase")
    public ResponseEntity<Message> update(@RequestBody PurchaseDto purchaseDto){
        Message message = new Message("1","Successfully updated", "");
        try {
            purchaseFacade.update(purchaseDto);
            message.setData(purchaseDto);
        } catch (Exception e) {
            message.setId("404");
            message.setMessage(e.getMessage());
        }
        return ResponseEntity.ok(message);
    }

    @DeleteMapping("/purchase")
    public ResponseEntity<Message> delete(@RequestBody PurchaseDto purchaseDto){
        Message message = new Message("1","Successfully eliminated", "");
        try {
            purchaseFacade.delete(purchaseDto);
            message.setData(purchaseDto);
        } catch (Exception e) {
            message.setId("404");
            message.setMessage(e.getMessage());
        }
        return ResponseEntity.ok(message);
    }

}
