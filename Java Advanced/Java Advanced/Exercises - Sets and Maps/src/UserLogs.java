import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class UserLogs {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TreeMap<String, LinkedHashMap<String, Integer>> userMap = new TreeMap<>();
        String input = reader.readLine();

        while (!input.equals("end"))
        {
            String[] elements = input.split(" ");
            String ip = elements[0].substring(3);
            String userName = elements[2].substring(5);

            if (!userMap.containsKey(userName))
            {
                userMap.put(userName, new LinkedHashMap<>());
                addIPtoUser(userMap.get(userName), ip);
            } else
            {
                addIPtoUser(userMap.get(userName), ip);
            }


            input = reader.readLine();
        }

        printUsers(userMap);

    }

    private static void printUsers(TreeMap<String, LinkedHashMap<String, Integer>> userMap)
    {
        for (String user : userMap.keySet()) {
            System.out.println(String.format("%s: ", user));

            int brRow = userMap.get(user).keySet().size();
            for (String ip : userMap.get(user).keySet()) {
                if (brRow != 1) {
                    System.out.print(String.format("%s => %d, ", ip, userMap.get(user).get(ip)));
                } else {
                    System.out.print(String.format("%s => %d.%n", ip, userMap.get(user).get(ip)));
                }
                brRow--;
            }
        }
    }

    private static void addIPtoUser(LinkedHashMap<String, Integer> ipHashMap, String ip)
    {
        if (!ipHashMap.containsKey(ip))
        {
            int value = 1;
            ipHashMap.put(ip, value);
        } else
        {
            int value = ipHashMap.get(ip);
            value++;
            ipHashMap.replace(ip, value);
        }
    }
}
