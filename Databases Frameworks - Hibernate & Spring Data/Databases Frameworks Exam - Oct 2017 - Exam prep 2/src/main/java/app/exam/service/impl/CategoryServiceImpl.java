package app.exam.service.impl;

import app.exam.domain.dto.xml.CategoriesFrequentItemsXMLExportDTO;
import app.exam.domain.entities.Category;
import app.exam.parser.interfaces.ModelParser;
import app.exam.repository.CategoryRepository;
import app.exam.service.api.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelParser modelParser;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository,
                               ModelParser modelParser) {
        this.categoryRepository = categoryRepository;
        this.modelParser = modelParser;
    }

    @Override
    public CategoriesFrequentItemsXMLExportDTO getCategoriesWithMostPopularItems(List<String> categoryNames) {
        return null;
    }

    @Override
    public Category oneByName(String name) {
        return this.categoryRepository.findByName(name);
    }

    @Override
    public void create(Category category) {
        this.categoryRepository.saveAndFlush(category);
    }
}
