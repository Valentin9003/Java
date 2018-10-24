package app.exam.service.impl;

import app.exam.domain.dto.json.ItemJSONImportDTO;
import app.exam.domain.entities.Category;
import app.exam.domain.entities.Item;
import app.exam.parser.interfaces.ModelParser;
import app.exam.repository.ItemsRepository;
import app.exam.service.api.CategoryService;
import app.exam.service.api.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ItemsServiceImpl implements ItemsService {

    private final ItemsRepository itemsRepository;
    private final CategoryService categoryService;
    private final ModelParser modelParser;

    @Autowired
    public ItemsServiceImpl(ItemsRepository itemsRepository,
                            CategoryService categoryService,
                            ModelParser modelParser) {
        this.itemsRepository = itemsRepository;
        this.categoryService = categoryService;
        this.modelParser = modelParser;
    }

    @Override
    public void create(ItemJSONImportDTO itemJSONImportDTO) {
        if (this.itemsRepository.findByName(itemJSONImportDTO.getName()) == null) {
            Category category = this.categoryService.oneByName(itemJSONImportDTO.getCategory());
            if (category == null) {
                category = new Category(itemJSONImportDTO.getCategory());
                this.categoryService.create(category);
            }

            Item item = this.modelParser.convert(itemJSONImportDTO, Item.class);
            item.setCategory(category);
            this.itemsRepository.saveAndFlush(item);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Item findByName(String name) {
        return this.itemsRepository.findByName(name);
    }
}
