import models.Customer;
import models.Product;
import models.Sale;
import models.StoreLocation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class SalesDbDemo {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ExerciseHibernate");
        EntityManager entityManager = factory.createEntityManager();

        Customer customer = new Customer("Grigor Gorev", "ggorev@gmail.com", "321DF65H22");
        Product product = new Product("robot", 99.99, BigDecimal.valueOf(320.34));
        StoreLocation location = new StoreLocation("Sinsinata");
        Sale sale = new Sale();

        entityManager.getTransaction().begin();
        sale.setCustomer(customer);
        sale.setProduct(product);
        sale.setStoreLocation(location);
        entityManager.persist(sale);
        entityManager.getTransaction().commit();

        entityManager.close();
        factory.close();
    }
}
