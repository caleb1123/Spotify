package com.namphan.spotify.service.impl;

import com.namphan.spotify.converter.CategoryConverter;
import com.namphan.spotify.dto.CategoryDTO;
import com.namphan.spotify.entity.Category;
import com.namphan.spotify.repository.CategoryRepository;
import com.namphan.spotify.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    CategoryConverter categoryConverter;
    @Override
    public List<CategoryDTO> getAllCategory() {
        List<Category> categories = categoryRepository.getAllAlbum();
        return categoryConverter.convertToCategoryDTOList(categories);
    }
}
