package com.company;
// 90/100 in Judge
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SumOfAllValues {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Pattern keysPattern = Pattern.compile("^([A-Za-z_]+)[0-9].*[0-9]([A-Za-z_]+)$");

        String keySTR = reader.readLine();
        String textSTR = reader.readLine();

        Matcher keysMatcher = keysPattern.matcher(keySTR);
        if (keysMatcher.find()) {
            String startKey = keysMatcher.group(1);
            String endKey = keysMatcher.group(2);
            calculateTotalValueAndPrintResult(textSTR, startKey, endKey);
        } else {
            System.out.println("<p>A key is missing</p>");
        }
    }

    private static void calculateTotalValueAndPrintResult(String textSTR, String startKey, String endKey) {
        String pattSTR = String.format("(%s)(\\d+(\\.\\d+)?)(%s)", startKey, endKey);
        Pattern pattern = Pattern.compile(pattSTR);
        Matcher matcher = pattern.matcher(textSTR);

        double sum = 0.0;
        while (matcher.find()) {
            double number = Double.parseDouble(matcher.group(2));
            sum += number;
        }
        
        printResult(sum);
    }

    private static void printResult(double sum) {
        DecimalFormat df = new DecimalFormat("#########0.##");

        if (sum == 0.0) {
            System.out.println("<p>The total value is: <em>nothing</em></p>");
        } else {
            System.out.println(String.format("<p>The total value is: <em>%s</em></p>", df.format(sum)));
        }
    }
}

//startKEY12adghfgh243212gadghfgs43endKEY
//asdjykulgfjddfsffdstartKEY12endKEYqwfrhtyu67543rewghy3tefdgdstartKEY123.45endKEYwret34yrestartKEY2.6endKEY213434ytuhrgerweasfdstartKEYendKEYstartKEYasfdgeendKEY

//startKEY12adghfgh243212gadghfgs43endKEY
//asdjykulgfjddfsffdstartKEY12endKEYqwfrhtyu67543rewghy3tefdgdstartKEY123endKEYwret34yrestartKEY2endKEY213434ytuhrgerweasfdstartKEYendKEYstartKEYasfdgeendKEY
