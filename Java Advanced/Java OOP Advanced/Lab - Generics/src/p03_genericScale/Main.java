package p03_genericScale;

public class Main {
    public static void main(String[] args) {

        Scale<String> scaleStr = new Scale<>("a", "c");
        System.out.println(scaleStr.getHeavier());

        Scale<Integer> scaleInts = new Scale<>(1, 2);
        System.out.println(scaleInts.getHeavier());
    }
}
