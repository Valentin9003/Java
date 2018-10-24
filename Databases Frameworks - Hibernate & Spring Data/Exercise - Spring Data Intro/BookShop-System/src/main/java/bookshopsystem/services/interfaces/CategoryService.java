package bookshopsystem.services.interfaces;

import bookshopsystem.models.entity.Category;

import java.util.List;

public interface CategoryService {

    void saveCategoriesInToDb(List<Category> categories);

    List<Category> getAllCategories();
}
