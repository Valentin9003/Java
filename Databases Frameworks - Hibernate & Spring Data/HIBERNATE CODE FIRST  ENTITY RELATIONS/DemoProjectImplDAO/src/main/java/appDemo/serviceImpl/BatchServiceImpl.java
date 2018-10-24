package appDemo.serviceImpl;

import appDemo.daoApi.BatchDao;
import appDemo.impl.BatchDaoImpl;
import appDemo.impl.JpaDao;
import appDemo.serviceApi.BatchService;
import appDemo.transactions.VoidCommand;
import model.ProductionBatch;

public class BatchServiceImpl extends ServiceImpl implements BatchService {

    @Override
    public void printBatch(ProductionBatch batch) {
        runInTransaction(new VoidCommand() {
            @Override
            public void execute() {
                ((BatchDao)dao).printBatch(batch);
            }
        });
    }

    @Override
    protected JpaDao createDao() {
        return new BatchDaoImpl(entityManager);
    }
}
