package com.company.StringsMapsAndStreamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class URLParser {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] inputArr = reader.readLine().split("://");

        parseURL(inputArr);
    }

    private static void parseURL(String[] inputArr) {
        String protocol = "";
        String server;
        String resource = "";

        if (inputArr.length > 1) {
            protocol = inputArr[0];

            String[] serverAndResources = inputArr[1].split("/");
            server = serverAndResources[0].trim();
            if (serverAndResources.length > 1) {
                resource = getResources(inputArr, server);
            }
        } else {
            String[] serverAndResources = inputArr[0].split("/");
            server = serverAndResources[0].trim();
            if (serverAndResources.length > 1) {
                resource = getResources(inputArr, server);
            }
        }

        printResult(protocol, server, resource);
    }

    private static void printResult(String protocol, String server, String resource) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("[protocol] = \"%s\"%n", protocol));
        sb.append(String.format("[server] = \"%s\"%n", server));
        sb.append(String.format("[resource] = \"%s\"", resource));

        System.out.println(sb.toString());
    }

    private static String getResources(String[] inputArr, String server) {
        String resource;
        resource = inputArr[1].replaceFirst(server, "").trim();
        resource = resource.replaceFirst("/", "");
        return resource;
    }
}
