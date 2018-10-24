package appDemo.serviceImpl;

import appDemo.daoApi.Dao;
import appDemo.impl.JpaDao;
import appDemo.serviceApi.Service;
import appDemo.transactions.Command;
import appDemo.transactions.MultyResultCommand;
import appDemo.transactions.Transactional;
import appDemo.transactions.VoidCommand;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ServiceImpl<E, K> implements Service<E, K>, Transactional<E>{

    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("ShampooCompany");

    protected EntityManager entityManager;

    protected Dao<E, K> dao;

    @Override
    public E findById(Class<E> serviceClass, K id) {
        return runInTransaction(new Command<E>() {
            @Override
            public E execute() {
                return dao.findById(serviceClass, id);
            }
        });
    }

    @Override
    public void remove(E object) {
        runInTransaction(new VoidCommand<E>() {
            @Override
            public void execute() {
                dao.remove(object);
            }
        });
    }

    @Override
    public List<E> findAll(Class<E> serviceClass) {
        return runInTransaction(new MultyResultCommand<E>() {
            @Override
            public List<E> execute() {
                return dao.findAll(serviceClass);
            }
        });
    }

    @Override
    public void save(E object) {
        runInTransaction(new VoidCommand<E>() {
            @Override
            public void execute() {
                dao.save(object);
            }
        });
    }


    @Override
    public void runInTransaction(VoidCommand<E> command) {
        entityManager = factory.createEntityManager();
        try {
            dao = createDao();
            entityManager.getTransaction().begin();
            command.execute();
            entityManager.getTransaction().commit();
        } catch (Throwable t) {
            entityManager.getTransaction().rollback();
            //log here...
            throw t;
        } finally {
            try {
                entityManager.close();
            } catch (IllegalStateException e) {
                //log here
            }
        }
    }

    @Override
    public E runInTransaction(Command<E> command) {
        entityManager = factory.createEntityManager();
        try {
            dao = createDao();
            entityManager.getTransaction().begin();
            E result = command.execute();
            entityManager.getTransaction().commit();
            return result;
        } catch (Throwable t) {
            entityManager.getTransaction().rollback();
            //log here...
            throw t;
        } finally {
            try {
                entityManager.close();
            } catch (IllegalStateException e) {
                //log here
            }
        }
    }

    @Override
    public List<E> runInTransaction(MultyResultCommand<E> command) {
        entityManager = factory.createEntityManager();
        try {
            dao = createDao();
            entityManager.getTransaction().begin();
            List<E> result = command.execute();
            entityManager.getTransaction().commit();
            return result;
        } catch (Throwable t) {
            entityManager.getTransaction().rollback();
            //log here...
            throw t;
        } finally {
            try {
                entityManager.close();
            } catch (IllegalStateException e) {
                //log here
            }
        }
    }

    protected JpaDao<E, K> createDao() {
        return new JpaDao<>(entityManager);
    }
}
