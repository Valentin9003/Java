package exercises;

import entities.Address;
import entities.Employee;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class AddAddressUpdatingEmpl {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();

        createNewAddress(entityManager, reader);

        entityManager.close();
        factory.close();
    }

    private static void createNewAddress(EntityManager entityManager, BufferedReader reader) throws IOException {
        Town town = new Town();
        town.setName("Plovdiv");

        Address newAddress = new Address();
        newAddress.setText("Vitoshka 15");
        newAddress.setTown(town);

        entityManager.getTransaction().begin();
        entityManager.persist(town);
        entityManager.persist(newAddress);
        entityManager.getTransaction().commit();

        try {
            setTheAddressToEmployee(entityManager, newAddress, reader);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }

    private static void setTheAddressToEmployee(EntityManager entityManager, Address newAddress, BufferedReader reader) throws IOException {
        System.out.println("Please enter user(Last Name): ");
        String uLastNamse = reader.readLine();

        String hqlQuery = "SELECT e FROM Employee AS e WHERE e.lastName = '" + uLastNamse + "'";
        Query query = entityManager.createQuery(hqlQuery);
        List<Employee> employees = query.getResultList();
        if (employees.size() == 1) {
            entityManager.getTransaction().begin();
            employees.get(0).setAddress(newAddress);
            entityManager.getTransaction().commit();
        } else if (employees.size() > 1) {
            throw new IllegalArgumentException("Have more than one employees with the given last name.");
        } else {
            throw new IllegalArgumentException("Don't have employee with the given last name in Database.");
        }
    }
}
