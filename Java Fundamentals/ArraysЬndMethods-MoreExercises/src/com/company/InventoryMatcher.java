package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InventoryMatcher {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> productsNames = new ArrayList<>(Arrays.asList(reader.readLine().split("\\s")));
        List<Long> quantities = Arrays.stream(reader.readLine().split("\\s")).map(Long::valueOf).collect(Collectors.toList());
        List<String> productPrice = new ArrayList<>(Arrays.asList(reader.readLine().split("\\s")));

        String product = reader.readLine();
        while (!product.equals("done"))
        {
            if (productsNames.contains(product)) {
                int index = productsNames.indexOf(product);
                String price = productPrice.get(index);
                long quantity = quantities.get(index);
                System.out.printf("%s costs: %s; Available quantity: %d%n", product, price, quantity);
            }

            product = reader.readLine();
        }
    }
}
