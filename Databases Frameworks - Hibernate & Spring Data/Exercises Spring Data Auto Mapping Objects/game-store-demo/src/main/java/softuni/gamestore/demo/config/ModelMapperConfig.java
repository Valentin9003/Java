package softuni.gamestore.demo.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import softuni.gamestore.demo.model.dto.binding.AddGameBindingModel;
import softuni.gamestore.demo.model.entity.Game;

public class ModelMapperConfig {

    private final ModelMapper modelMapper;

    public ModelMapperConfig(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.initialize();
    }

    private void initialize() {
        this.gamesAddingMapping();
    }

    private void gamesAddingMapping() {
        PropertyMap<AddGameBindingModel, Game> orderMap = new PropertyMap<AddGameBindingModel, Game>() {
            @Override
            protected void configure() {
                map().setTitle(source.getTitle());
                map().setPrice(source.getPrice());
                map().setSize(source.getSize());
                map().setYoutobeId(source.getYoutobeId());
                map().setImageUrl(source.getImageUrl());
                map().setDescription(source.getDescription());
                map().setReleaseDate(source.getReleaseDate());
            }
        };
        modelMapper.addMappings(orderMap);
    }
}
