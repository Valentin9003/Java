import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.Scanner;

public class XBits {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("00000000000000000000000000000000");

        String[] allNumsAsBites = new String[8];

        for (int a = 0; a < 8; a++) {
            int num = scanner.nextInt();
            String biteNum = Integer.toBinaryString(num);
            String bigIntAsBite = df.format(new BigInteger(biteNum));
            allNumsAsBites[a] = bigIntAsBite;
        }
        int counter = 0;
        for (int a = 0; a < allNumsAsBites.length-2; a++) {
            char[] biteToCharFirst = allNumsAsBites[a].toCharArray();
            for (int b = 0; b < biteToCharFirst.length-2; b++){
                if (biteToCharFirst[b]=='1' && biteToCharFirst[b+1]=='0' && biteToCharFirst[b+2]=='1'){
                    char[] biteToCharSecond = allNumsAsBites[a+1].toCharArray();
                    if (biteToCharSecond[b]=='0' && biteToCharSecond[b+1]=='1' && biteToCharSecond[b+2]=='0'){
                        char[] biteToCharThird = allNumsAsBites[a+2].toCharArray();
                        if (biteToCharThird[b]=='1' && biteToCharThird[b+1]=='0' && biteToCharThird[b+2]=='1'){
                            counter++;
                        }
                    }
                }
            }
        }
        System.out.println(counter);
    }
}
