package p03_mankind;

import p03_mankind.models.Human;
import p03_mankind.models.Student;
import p03_mankind.models.Worker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final int FIRST_NAME_INDEX = 0;
    private static final int LAST_NAME_INDEX = 1;
    private static final int FACULTY_NUMBER_INDEX = 2;
    private static final int SALARY_INDEX = 2;
    private static final int WORKING_HOURS_INDEX = 3;

    public static void main(String[] args) throws IOException {

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            Human student = createStudent(reader);
            Human worker = createWorker(reader);

            System.out.println(student);
            System.out.println(worker);

        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }

    private static Human createWorker(BufferedReader reader) throws IOException {
        String[] workerData = reader.readLine().split("\\s+");
        return new Worker(
                workerData[FIRST_NAME_INDEX],
                workerData[LAST_NAME_INDEX],
                Double.parseDouble(workerData[SALARY_INDEX]),
                Double.parseDouble(workerData[WORKING_HOURS_INDEX]));
    }

    private static Human createStudent(BufferedReader reader) throws IOException {
        String[] studentData = reader.readLine().split("\\s+");
        return new Student(
                studentData[FIRST_NAME_INDEX],
                studentData[LAST_NAME_INDEX],
                studentData[FACULTY_NUMBER_INDEX]);
    }
}
