package com.backend.store.controller;

import com.backend.store.dto.CategoryDto;
import com.backend.store.facade.CategoryFacade;
import com.backend.store.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class CategoryController {
    @Autowired
    private CategoryFacade categoryFacade;
    @GetMapping("/category")
    public ResponseEntity<Message> selectAll(){
        Message message = new Message("1","Success", "");
        List<Map<String, Object>> list = null;
        try {
            list = categoryFacade.selectAll();
            message.setData(list);
        } catch (Exception e) {
            message.setId("404");
            message.setMessage(e.getMessage());
        }
        return ResponseEntity.ok(message);
    }

    @GetMapping("/category/{idCategory}")
    public ResponseEntity<Message> selectId(@PathVariable Integer idCategory){
        Message message = new Message("1","Success", "");
        CategoryDto category = new CategoryDto();
        category.setIdCategory(idCategory);
        try {
            CategoryDto categoryReturn = categoryFacade.selectId(category);
            message.setData(categoryReturn);
        } catch (Exception e) {
            message.setId("404");
            message.setMessage(e.getMessage());
        }
        return ResponseEntity.ok(message);
    }

    @PostMapping("/category")
    public ResponseEntity<Message> insert(@RequestBody CategoryDto categoryDto) {
        Message message = new Message("1","Successfully created", "");
        try {
            categoryFacade.insert(categoryDto);
            message.setData(categoryDto);
        } catch (Exception e) {
            message.setId("404");
            message.setMessage(e.getMessage());
        }
        return ResponseEntity.ok(message);
    }

    @PutMapping("/category")
    public ResponseEntity<Message> update(@RequestBody CategoryDto categoryDto){
        Message message = new Message("1","Successfully updated", "");
        try {
            categoryFacade.update(categoryDto);
            message.setData(categoryDto);
        } catch (Exception e) {
            message.setId("404");
            message.setMessage(e.getMessage());
        }
        return ResponseEntity.ok(message);
    }

    @DeleteMapping("/category")
    public ResponseEntity<Message> delete(@RequestBody CategoryDto categoryDto){
        Message message = new Message("1","Successfully eliminated", "");
        try {
            categoryFacade.delete(categoryDto);
            message.setData(categoryDto);
        } catch (Exception e) {
            message.setId("404");
            message.setMessage(e.getMessage());
        }
        return ResponseEntity.ok(message);
    }
}
