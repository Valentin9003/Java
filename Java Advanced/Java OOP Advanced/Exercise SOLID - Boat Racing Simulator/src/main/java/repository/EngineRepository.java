package repository;

import Utility.Constants;
import contracts.Engine;
import contracts.Repository;
import exeptions.DuplicateModelException;
import exeptions.NonExistentModelException;

import java.util.LinkedHashMap;
import java.util.Map;

public class EngineRepository implements Repository<Engine> {

    private Map<String, Engine> engines;

    public EngineRepository() {
        this.engines = new LinkedHashMap<>();
    }

    @Override
    public void add(Engine item) throws DuplicateModelException {
        if (this.engines.containsKey(item.getModel())) {
            throw new DuplicateModelException(Constants.DUPLICATE_MODEL_MESSAGE);
        }
        this.engines.put(item.getModel(), item);
    }

    @Override
    public Engine getItemByModel(String model) throws NonExistentModelException {
        if (!this.engines.containsKey(model)) {
            throw new NonExistentModelException(Constants.NON_EXISTENT_MODEL_MESSAGE);
        }
        return this.engines.get(model);
    }
}
