package exercises;

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.List;

public class IncreaseSalaries {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();

        String hqlQuery =
                "SELECT e FROM Employee AS e " +
                "WHERE e.department.name IN ('Engineering', 'Tool Design', 'Marketing', 'Information Services')";
        Query query = entityManager.createQuery(hqlQuery);
        List<Employee> employees = query.getResultList();

        entityManager.getTransaction().begin();
        for (Employee e : employees) {
            BigDecimal newSalary = e.getSalary().multiply(BigDecimal.valueOf(1.2));
            e.setSalary(newSalary);
        }
        entityManager.getTransaction().commit();

        employees.forEach(e -> {
            System.out.println(String.format("%s %s ($%.2f)", e.getFirstName(), e.getLastName(), e.getSalary()));
        });

        entityManager.close();
        factory.close();
    }
}
