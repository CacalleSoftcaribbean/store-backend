package com.backend.store.controller;

import com.backend.store.dto.PurchaseDetailDto;
import com.backend.store.facade.PurchaseDetailFacade;
import com.backend.store.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class PurchaseDetailController {
    @Autowired
    private PurchaseDetailFacade purchaseDetailFacade;

    @GetMapping("/purchase-detail")
    public ResponseEntity<Message> selectAll(){
        Message message = new Message("1","Success", "");
        List<Map<String, Object>> list = null;
        try {
            list = purchaseDetailFacade.selectAll();
            message.setData(list);
        } catch (Exception e) {
            message.setId("404");
            message.setMessage(e.getMessage());
        }
        return ResponseEntity.ok(message);
    }

    @GetMapping("/purchase-detail/{idPurchaseDetail}")
    public ResponseEntity<Message> selectId(@PathVariable Integer idPurchaseDetail){
        Message message = new Message("1","Success", "");
        PurchaseDetailDto purchaseDetail = new PurchaseDetailDto();
        purchaseDetail.setIdPurchaseDetail(idPurchaseDetail);
        try {
            PurchaseDetailDto purchaseDetailReturn = purchaseDetailFacade.selectId(purchaseDetail);
            message.setData(purchaseDetailReturn);
        } catch (Exception e) {
            message.setId("404");
            message.setMessage(e.getMessage());
        }
        return ResponseEntity.ok(message);
    }

    @PostMapping("/purchase-detail")
    public ResponseEntity<Message> insert(@RequestBody PurchaseDetailDto purchaseDetailDto) {
        Message message = new Message("1","Successfully created", "");
        try {
            purchaseDetailFacade.insert(purchaseDetailDto);
            message.setData(purchaseDetailDto);
        } catch (Exception e) {
            message.setId("404");
            message.setMessage(e.getMessage());
        }
        return ResponseEntity.ok(message);
    }

    @PutMapping("/purchase-detail")
    public ResponseEntity<Message> update(@RequestBody PurchaseDetailDto purchaseDetailDto){
        Message message = new Message("1","Successfully updated", "");
        try {
            purchaseDetailFacade.update(purchaseDetailDto);
            message.setData(purchaseDetailDto);
        } catch (Exception e) {
            message.setId("404");
            message.setMessage(e.getMessage());
        }
        return ResponseEntity.ok(message);
    }

    @DeleteMapping("/purchase-detail")
    public ResponseEntity<Message> delete(@RequestBody PurchaseDetailDto purchaseDetailDto){
        Message message = new Message("1","Successfully eliminated", "");
        try {
            purchaseDetailFacade.delete(purchaseDetailDto);
            message.setData(purchaseDetailDto);
        } catch (Exception e) {
            message.setId("404");
            message.setMessage(e.getMessage());
        }
        return ResponseEntity.ok(message);
    }
}
