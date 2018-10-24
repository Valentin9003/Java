package exercises;

import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class RemoveObjects {
    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em = factory.createEntityManager();

        List<Town> towns = em.createQuery("SELECT t FROM Town AS t").getResultList();

        for (Town town : towns) {
            if (town.getName().length() > 5) {
                em.detach(town);
            }
        }
        em.getTransaction().begin();
        for (Town town : towns) {
            if (em.contains(town)) {
                town.setName(town.getName().toLowerCase());
                em.persist(town);
            }
        }
        em.getTransaction().commit();

        em.close();
        factory.close();
    }
}
