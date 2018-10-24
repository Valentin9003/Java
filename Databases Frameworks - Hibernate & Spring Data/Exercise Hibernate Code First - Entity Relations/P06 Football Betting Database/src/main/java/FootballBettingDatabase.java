import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FootballBettingDatabase {

    public static void main(String[] args) {

        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("ExerciseHibernate");
        EntityManager entityManager = factory.createEntityManager();

        //TODO test input data...

        entityManager.close();
        factory.close();
    }
}
