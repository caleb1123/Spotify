package com.namphan.spotify.controller;

import com.namphan.spotify.model.dto.CategoryDTO;
import com.namphan.spotify.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @GetMapping("all")
    public ResponseEntity<List<CategoryDTO>> getAllCategories() {
        List<CategoryDTO> categoryDTOList = categoryService.getAllCategory();
        if (!categoryDTOList.isEmpty()) {
            return new ResponseEntity<>(categoryDTOList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
