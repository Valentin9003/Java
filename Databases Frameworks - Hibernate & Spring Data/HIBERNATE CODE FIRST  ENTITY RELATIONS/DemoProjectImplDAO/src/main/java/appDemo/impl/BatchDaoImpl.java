package appDemo.impl;

import appDemo.daoApi.BatchDao;
import model.ProductionBatch;

import javax.persistence.EntityManager;

public class BatchDaoImpl extends JpaDao implements BatchDao {

    public BatchDaoImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void printBatch(ProductionBatch batch) {
        System.out.println(batch);
    }
}
