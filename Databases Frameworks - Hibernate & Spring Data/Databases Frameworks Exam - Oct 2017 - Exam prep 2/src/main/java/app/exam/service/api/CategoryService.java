package app.exam.service.api;

import app.exam.domain.dto.xml.CategoriesFrequentItemsXMLExportDTO;
import app.exam.domain.entities.Category;

import java.util.List;

public interface CategoryService {

    CategoriesFrequentItemsXMLExportDTO getCategoriesWithMostPopularItems(List<String> categoryNames);

    Category oneByName(String name);

    void create (Category category);
}
