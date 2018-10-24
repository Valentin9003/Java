package exercises;

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class FindEmplByFirstName {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();

        System.out.println("Enter pattern for First Name: ");
        String pattern = reader.readLine();

        String hqlQuery = "SELECT e FROM Employee AS e WHERE e.firstName LIKE '" + pattern + "%'";
        Query query = entityManager.createQuery(hqlQuery);
        List<Employee> employees = query.getResultList();

        employees.forEach(e -> {
            System.out.println(String.format("%s %s - %s - ($%.2f)",
                    e.getFirstName(), e.getLastName(), e.getJobTitle(), e.getSalary()));
        });

        entityManager.close();
        factory.close();
    }
}
