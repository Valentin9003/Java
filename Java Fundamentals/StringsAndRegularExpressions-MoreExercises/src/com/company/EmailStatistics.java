package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailStatistics {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        Pattern pattern = Pattern.compile("(\\b[A-Za-z]{5,}@[a-z]{3,}((.bg)|(.com)|(.org))\\b)");
        ArrayList<String> emailsList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String email = reader.readLine();

            Matcher matcher = pattern.matcher(email);
            if (matcher.find()) {
                emailsList.add(matcher.group());
            }
        }

        LinkedHashMap<String, Integer> hostCount = new LinkedHashMap<>();
        LinkedHashMap<String, List<String>> hostUsername = new LinkedHashMap<>();

        AddHostUsernameCount(emailsList, hostCount, hostUsername);

        PrintResult(hostCount, hostUsername);
    }

    private static void PrintResult(LinkedHashMap<String, Integer> hostCount, LinkedHashMap<String, List<String>> hostUsername)
    {
        hostCount.entrySet().stream().sorted((x1, x2) -> x2.getValue().compareTo(x1.getValue())).forEach( x -> {
            System.out.println(x.getKey() + ":");
            for (String host : hostUsername.keySet()) {
                if (host.equals(x.getKey())) {
                    for (String userName : hostUsername.get(host)) {
                        System.out.println(String.format("### %s", userName));
                    }
                }
            }
        });
    }

    private static void AddHostUsernameCount(ArrayList<String> emailsList, LinkedHashMap<String, Integer> hostCountMap, LinkedHashMap<String, List<String>> hostUsernameMap)
    {
        Pattern patternUser = Pattern.compile("\\b(\\w+)@");
        Pattern patternHost = Pattern.compile("@(\\w+.\\w+)\\b");

        for (String mail : emailsList)
        {
            Matcher matcherUser = patternUser.matcher(mail);
            Matcher matcherHost = patternHost.matcher(mail);

            if (matcherUser.find() && matcherHost.find())
            {
                String userName = matcherUser.group(1);
                String hostDomain = matcherHost.group(1);

                UpdateHashMaps(hostCountMap, hostUsernameMap, userName, hostDomain);
            }
        }
    }

    private static void UpdateHashMaps(LinkedHashMap<String, Integer> hostCountMap, LinkedHashMap<String, List<String>> hostUsernameMap, String userName, String hostDomain)
    {
        if (!hostUsernameMap.containsKey(hostDomain))
        {
            hostUsernameMap.put(hostDomain, new ArrayList<>());
            hostUsernameMap.get(hostDomain).add(userName);

            hostCountMap.put(hostDomain, 1);
        } else {
            if (!hostUsernameMap.get(hostDomain).contains(userName)) {
                hostUsernameMap.get(hostDomain).add(userName);

                int count = hostCountMap.get(hostDomain) + 1;
                hostCountMap.replace(hostDomain, count);
            }
        }
    }
}
