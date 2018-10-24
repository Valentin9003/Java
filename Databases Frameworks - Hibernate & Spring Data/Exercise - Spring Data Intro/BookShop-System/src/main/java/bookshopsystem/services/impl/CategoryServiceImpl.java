package bookshopsystem.services.impl;

import bookshopsystem.models.entity.Category;
import bookshopsystem.repositories.CategoryRepository;
import bookshopsystem.services.interfaces.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void saveCategoriesInToDb(List<Category> categories) {
        this.categoryRepository.save(categories);
    }

    @Override
    public List<Category> getAllCategories() {
        return this.categoryRepository.findAll();
    }
}
