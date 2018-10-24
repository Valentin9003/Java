package app.retake.parser;

import app.retake.parser.interfaces.ModelParser;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public final class ModelParserImpl implements ModelParser {

    private final ModelMapper modelMapper;

    public ModelParserImpl() {
        this.modelMapper = new ModelMapper();
    }

    @Override
    public <S, D> D convert(S source, Class<D> destinationClass) {
        return modelMapper.map(source, destinationClass);
    }

    @Override
    public <S, D> D convert(S source, Class<D> destinationClass, PropertyMap<S, D> propertyMap) {
        modelMapper.addMappings(propertyMap);
        return this.convert(source, destinationClass);
    }

    public <S, D> List<D> convert(Iterable<S> source, Class<D> destinationClass) {
        List<D> resultList = new ArrayList<>();
        for (S s : source) {
            D d = convert(s, destinationClass);
            resultList.add(d);
        }
        return resultList;
    }

    public <S, D> Set<D> convertToSet(Iterable<S> sourceIter, Class<D> destinationClass) {
        Set<D> resultSet = new HashSet<>();
        for (S s : sourceIter) {
            D d = convert(s, destinationClass);
            resultSet.add(d);
        }

        return resultSet;
    }
}
