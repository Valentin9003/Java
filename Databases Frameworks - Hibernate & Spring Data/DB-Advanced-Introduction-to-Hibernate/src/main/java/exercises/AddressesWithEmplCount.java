package exercises;

import entities.Address;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class AddressesWithEmplCount {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();

        String hqlQuery =
                "SELECT a FROM Address AS a " +
                "ORDER BY size(a.employees) DESC, a.town.id ASC";
        List<Address> addresses = entityManager.createQuery(hqlQuery).setMaxResults(10).getResultList();

        addresses.forEach(a -> {
            System.out.println(String.format("%s, %s - %d employees",
                    a.getText(), a.getTown().getName(), a.getEmployees().size()));
        });

        entityManager.close();
        factory.close();
    }
}
