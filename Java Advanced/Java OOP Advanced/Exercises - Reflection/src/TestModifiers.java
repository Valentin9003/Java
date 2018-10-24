import java.lang.reflect.Modifier;

public class TestModifiers {
    public static void main(String[] args) {

        for (int i = 0; i < 7000; i++) {
            System.out.println(Modifier.toString(i));
        }
    }
}
