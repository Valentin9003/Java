package exercises;

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class EmployeesSalaryOver {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();

        String query = "SELECT e FROM Employee AS e WHERE e.salary > 50000";
        List<Employee> employees = entityManager.createQuery(query).getResultList();
        for (Employee employee : employees) {
            System.out.println(employee.getFirstName());
        }

        entityManager.close();
        factory.close();
    }
}
