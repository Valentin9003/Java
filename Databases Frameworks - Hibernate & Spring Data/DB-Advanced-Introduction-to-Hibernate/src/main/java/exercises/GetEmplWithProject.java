package exercises;

import entities.Employee;
import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.List;

public class GetEmplWithProject {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();

        System.out.println("Enter employee ID: ");
        int employeeID = Integer.parseInt(reader.readLine());

        String hqlQuery = "SELECT e FROM Employee AS e WHERE e.id = " + employeeID;
        List<Employee> employees = entityManager.createQuery(hqlQuery).getResultList();

        employees
                .stream()
                .forEach(e -> {
                    System.out.println(String.format("%s %s - %s", e.getFirstName(), e.getLastName(), e.getJobTitle()));
                    e.getProjects()
                            .stream()
                            .sorted(Comparator.comparing(Project::getName))
                            .forEach(p -> {
                                System.out.println(String.format("      %s", p.getName()));
                            });
                });

        entityManager.close();
        factory.close();
    }
}
