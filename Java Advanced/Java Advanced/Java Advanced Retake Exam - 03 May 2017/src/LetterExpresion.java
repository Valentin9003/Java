import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LetterExpresion {

    private static final String PATTERN_FLOATING_POINT_NUMBERS = "(?<symbols>\\D+)?(?<number>\\d+([.]?\\d+)?)";
    private static final String PATTERN_DECIMAL_NUMBERS = "(?<symbols>\\D+)?(?<number>\\d+)";
    private static final String GROUP_OF_SYMBOLS = "symbols";
    private static final String GROUP_OF_NUMBER = "number";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        DecimalFormat df = new DecimalFormat("0.#######");

        String inputLine = reader.readLine();
        Pattern pattern = Pattern.compile(PATTERN_DECIMAL_NUMBERS);
        Matcher matcher = pattern.matcher(inputLine);

        BigDecimal sum = BigDecimal.ZERO;
        while (matcher.find()) {
            String symbol = matcher.group(GROUP_OF_SYMBOLS);

            int symbolLength = 0;
            if (symbol != null) {
                symbolLength = symbol.length();
            }

            BigDecimal number = new BigDecimal(matcher.group(GROUP_OF_NUMBER));
            if (symbolLength % 2 == 0) {
              sum = sum.add(number);
              continue;
            }
            sum = sum.subtract(number);
        }
        System.out.println(df.format(sum));
    }
}
