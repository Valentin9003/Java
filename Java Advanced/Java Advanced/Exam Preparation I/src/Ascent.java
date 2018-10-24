import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ascent {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Pattern pattern = Pattern.compile("(,|_)([a-zA-Z]+)(\\d)");
        ArrayList<String> text = new ArrayList<>();
        LinkedHashMap<String, String> memos = new LinkedHashMap<>();

        String commandLine = reader.readLine();

        while (!commandLine.equals("Ascend")) {
            text.add(commandLine);
            commandLine = reader.readLine();
        }

        for (int i = 0; i < text.size(); i++) {
            for (String m : memos.keySet()) {
                text.set(i, text.get(i).replaceAll(m, memos.get(m)));
            }
            Matcher matcher = pattern.matcher(text.get(i));
            while (matcher.find()) {
                StringBuilder replacement = new StringBuilder("");
                if (matcher.group(1).equals(",")) {
                    for (Character ch : matcher.group(2).toCharArray()) {
                        replacement.append((char) ((int) ch + Integer.parseInt(matcher.group(3))));
                    }
                } else {
                    for (Character ch : matcher.group(2).toCharArray()) {
                        replacement.append((char) ((int) ch - Integer.parseInt(matcher.group(3))));
                    }
                }
                text.set(i, text.get(i).replace(matcher.group(), replacement.toString()));
                memos.put(matcher.group(), replacement.toString());
            }
            System.out.println(text.get(i));
        }
    }
}
