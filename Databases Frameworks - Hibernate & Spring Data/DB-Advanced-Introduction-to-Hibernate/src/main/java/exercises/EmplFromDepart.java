package exercises;

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.List;

public class EmplFromDepart {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();

//        firstWayWithDetach(factory, entityManager);
        secondWay(factory, entityManager);
    }

    private static void secondWay(EntityManagerFactory factory, EntityManager entityManager) {
        String query =
                "SELECT e FROM Employee AS e " +
                "JOIN e.department AS d " +
                "WHERE d.name = 'Research and Development'";

        List<Employee> employees = entityManager.createQuery(query).getResultList();

        employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary)
                        .thenComparing(Comparator.comparing(Employee::getId)))
                .forEach(e -> {
                    System.out.println(String.format("%s %s from %s - $%.2f",
                            e.getFirstName(), e.getLastName(), e.getDepartment().getName(), e.getSalary()));
                });

        entityManager.close();
        factory.close();
    }

    private static void firstWayWithDetach(EntityManagerFactory factory, EntityManager entityManager) {
        String query = "SELECT e FROM Employee AS e";
        List<Employee> employees = entityManager.createQuery(query).getResultList();

        for (Employee employee : employees) {
            if (!employee.getDepartment().getName().equals("Research and Development")) {
                entityManager.detach(employee);
            }
        }

        employees.stream()
                .filter(entityManager::contains)
                .sorted(Comparator.comparing(Employee::getSalary).thenComparing(Comparator.comparing(Employee::getId)))
                .forEach(e -> {
                    System.out.println(String.format("%s %s from %s - $%.2f",
                            e.getFirstName(), e.getLastName(), e.getDepartment().getName(), e.getSalary()));
                });

        entityManager.close();
        factory.close();
    }
}
