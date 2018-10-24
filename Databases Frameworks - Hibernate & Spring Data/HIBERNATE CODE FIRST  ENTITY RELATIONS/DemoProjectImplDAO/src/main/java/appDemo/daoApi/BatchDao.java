package appDemo.daoApi;

import model.ProductionBatch;

public interface BatchDao extends Dao{

    void printBatch(ProductionBatch batch);
}
