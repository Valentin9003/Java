import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DragonArmy {

    private static final int DEFAULT_HEALTH = 250;
    private static final int DEFAULT_DAMAGE = 45;
    private static final int DEFAULT_ARMOR = 10;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //MapDB is LinkedHashMap<TypeColor, TreeMap<Name, Dragon>>
        LinkedHashMap<String, TreeMap<String, Dragon>> mapDB = new LinkedHashMap<>();

        int numberOfDragons = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numberOfDragons; i++) {
            String[] tokens = reader.readLine().split("\\s+");
            if (tokens.length == 5) {
                fillDatabase(mapDB, tokens);
            }
        }

        printResult(mapDB);
    }

    private static void printResult(LinkedHashMap<String, TreeMap<String, Dragon>> mapDB) {
        for (String colorType : mapDB.keySet()) {
            //Printing the type with his AVG stats
            printColorTypeAndAverageStats(mapDB.get(colorType), colorType);

            //Printing all Dragons from this type
            for (String dragonName : mapDB.get(colorType).keySet()) {
                System.out.println(mapDB.get(colorType).get(dragonName).toString());
            }
        }
    }

    private static void printColorTypeAndAverageStats(TreeMap<String, Dragon> nameDragonMap, String colorType) {
        double totalDMG = 0.0;
        double totalHLT = 0.0;
        double totalAMR = 0.0;

        for (String dragonName : nameDragonMap.keySet()) {
            totalDMG += nameDragonMap.get(dragonName).getDamage();
            totalHLT += nameDragonMap.get(dragonName).getHealth();
            totalAMR += nameDragonMap.get(dragonName).getArmor();
        }

        double avgDMG = totalDMG / nameDragonMap.size();
        double avgHLT = totalHLT / nameDragonMap.size();
        double avgAMR = totalAMR / nameDragonMap.size();

        System.out.println(String.format("%s::(%.2f/%.2f/%.2f)",
                colorType, avgDMG, avgHLT, avgAMR));
    }

    private static void fillDatabase(LinkedHashMap<String, TreeMap<String, Dragon>> mapDB, String[] tokens) {
        String type = tokens[0];
        String name = tokens[1];
        Integer damage = extractValue(tokens[2], DEFAULT_DAMAGE);
        Integer health = extractValue(tokens[3], DEFAULT_HEALTH);
        Integer armor = extractValue(tokens[4], DEFAULT_ARMOR);

        Dragon dragon = new Dragon(name, type, damage, health, armor);
        fillTypeNameDragonDB(mapDB, dragon);

    }

    private static void fillTypeNameDragonDB(LinkedHashMap<String, TreeMap<String, Dragon>> mapDB, Dragon dragon) {
        if (!mapDB.containsKey(dragon.getType())) {
        //If in DB DON'T have this TypeColor Dragon
            mapDB.put(dragon.getType(), new TreeMap<>());
            mapDB.get(dragon.getType()).put(dragon.getName(), dragon);
        } else {
        //If in DB have already this TypeColor Dragon
            if (!mapDB.get(dragon.getType()).containsKey(dragon.getName())) {
            //If in DB DON'T have Dragon with this name
                mapDB.get(dragon.getType()).put(dragon.getName(), dragon);
            } else {
            //If in DB have already Dragon with this name
                mapDB.get(dragon.getType()).replace(dragon.getName(), dragon);
            }
        }
    }

    private static Integer extractValue(String token, int defaultValue) {
        Integer value = 0;
        try {
            value = Integer.parseInt(token);
        } catch (NumberFormatException nfe) {
            value = defaultValue;
        }
        return value;
    }
}

class Dragon {
    private String name;
    private String type;
    private Integer damage;
    private Integer health;
    private Integer armor;

    public Dragon(String name, String type, Integer damage, Integer health, Integer armor) {
        this.name = name;
        this.type = type;
        this.damage = damage;
        this.health = health;
        this.armor = armor;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public Integer getDamage() {
        return damage;
    }

    public Integer getHealth() {
        return health;
    }

    public Integer getArmor() {
        return armor;
    }

    @Override
    public String toString() {
        //-Bazgargal -> damage: 100, health: 2500, armor: 25
        StringBuilder sb = new StringBuilder();
        sb.append(
                String.format("-%s -> damage: %d, health: %d, armor: %d",
                        this.name,
                        this.damage,
                        this.health,
                        this.armor));
        return sb.toString();
    }
}
