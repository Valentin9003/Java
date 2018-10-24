import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BillsPaymentSystem {

    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("ExerciseHibernate");
        EntityManager entityManager = factory.createEntityManager();

        //TODO input test data...

        entityManager.close();
        factory.close();
    }
}
