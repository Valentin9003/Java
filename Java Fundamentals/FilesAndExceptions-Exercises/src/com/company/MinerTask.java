package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.List;

public class MinerTask {
    public static void main(String[] args) throws Exception {

        Writer writerInput = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("inputP05.txt"), "utf-8"));
            {
               writerInput.write("Gold\n");
               writerInput.write("155\n");
               writerInput.write("Silver\n");
               writerInput.write("10\n");
               writerInput.write("Copper\n");
               writerInput.write("17\n");
               writerInput.write("stop");
            }
        writerInput.close();

        List<String> inputList = Files.readAllLines(Paths.get("inputP05.txt"));
        inputList.remove(inputList.size() - 1);

        LinkedHashMap<String, Long> resultMap = new LinkedHashMap<>();
        for (int i = 0; i < inputList.size(); i += 2) {
            String bufferRss = inputList.get(i);
            String bufferQuantity = inputList.get(i + 1);
            AddRssAndQuantity(resultMap, bufferRss, bufferQuantity);
        }

        Writer writerOutpu = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("outputP05.txt"), "utf-8"));
            {
                for (String rss : resultMap.keySet()) {
                    writerOutpu.write(String.format("%s -> %d%n", rss, resultMap.get(rss)));
                }
            }
        writerOutpu.close();
    }

    private static void AddRssAndQuantity(LinkedHashMap<String, Long> resultMap, String bufferRss, String bufferQuantity)
    {
        if (!resultMap.containsKey(bufferRss)) {
            long value = Long.parseLong(bufferQuantity);
            resultMap.put(bufferRss, value);
        } else {
            long value = resultMap.get(bufferRss);
            value += Long.parseLong(bufferQuantity);
            resultMap.replace(bufferRss, value);
        }
    }
}
