package p04_createAnnotation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TestClass testClass = new TestClass();

        Class<? extends TestClass> testClazz = testClass.getClass();

        Subject subject = testClazz.getAnnotation(Subject.class);
        if (subject != null) {
            for (String s : subject.categories()) {
                System.out.println("Category: " + s);
            }
        }
    }
}
