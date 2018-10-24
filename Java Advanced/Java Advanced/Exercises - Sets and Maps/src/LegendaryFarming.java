import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class LegendaryFarming {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<String, Integer> keyMaterials = new TreeMap<>();
        keepTrackOfTheKeyMaterials(keyMaterials);
        TreeMap<String, Integer> junkItems  = new TreeMap<>();

        boolean haveWinner = false;
        while (true) {
            if (haveWinner) {
                break;
            }
            String[] farming = reader.readLine().split(" ");
            for (int i = 0; i < farming.length; i+=2) {
                int quantity = Integer.parseInt(farming[i]);
                String materialName = farming[i+1].toLowerCase();
                haveWinner = fillMaterialsDB(keyMaterials, quantity, materialName, junkItems);
                if (haveWinner) {
                    break;
                }
            }
        }
        
        printObtainedItem(keyMaterials);
        printKeyMaterials(keyMaterials);
        printJunkItemsMaterials(junkItems);
    }

    private static void printJunkItemsMaterials(TreeMap<String, Integer> junkItems) {
        junkItems
                .forEach((key, value) ->
                        System.out.println(String.format("%s: %d", key, value)));
    }

    private static void printKeyMaterials(TreeMap<String, Integer> keyMaterials) {
        keyMaterials.entrySet()
                .stream()
                .sorted((m1,m2) -> m2.getValue().compareTo(m1.getValue()))
                .forEach(m -> {
                    System.out.println(String.format("%s: %d", m.getKey(), m.getValue()));
                });
    }

    private static void keepTrackOfTheKeyMaterials(TreeMap<String, Integer> materials) {
        // Shards, Fragments and Motes are the key materials
        materials.putIfAbsent("shards", 0);
        materials.putIfAbsent("fragments", 0);
        materials.putIfAbsent("motes", 0);
    }

    private static void printObtainedItem(TreeMap<String, Integer> materials) {
        materials.entrySet().forEach(m -> {
            if (m.getValue() >= 250) {
                String materialForObtaining = m.getKey();
                checkMaterilObtainAndPrint(materialForObtaining);
                materials.replace(m.getKey(), m.getValue() - 250);
            }
        });
    }

    private static void checkMaterilObtainAndPrint(String materialForObtaining) {
        /*
        •	Shadowmourne – requires 250 Shards;
        •	Valanyr – requires 250 Fragments;
        •	Dragonwrath – requires 250 Motes;
         */
        StringBuilder obtainedItem = new StringBuilder();
        switch (materialForObtaining) {
            case "shards":
                obtainedItem.append("Shadowmourne");
                break;
            case "fragments":
                obtainedItem.append("Valanyr");
                break;
            case "motes":
                obtainedItem.append("Dragonwrath");
                break;
        }
        obtainedItem.append(" obtained!");
        System.out.println(obtainedItem.toString());
    }

    private static boolean fillMaterialsDB(TreeMap<String, Integer> keyMaterials, int quantity, String materialName, TreeMap<String, Integer> junkItems) {
        if (keyMaterials.containsKey(materialName)) {
            int newQuantity = keyMaterials.get(materialName) + quantity;
            keyMaterials.replace(materialName, newQuantity);

            return keyMaterials.get(materialName) >= 250;
        } else {
            if (junkItems.containsKey(materialName)) {
                int newQuantity = junkItems.get(materialName) + quantity;
                junkItems.replace(materialName, newQuantity);
            }
            junkItems.putIfAbsent(materialName, quantity);
        }
        
        return false;
    }

    private static boolean haveObtainedItem(TreeMap<String, Integer> materials) {
        for (String material : materials.keySet()) {
            if (materials.get(material) >= 250) {
                return true;
            }
        }
        return false;
    }
}
