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

public class RemoveTowns {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();

        System.out.println("Enter town for delete: ");
        String townForDelete = reader.readLine();

        entityManager.getTransaction().begin();

        setEmployeeAdressToNull(entityManager, townForDelete);
        List<Address> addresses = deleteAddressesFromTheGivenTown(entityManager, townForDelete);
        deleteTownWithTheGivenName(entityManager, townForDelete);
        System.out.println(String.format("%d address in %s deleted", addresses.size(), townForDelete));

        entityManager.getTransaction().commit();

        entityManager.close();
        factory.close();
    }

    private static void deleteTownWithTheGivenName(EntityManager entityManager, String townForDelete) {
        String hqlDeleteTownQuery = "SELECT t FROM Town AS t WHERE t.name = '" + townForDelete + "'";
        Query queryTown = entityManager.createQuery(hqlDeleteTownQuery);
        Town town = (Town) queryTown.getSingleResult();
        entityManager.remove(town);
    }

    private static List<Address> deleteAddressesFromTheGivenTown(EntityManager entityManager, String townForDelete) {
        String hqlQuery = "SELECT a FROM Address AS a WHERE a.town.name = '" + townForDelete + "'";
        Query queryAddressesByTown = entityManager.createQuery(hqlQuery);
        List<Address> addresses = queryAddressesByTown.getResultList();

        for (Address address : addresses) {
            entityManager.remove(address);
        }
        return addresses;
    }

    private static void setEmployeeAdressToNull(EntityManager entityManager, String townForDelete) {
        String query = "SELECT e FROM Employee AS e WHERE e.address.town.name = '" + townForDelete + "'";
        Query queryGetEmplFromAddress = entityManager.createQuery(query);
        List<Employee> employees = queryGetEmplFromAddress.getResultList();
        for (Employee employee : employees) {
            employee.setAddress(null);
        }
    }
}
