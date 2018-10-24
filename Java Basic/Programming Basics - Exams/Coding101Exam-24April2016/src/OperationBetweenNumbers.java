import java.util.Scanner;

public class OperationBetweenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number1 = Integer.parseInt(scanner.nextLine());
        int number2 = Integer.parseInt(scanner.nextLine());
        String operator = scanner.nextLine();

        int sum = 0;
        double sumDel = 0.00;
        String evenOdd = "";

        if (((number1 >= 0 && number1 <= 40000) && (number2 >= 0 && number2 <= 40000))
                || ("+".equals(operator) || "-".equals(operator) || "*".equals(operator)  || "/".equals(operator) || "%".equals(operator)))  {

            if ("+".equals(operator) || "-".equals(operator) || "*".equals(operator)) {
                switch (operator) {
                    case "+": sum = number1 + number2;
                        if (sum % 2 == 0) {
                            evenOdd = "even";
                        } else { evenOdd = "odd"; }
                        break;
                    case "-": sum = number1 - number2;
                        if (sum % 2 == 0) {
                            evenOdd = "even";
                        } else { evenOdd = "odd"; }
                        break;
                    case "*": sum = number1 * number2;
                        if (sum % 2 == 0) {
                            evenOdd = "even";
                        } else { evenOdd = "odd"; }
                        break;
                }

            } else if ("/".equals(operator)) {
                if (number2 == 0) {
                    System.out.println("Cannot divide " + number1 + " by zero");
                } else {
                    sumDel = (double)(number1) / (double)(number2);
                    System.out.printf("%d / %d = %.2f",number1,number2,sumDel);
                }
            } else if ("%".equals(operator)) {
                if (number2 == 0) {
                    System.out.println("Cannot divide " + number1 + " by zero");
                } else {
                    sum = number1 % number2;
                    System.out.printf("%d %s %d = %d",number1,operator,number2,sum);
                }
            }

        } else {
            System.out.println("Wrong input [0...40 000], (+,-,*,/,%)");
        }
        switch (operator) {                    // EXIT DATA RESULTS
            case "+":
                System.out.printf("%d + %d = %d - %s",number1,number2,sum,evenOdd);
                break;
            case "-":
                System.out.printf("%d - %d = %d - %s",number1,number2,sum,evenOdd);
                break;
            case "*":
                System.out.printf("%d * %d = %d - %s",number1,number2,sum,evenOdd);
                break;
        }
    }
}

