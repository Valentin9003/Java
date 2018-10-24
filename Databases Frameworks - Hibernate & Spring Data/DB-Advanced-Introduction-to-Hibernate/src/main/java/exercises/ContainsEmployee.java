package exercises;

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ContainsEmployee {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em = factory.createEntityManager();

        System.out.println("Enter Employee full name (first and last name): ");
        String[] fullName = reader.readLine().split(" ");
        String firstName = fullName[0];
        String lastName = fullName[1];

        String hqlQuery = "SELECT e FROM Employee e WHERE e.firstName =:fName AND e.lastName =:lName";
        try {
            Employee employee = (Employee) em.createQuery(hqlQuery)
                    .setParameter("fName", firstName)
                    .setParameter("lName", lastName)
                    .getSingleResult();

            System.out.println("Yes");
        } catch (NoResultException e) {
            System.out.println("No");
        }

        em.close();
        factory.close();
    }
}
