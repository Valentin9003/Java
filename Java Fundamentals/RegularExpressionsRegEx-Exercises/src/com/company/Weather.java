/*
    You have to make a weather forecast about the weather depending on strings, which you receive from the console.
Every string consists of data about the city, average temperature and weather type. You will receive strings until
you receive the command “end”.
Every valid weather forecast consists of:
 Two Latin capital letters, which represent the code of the city
 Immediately followed by a floating-point number, which will represent the average temperature. Numbers
without a floating point are not considered valid.
 Followed by the type of weather, which will consist of uppercase and lowercase Latin letters, starts
immediately after the temperature and ends at the first occurrence of the sign ‘|’
If you receive input, which does not follow the rules above – ignore it.
If you receive a new temperature and/or type of weather for a city, which already exists – rewrite the previous
values.
At the end, print the temperature and weather type for every city. Order the cities by average temperature in
ascending order.
-Input
You will receive strings until you receive the command “end”.
-Output
Print all cities ordered by average temperature in ascending order. Use the following format:
    “{nameOfTheCity} => {averageTemperature} => {typeOfWeather}”
Format the temperature to the 2 nd decimal place.
-Constraints
 The average temperature will be in the interval [0.00…50.00]
 The floating-point numbers will have at most 2 digits after the floating point.
 */
package com.company;
// 100/100
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Weather {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Pattern pattern = Pattern.compile("([A-Z]{2})([1-9]{1,}.[1-9]{1,})([A-Za-z]+)\\|");
        HashMap<String, Double> cityTemp = new HashMap<>();
        HashMap<String, String> cityWeather = new HashMap<>();

        String input = reader.readLine();
        while (!input.equals("end"))
        {
            Matcher matcher = pattern.matcher(input);

            if (matcher.find())
            {
                AddInfo(cityTemp, cityWeather, matcher.group(1), matcher.group(2), matcher.group(3));
            }

            input = reader.readLine();
        }

        PrintResult(cityTemp, cityWeather);
    }

    private static void PrintResult(HashMap<String, Double> cityTemp, HashMap<String, String> cityWeather)
    {
        cityTemp.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue)).forEach( c -> {
            System.out.print(String.format("%s => ", c.getKey()));
            System.out.print(String.format("%.2f => ", c.getValue()));
            System.out.print(String.format("%s%n", cityWeather.get(c.getKey())));
        });
    }

    private static void AddInfo(HashMap<String, Double> cityTemp, HashMap<String, String> cityWeather,String matchCit, String matchTem, String matchWeath)
    {
        String city = matchCit.trim();
        Double temperature = Double.parseDouble(matchTem.trim());
        String weather = matchWeath.trim();

        if (!cityTemp.containsKey(city)) {
            cityTemp.put(city, temperature);
            cityWeather.put(city, weather);
        }
        else {
            cityTemp.replace(city, temperature);
            cityWeather.replace(city, weather);
        }

    }

}

/*
Examples

<< INPUT >>
PB23.41Rainy|ASDASD
SDASCA20.21sUNNY|SDASD
asdaCA22.5rainy|sada
CA23.41cloydy
end
<< OUTPUT >>
CA => 22.50 => rainy
PB => 23.41 => Rainy

***********************

<< INPUT >>
invalidKA31.41|sunny|
validCA12.41Rainy|absad
gfASFasASPA31.21cloudy|asd
YA21.51sunny|
sadL21.41rainy|adas
end
<< OUTPUT >>
CA => 12.41 => Rainy
YA => 21.51 => sunny
PA => 31.21 => cloudy
 */