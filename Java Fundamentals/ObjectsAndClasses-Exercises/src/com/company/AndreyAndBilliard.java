package com.company;

// 80/100 --> need every client to can buy more than one thing **for rewriting
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class AndreyAndBilliard {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Double> menu = new HashMap<>();
        List<Client> clientList = new ArrayList<>();

        int numberPrices = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numberPrices; i++) {
            String[] input = reader.readLine().split("-");
            AddInMenu(menu, input);
        }

        String[] command = reader.readLine().split("[,\\-]+");
        while (!command[0].equals("end of clients"))
        {
            AddClientWishes(clientList, command);
            command = reader.readLine().split("[,\\-]+");
        }

        CheckListNote(menu, clientList);

    }

    private static void CheckListNote(HashMap<String, Double> menu, List<Client> clientList)
    {
        TreeMap<String, HashMap<String, Double>> result = new TreeMap<>();
        HashMap<String, Integer> brHashMap = new HashMap<>();

        double totalBill = 0.0;
        for (Client client : clientList) {
            for (String articul : menu.keySet()) {
                if (articul.equals(client.Articule)) {

                    double sum = client.Count * menu.get(articul);
                    totalBill += sum;
                    AddResults(client, sum, result);
                    AddCountHashMap(brHashMap, client);
                }
            }
        }

        for (String clientName : result.keySet()) {
            for (String artic : result.get(clientName).keySet()) {
                System.out.println(clientName);
                System.out.println(String.format("-- %s - %d", artic, brHashMap.get(clientName)));
                System.out.println(String.format("Bill: %.2f", result.get(clientName).get(artic)));
            }
        }
        System.out.println(String.format("Total bill: %.2f", totalBill));
    }

    private static void AddCountHashMap(HashMap<String, Integer> brHashMap, Client client)
    {
        if (!brHashMap.containsKey(client.Name)) {
            brHashMap.put(client.Name, client.Count);
        } else {
            int count = brHashMap.get(client.Name);
            count += client.Count;
            brHashMap.replace(client.Name, count);
        }
    }

    private static void AddResults(Client client, double sum, TreeMap<String, HashMap<String, Double>> result)
    {
        if (!result.containsKey(client.Name)) {
            result.put(client.Name, new HashMap<>());
            result.get(client.Name).put(client.Articule, sum);
        } else {
            sum += result.get(client.Name).get(client.Articule);
            result.get(client.Name).put(client.Articule, sum);
        }
    }

    private static void AddClientWishes(List<Client> clientList, String[] command)
    {
        Client client = new Client();
        client.Name = command[0];
        client.Articule = command[1];
        client.Count = Integer.parseInt(command[2]);

        clientList.add(client);
    }

    private static void AddInMenu(HashMap<String, Double> menu, String[] input)
    {
        Prices articul = new Prices();
        articul.Name = input[0];
        articul.Price = Double.parseDouble(input[1]);

        if (!menu.containsKey(articul.Name)) {
            menu.put(articul.Name, articul.Price);
        } else {
            menu.replace(articul.Name, articul.Price);
        }

    }
}

class Prices
{
    String Name;
    Double Price;

}
class Client
{
    String Name;
    String Articule;
    int Count;
}