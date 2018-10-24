package com.company;
//In Judge 100/100 ->> working with big numbers
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MultiplyBigNumber2 {
    static int len;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String bigNumber = reader.readLine();
        String multiplyNumber = reader.readLine();

        System.out.println(multiply(bigNumber,multiplyNumber));
    }

    private static ArrayList<Integer> addTheList(List<ArrayList<Integer>> myList) {
        ArrayList<Integer> result=new ArrayList<>();

        for(int i=0;i<len;i++)
        {
            result.add(0);

        }
        int index=0;
        for(int i=0;i<myList.size();i++)
        {
            ArrayList<Integer> a=new ArrayList<>(myList.get(index));
            ArrayList<Integer> b=new ArrayList<>(myList.get(index+1));
            for (int j = 0; j < a.size()||j < b.size(); i++) {
                result.add(a.get(i) + b.get(i));
            }

        }

        return result;
    }

    private static ArrayList<Integer> multiply(ArrayList<Integer> list1, Integer integer) {
        ArrayList<Integer> result=new ArrayList<>();
        int prvs=0;
        for(int i=0;i<list1.size();i++)
        {
            int sum=(list1.get(i)*integer)+prvs;
            System.out.println(sum);
            int r=sum/10;
            int m=sum%10;

            if(!(r>0))
            {

                result.add(sum);
            }
            else
            {
                result.add(m);
                prvs=r;
            }
            if(!(i==(list1.size()-1)))
            {
                prvs=0;
            }

        }
        if(!(prvs==0))
        {
            result.add(prvs);
        }
        return result;
    }

    private static ArrayList<Integer> changeToNumber(String str1) {
        ArrayList<Integer> list1=new ArrayList<>();
        for(int i=0;i<str1.length();i++)
        {

            list1.add(Character.getNumericValue(str1.charAt(i)));
        }
        return list1;

    }

    public static String multiply(String num1, String num2) {
        String n1 = new StringBuilder(num1).reverse().toString();
        String n2 = new StringBuilder(num2).reverse().toString();

        int[] d = new int[num1.length()+num2.length()];

        //multiply each digit and sum at the corresponding positions
        for(int i=0; i<n1.length(); i++){
            for(int j=0; j<n2.length(); j++){
                d[i+j] += (n1.charAt(i)-'0') * (n2.charAt(j)-'0');
            }
        }

        StringBuilder sb = new StringBuilder();

        //calculate each digit
        for(int i=0; i<d.length; i++){
            int mod = d[i]%10;
            int carry = d[i]/10;
            if(i+1<d.length){
                d[i+1] += carry;
            }
            sb.insert(0, mod);
        }

        //remove front 0's
        while(sb.charAt(0) == '0' && sb.length()> 1){
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }
}
