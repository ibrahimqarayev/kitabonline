package com.mycompany.kitabonline.service;

import com.mycompany.kitabonline.dto.CategoryType;
import com.mycompany.kitabonline.entity.Category;
import com.mycompany.kitabonline.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public Category loadCategory(Long id) {
        return categoryRepository.findById(id).orElseThrow();
    }

    public Category findByName(String name) {
        return categoryRepository.findByName(name).orElseThrow(RuntimeException::new);
    }

}
