package exercises;

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class EmplMaxSalaries {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();

        String hqlQuery =
                "SELECT e FROM Employee e " +
                "WHERE e.salary = (select max(em.salary) from Employee em " +
                                  "where em.department.name = e.department.name) " +
                        "AND (e.salary < 30000 OR e.salary > 70000)" +
                "GROUP BY e.department.name";
        Query query = entityManager.createQuery(hqlQuery);
        List<Employee> employees = query.getResultList();

        employees.stream()
                .forEach(e -> {
            System.out.println(e.getDepartment().getName() + " - " + e.getSalary());
        });

        entityManager.close();
        factory.close();
    }
}
