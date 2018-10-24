package service.commands;

import entity.Diagnose;
import entity.Medicament;
import entity.Patient;
import entity.Visitation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.io.IOException;
import java.util.List;

public class CommandExecutor<E, K> implements ICommandExecutor<E, K> {

    private EntityManager entityManager;

    public CommandExecutor(EntityManagerFactory factory) {
        this.entityManager = factory.createEntityManager();
    }

    @Override
    public E findById(Class<E> entityClass, K primaryKey) {
        return entityManager.find(entityClass, primaryKey);
    }

    @Override
    public void remove(E entity) {
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<E> findAll(Class<E> entityClass) {
        return entityManager.createQuery("FROM " + entityClass.getSimpleName()).getResultList();
    }

    @Override
    public void save(E entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    public void addNewMedicament(Medicament medicament, Patient patient) {
        entityManager.getTransaction().begin();
        patient.setNewMedicaments(medicament);
        entityManager.getTransaction().commit();
    }

    public void addDiagnose(Patient patient, Diagnose diagnose) throws IOException {
        entityManager.getTransaction().begin();
        patient.setNewDiagnose(diagnose);
        entityManager.getTransaction().commit();
    }

    public void addVisitation(Patient patient, Visitation visitation) throws IOException {
        entityManager.getTransaction().begin();
        patient.setNewVisitations(visitation);
        entityManager.getTransaction().commit();
    }

    public void closeEntityManager() {
        this.entityManager.close();
    }
}
