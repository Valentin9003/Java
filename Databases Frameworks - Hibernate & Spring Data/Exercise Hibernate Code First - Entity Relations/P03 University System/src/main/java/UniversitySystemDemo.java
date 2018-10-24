import models.Course;
import models.Student;
import models.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniversitySystemDemo {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ExerciseHibernate");
        EntityManager entityManager = factory.createEntityManager();

        Course course = new Course("Db-Advanced", "Hibernate JPA and Spring Data", 76);
        Course course2 = new Course("Db-Basic", "MySQL", 13);
        Student student = new Student("Petar", "Petrov", "+44 32423 23423324", 5.86, "online");
        Student student2 = new Student("Gosho", "Goshev", "+44 234443 5234", 3.70, "online");
        Student student3 = new Student("Zeko", "Trenov", "+44 321 12323", 4.99, "online");
        Teacher teacher = new Teacher("Znaiko", "Mnogoznaiko", "00 99 882 332", "mnogoznaiko@dct.eu", 60.00);

        runApp(entityManager, course, course2, student, student2, student3, teacher);
        printInfoForTheCourses(entityManager);

        entityManager.close();
        factory.close();
    }

    private static void runApp(EntityManager entityManager, Course course, Course course2, Student student, Student student2, Student student3, Teacher teacher) {
        entityManager.getTransaction().begin();

        Set<Student> studentsSet = new HashSet<>();
        studentsSet.add(student);
        studentsSet.add(student2);

        Set<Student> studentsSet2 = new HashSet<>();
        studentsSet2.add(student3);

        course.setTeacher(teacher);
        course2.setTeacher(teacher);
        course.setStudents(studentsSet);
        course2.setStudents(studentsSet2);

        entityManager.persist(course);
        entityManager.persist(course2);
        entityManager.persist(teacher);
        entityManager.persist(student);
        entityManager.persist(student2);
        entityManager.persist(student3);

        entityManager.getTransaction().commit();
    }

    private static void printInfoForTheCourses(EntityManager entityManager) {
        List<Course> coursesList = entityManager.createQuery("FROM Course").getResultList();
        for (Course course : coursesList) {
            System.out.println("Course Name : " + course.getName());
            System.out.println(String.format("Teacher: %s %s%nStudents:",
                    course.getTeacher().getFirstName(), course.getTeacher().getLastName()));

            for (Student student : course.getStudents()) {
                System.out.println("        " + student.getFirstName() + " " + student.getLastName());
            }
            System.out.println();
        }
    }
}
