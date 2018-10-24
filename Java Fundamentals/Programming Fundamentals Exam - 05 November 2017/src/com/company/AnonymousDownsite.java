package com.company;
// 100/100
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class AnonymousDownsite {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numberWebsitesDown = Integer.parseInt(reader.readLine());
        int securityKey = Integer.parseInt(reader.readLine());

        BigDecimal totalMoneyLoss = BigDecimal.ZERO;
        for (int i = 0; i < numberWebsitesDown; i++)
        {
            String[] data = reader.readLine().split("\\s+");

            String siteName = data[0];
            BigDecimal siteVisits = new BigDecimal(data[1]);
            BigDecimal pricePerVisit = new BigDecimal(data[2]);

            BigDecimal siteLosse = siteVisits.multiply(pricePerVisit);
            totalMoneyLoss = totalMoneyLoss.add(siteLosse);

            System.out.println(siteName);
        }

        System.out.println(String.format("Total Loss: %.20f", totalMoneyLoss));

        BigDecimal securityToken = BigDecimal.valueOf(securityKey).pow(numberWebsitesDown);
        System.out.println(String.format("Security Token: %.0f", securityToken ));
    }
}

/*
The Anonymous informal group of activists have hacked a few commercial websites and the CIA has hired you to write a software
 which calculates the losses. Based on the given data, use the appropiate data types.
You will receive 2 input lines – each containing an integer.
•	The first is N – the number of websites which are down.
•	The second is the security key.
On the next N lines you will receive data about websites in the following format:
{siteName} {siteVisits} {siteCommercialPricePerVisit}
You must calculate the site loss by the following formula: siteVisits * siteCommercialPricePerVisit
When you finish reading all data, you must print the affected sites’ names – each on a new line.
Then you must print the total money loss – sum of all site loss, on a new line.
Finally you must print the security token, which is the security key, POWERED by the COUNT of affected sites.
Input
•	On the first input line you will get N – the count of affected websites.
•	On the second input line you will the security key.
•	On the next N input lines you will get data about the websites.
Output
•	As output you must print all affected websites’ names – each on a new line.
•	After the website names you must print the total loss of data, printed to the 20th digit after the decimal point. The format is “Total Loss: {totalLoss}”.
•	Finally you must print the security token. The format is “Security Token: {securityToken}”.
Constrains
•	The integer N will be in range [0, 100].
•	The security token will be in range [0, 10].
•	The website name may contain any ASCII character except whitespace.
•	The site visits will be an integer in range [0, 231].
•	The price per visit will be a floating point number in range [0, 100] and will have up to 20 digits after the decimal point.
•	Allowed working time/memory: 100ms / 16MB.

 */