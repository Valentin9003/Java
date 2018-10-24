package appDemo;

import model.AmoniumCloride;
import model.BasicIngredient;
import model.Mint;
import model.Strawberry;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ShampooCompany {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ShampooCompany");
        EntityManager entityManager = factory.createEntityManager();

        BasicIngredient mint = new Mint();
        BasicIngredient strawberry = new Strawberry();
        BasicIngredient strawberry_2 = new Strawberry();
        BasicIngredient amoniumCloride = new AmoniumCloride();

        entityManager.getTransaction().begin();
        entityManager.persist(mint);
        entityManager.persist(strawberry);
        entityManager.persist(strawberry_2);
        entityManager.persist(amoniumCloride);
        entityManager.getTransaction().commit();

        BasicIngredient bi_1 = entityManager.find(BasicIngredient.class, 1L);
        BasicIngredient bi_2 = entityManager.find(BasicIngredient.class, 2L);
        BasicIngredient bi_3 = entityManager.find(BasicIngredient.class, 3L);
        BasicIngredient bi_4 = entityManager.find(BasicIngredient.class, 4L);

        entityManager.close();
        factory.close();
    }
}
