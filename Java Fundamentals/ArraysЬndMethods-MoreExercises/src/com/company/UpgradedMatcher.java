package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UpgradedMatcher {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> productsNamesList = new ArrayList<>(Arrays.asList(reader.readLine().split("\\s")));
        List<Long> quantitiesList = Arrays.stream(reader.readLine().split("\\s")).map(Long::valueOf).collect(Collectors.toList());
        List<String> productPriceList = new ArrayList<>(Arrays.asList(reader.readLine().split("\\s")));

        ArrayList<String> purchaiseProductQuantity = new ArrayList<>(Arrays.asList(reader.readLine().split("\\s+")));

        //Till the input isn't "done" do that.....
        while (!purchaiseProductQuantity.get(0).equals("done"))
        {   //checking if our productNamesList have the purchase product
            if (productsNamesList.contains(purchaiseProductQuantity.get(0)))
            {
                //get the index on the purchase product from ProductNamesList
                int index = productsNamesList.indexOf(purchaiseProductQuantity.get(0));
                //Get the price on the product by index from productPriceList
                Double price = Double.parseDouble(productPriceList.get(index));
                //quantity have at the moment --> checking with method
                long quantityInTheWarehous = CheckingForQuantity(quantitiesList, index);
                //Purchase quantity --> parseToLong from String
                long purchaseQuantity = Long.parseLong(purchaiseProductQuantity.get(1));
                //quantity at the moment - purchase quantity
                long calculateQuantityAfterPurchase = quantityInTheWarehous - purchaseQuantity;

                //If we don't have of this product or have more less than the purchase
                if (quantityInTheWarehous == 0 || calculateQuantityAfterPurchase < 0)
                {
                    //Print we don't have
                    System.out.printf("We do not have enough %s%n", purchaiseProductQuantity.get(0));
                }
                //Else If we have enough quantity of this product
                else {
                    //Calculate the new quantity with which we will still
                    quantitiesList.set(index, calculateQuantityAfterPurchase);
                    //Calculate the cost on the purchase
                    double cost = price * purchaseQuantity;
                    //Print product -> purchase quantity -> costs
                    System.out.printf("%s x %d costs %.2f%n", purchaiseProductQuantity.get(0), purchaseQuantity, cost);
                }
            }
            //read next purchase till While is True
            purchaiseProductQuantity = new ArrayList<>(Arrays.asList(reader.readLine().split("\\s+")));
        }
    }
    //Method -> checking for quantity in the warehouse
    private static long CheckingForQuantity(List<Long> quantities, int index)
    {
        long quantity = 0;
        if (index < quantities.size()) {
            quantity += quantities.get(index);
        }
        return quantity;
    }
}
