import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LittleJohn {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int decNumber = findArrowsAndReturnConcatenateDecNumber(reader);
        String finalBinNumber = getFinalBinaryNumber(decNumber);

        /**You convert the final binary number again back to decimal.
         * This is the encrypted message you should send*/
        System.out.println(Integer.parseInt(finalBinNumber, 2));
    }

    private static String getFinalBinaryNumber(int decNumber) {
        /**Then you convert the number in binary representation,
        reverse it and concatenate it again with the initial
        binary representation of the number */

        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toBinaryString(decNumber));

        String binNumber = sb.toString();
        String reverseBinNumber = sb.reverse().toString();

        return String.format("%s%s", binNumber, reverseBinNumber);
    }

    private static int hidenDecNumberFromArrows(Integer smallArrow, Integer mediumArrow, Integer largeArrow) {
        /**Should concatenate arrows into one number
         * in order: small, medium, large arrow (even if the arrow count is 0).**/
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(smallArrow))
                .append(String.valueOf(mediumArrow))
                .append(String.valueOf(largeArrow));

        return Integer.valueOf(sb.toString());
    }

    private static int findArrowsAndReturnConcatenateDecNumber(BufferedReader reader) throws IOException {
        /**
         * Note that the body of each arrow will always be 5 dashes long.
         * The difference between the arrows is in their tip and tail.
         * The given 3 types are the only ones you should count,
         * the rest should be ignored (Robin Hood does not like them).
         * You should start searching the hays from the largest arrow type down to the smallest arrow type.
         */

        Integer smallArrow = 0;
        Integer mediumArrow = 0;
        Integer largeArrow = 0;

        Pattern arrowsPattern = Pattern.compile("([>]{1,3}[-]{5}[>]{1,2})");
        Pattern lArrowPatt = Pattern.compile("([>]{3}[-]{5}[>]{2})");
        Pattern mArrowPatt = Pattern.compile("([>]{2}[-]{5}[>])");
        Pattern sArrowPatt = Pattern.compile("([>][-]{5}[>])");

        for (int i = 0; i < 4; i++) {
            Matcher fullMatcher = arrowsPattern.matcher(reader.readLine());

            while (fullMatcher.find()) {
                Matcher matcherLA = lArrowPatt.matcher(fullMatcher.group());
                if (matcherLA.find()) {
                    largeArrow++;
                } else {
                    Matcher matcherMA = mArrowPatt.matcher(fullMatcher.group());
                    if (matcherMA.find()) {
                        mediumArrow++;
                    } else {
                        Matcher matcherSA = sArrowPatt.matcher(fullMatcher.group());
                        if (matcherSA.find()) {
                            smallArrow++;
                        }
                    }
                }
            }
        }

        /**After you find the count of each arrow type
         * you should concatenate them into one number
         * and return the result**/
        return hidenDecNumberFromArrows(smallArrow, mediumArrow, largeArrow);
    }
}
