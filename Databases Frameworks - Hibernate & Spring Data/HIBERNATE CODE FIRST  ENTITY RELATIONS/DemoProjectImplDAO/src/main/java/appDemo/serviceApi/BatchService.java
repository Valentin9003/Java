package appDemo.serviceApi;

import model.ProductionBatch;

public interface BatchService extends Service{

    void printBatch(ProductionBatch batch);
}
