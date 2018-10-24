package app.exam.service.api;

import app.exam.domain.dto.json.ItemJSONImportDTO;
import app.exam.domain.entities.Item;

public interface ItemsService {

    void create(ItemJSONImportDTO itemJSONImportDTO);

    Item findByName(String name);
}
