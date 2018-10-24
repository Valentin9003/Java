package com.company.telephony;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> phoneNumbersList = new LinkedList<>(Arrays.asList(reader.readLine().split("\\s+")));
        List<String> webSitesList = new LinkedList<>(Arrays.asList(reader.readLine().split("\\s+")));

        Calling callSmartphone = new Smartphone();
        for (String phoneNumber : phoneNumbersList) {
            callSmartphone.Call(phoneNumber);
        }

        Browsing browsingSmartphone = new Smartphone();
        for (String webSite : webSitesList) {
            browsingSmartphone.Browse(webSite);
        }
    }
}
