import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDateTime;

public class WizardDemo {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ExerciseHibernate");
        EntityManager entityManager = factory.createEntityManager();

        WizardDeposits wizard = new WizardDeposits("Dao"
                , "Depor"
                , "This bad bad wizard"
                , 24
                , "BlackDevil"
                , (short)1
                , "Game group"
                , LocalDateTime.now()
                , 32.23
                , 53.33
                , 12.12
                , LocalDateTime.now()
                , false);

        entityManager.getTransaction().begin();
        entityManager.persist(wizard);
        entityManager.getTransaction().commit();

        entityManager.close();
        factory.close();
    }
}
