package com.company;
//Don't work with very big numbers
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MultiplyBigNumber {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String number = reader.readLine();
        String multiplyNumber = reader.readLine();
        
        String result = Multiply(number, multiplyNumber);
        System.out.println(result.trim());
    }

    public static String Multiply(String num1, String num2){
        int product, carry=0, sum=0;
        String result = new String("");
        String partial = new String("");
        ArrayList<String> partialList = new ArrayList<String>();

        /* computing partial products using this loop. */
        for(int j=num2.length()-1 ; j>=0 ; j--) {
            for(int i=num1.length()-1 ; i>=0 ; i--) {

                product = Integer.parseInt((new Character(num1.charAt(i))).toString()) *
                        Integer.parseInt((new Character(num2.charAt(j))).toString()) + carry;
                carry = product/10;
                partial = Integer.toString(product%10) + partial;
            }

            if(carry != 0)
                partial = Integer.toString(carry) + partial;

            partialList.add(partial);
            partial = "";
            carry = 0;
        }

        /* appending zeroes incrementally */
        for(int i=0 ; i<partialList.size() ; i++)
            partialList.set(i, partialList.get(i) + (Long.toString( (long)java.lang.Math.pow(10.0,(double)i))).substring(1)   );

        /* getting the size of the largest partial product(last) */
        int largestPartial = partialList.get(partialList.size()-1).length();

        /* prefixing zeroes */
        int zeroes;
        for(int i=0 ; i<partialList.size() ; i++) {
            zeroes =  largestPartial - partialList.get(i).length();

            if(zeroes >= 1)
                partialList.set(i, (Long.toString( (long)java.lang.Math.pow(10.0,(double)zeroes))).substring(1) + partialList.get(i)   );
        }

        /* to compute the result */
        carry = 0;
        for(int i=largestPartial-1 ; i>=0 ; i--) {

            sum = 0;
            for(int j=0 ; j<partialList.size() ; j++)
                sum = sum + Integer.parseInt(new Character(partialList.get(j).charAt(i)).toString());

            sum = sum + carry;
            carry = sum/10;
            result = Integer.toString(sum%10) + result;
        }

        if(carry != 0)
            result = Integer.toString(carry) + result;

        return result;
    }
}
