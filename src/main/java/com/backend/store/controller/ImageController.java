package com.backend.store.controller;

import com.backend.store.dto.ImageDto;
import com.backend.store.facade.ImageFacade;
import com.backend.store.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ImageController {
    @Autowired
    private ImageFacade imageFacade;

    @GetMapping("/image")
    public ResponseEntity<Message> selectAll(){
        Message message = new Message("1","Success", "");
        List<Map<String, Object>> list = null;
        try {
            list = imageFacade.selectAll();
            message.setData(list);
        } catch (Exception e) {
            message.setId("404");
            message.setMessage(e.getMessage());
        }
        return ResponseEntity.ok(message);
    }

    @GetMapping("/image/{idImage}")
    public ResponseEntity<Message> selectId(@PathVariable Integer idImage){
        Message message = new Message("1","Success", "");
        ImageDto image = new ImageDto();
        image.setIdImage(idImage);
        try {
            ImageDto imageReturn = imageFacade.selectId(image);
            message.setData(imageReturn);
        } catch (Exception e) {
            message.setId("404");
            message.setMessage(e.getMessage());
        }
        return ResponseEntity.ok(message);
    }

    @PostMapping("/image")
    public ResponseEntity<Message> insert(@RequestBody ImageDto imageDto) {
        Message message = new Message("1","Successfully created", "");
        try {
            imageFacade.insert(imageDto);
            message.setData(imageDto);
        } catch (Exception e) {
            message.setId("404");
            message.setMessage(e.getMessage());
        }
        return ResponseEntity.ok(message);
    }

    @PutMapping("/image")
    public ResponseEntity<Message> update(@RequestBody ImageDto imageDto){
        Message message = new Message("1","Successfully updated", "");
        try {
            imageFacade.update(imageDto);
            message.setData(imageDto);
        } catch (Exception e) {
            message.setId("404");
            message.setMessage(e.getMessage());
        }
        return ResponseEntity.ok(message);
    }

    @DeleteMapping("/image")
    public ResponseEntity<Message> delete(@RequestBody ImageDto imageDto){
        Message message = new Message("1","Successfully eliminated", "");
        try {
            imageFacade.delete(imageDto);
            message.setData(imageDto);
        } catch (Exception e) {
            message.setId("404");
            message.setMessage(e.getMessage());
        }
        return ResponseEntity.ok(message);
    }
}
