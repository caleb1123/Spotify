package com.namphan.spotify.converter;

import com.namphan.spotify.dto.AlbumDTO;
import com.namphan.spotify.dto.CategoryDTO;
import com.namphan.spotify.entity.Album;
import com.namphan.spotify.entity.Category;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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
    public List<CategoryDTO> convertToCategoryDTOList(List<Category> categories) {
        List<CategoryDTO> categoryDTOList = new ArrayList<>();
        for (Category category : categories) {
            categoryDTOList.add(toCategoryDTO(category));
        }
        return categoryDTOList;
    }
}
