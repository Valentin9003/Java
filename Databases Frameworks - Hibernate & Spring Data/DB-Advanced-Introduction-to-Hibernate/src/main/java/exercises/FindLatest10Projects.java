package exercises;

import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class FindLatest10Projects {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();

        String hqlQuery = "SELECT p FROM Project AS p ORDER BY p.startDate DESC";
        Query query = entityManager.createQuery(hqlQuery).setMaxResults(10);
        List<Project> projects = query.getResultList();

        projects.stream()
                .forEach(p -> {
                    System.out.println(String.format("Project name: %s", p.getName()));
                    System.out.println(String.format("        Project Description: %s", p.getDescription()));
                    System.out.println(String.format("        Project Start Date: %s", p.getStartDate()));
                    System.out.println(String.format("        Project End Date: %s", p.getEndDate()));
                });
        entityManager.close();
        factory.close();
    }
}
