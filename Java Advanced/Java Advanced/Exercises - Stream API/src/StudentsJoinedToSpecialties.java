import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StudentsJoinedToSpecialties {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Student> studentsDB = new ArrayList<>();
        List<StudentSpecialty> sSpecialties = new ArrayList<>();

        readAndFillStudentsSpecialties(reader, sSpecialties);
        readAndFillStudentsDB(reader, studentsDB);

        studentsDB.sort(Comparator.comparing(Student::getName));

        studentsDB
                .forEach(student ->
                        sSpecialties.forEach(specialty -> {
                            if (student.getFacultyNumber().equals(specialty.getFacultyNumber())) {
                                System.out.println(String.format("%s %s %s",
                                        student.getName(),
                                        student.getFacultyNumber(),
                                        specialty.getName()));
                            }
                        }));

//        List<String> joined = new ArrayList<>();
//        sSpecialties.stream()
//                .flatMap(specialty ->
//                        studentsDB.stream().filter(student -> {
//                            if (specialty.getFacultyNumber().equals(student.getFacultyNumber())) {
//                                joined.add(String.format("%s %s %s",
//                                        student.getName(),
//                                        student.getFacultyNumber(),
//                                        specialty.getName()));
//                            }
//
//                            return specialty
//                                    .getFacultyNumber()
//                                    .equals(student.getFacultyNumber());
//                        }))
//                .collect(Collectors.toList());

    }

    private static void readAndFillStudentsDB(BufferedReader reader, List<Student> studentsDB) throws IOException {
        String line;
        while (!"END".equals(line = reader.readLine())) {
            String[] tokens = line.split("\\s+");
            String facultyNumber = tokens[0];
            String studentName = tokens[1] + " " + tokens[2];

            Student student = new Student(studentName, facultyNumber);
            studentsDB.add(student);
        }
    }

    private static void readAndFillStudentsSpecialties(BufferedReader reader, List<StudentSpecialty> sSpecialties) throws IOException {
        String line;
        while (!"Students:".equals(line = reader.readLine())) {
            String[] tokens = line.split("\\s+");
            String specialityName = tokens[0] + " " + tokens[1];
            String facultyNumber = tokens[2];

            StudentSpecialty studentSpecialty = new StudentSpecialty(specialityName, facultyNumber);
            sSpecialties.add(studentSpecialty);
        }
    }
}

class Student {
    private String name;
    private String facultyNumber;

    public Student(String name, String facultyNumber) {
        this.name = name;
        this.facultyNumber = facultyNumber;
    }

    public String getName() {
        return name;
    }

    public String getFacultyNumber() {
        return facultyNumber;
    }
}

class StudentSpecialty {
    private String name;
    private String facultyNumber;

    public StudentSpecialty(String specialtyName, String facultyNumber) {
        this.name = specialtyName;
        this.facultyNumber = facultyNumber;
    }

    public String getName() {
        return name;
    }

    public String getFacultyNumber() {
        return facultyNumber;
    }
}
