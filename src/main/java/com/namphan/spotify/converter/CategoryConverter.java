package com.namphan.spotify.converter;

import com.namphan.spotify.dto.CategoryDTO;
import com.namphan.spotify.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter {
    public CategoryDTO toCategoryDTO(Category category) {


        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setCategoryId(category.getCategoryId());
        categoryDTO.setCategoryName(category.getCategoryName());
        return categoryDTO;
    }

    public Category toCategory(CategoryDTO categoryDTO) {


        Category category = new Category();
        category.setCategoryId(categoryDTO.getCategoryId());
        category.setCategoryName(categoryDTO.getCategoryName());
        return category;
    }
}
