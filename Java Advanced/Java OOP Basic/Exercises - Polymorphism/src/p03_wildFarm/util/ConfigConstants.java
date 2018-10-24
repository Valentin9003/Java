package p03_wildFarm.util;

public final class ConfigConstants {

    public static final String STOP = "End";
    public static final String CAT_TYPE = "Cat";
    public static final String TIGER_TYPE = "Tiger";
    public static final String ZEBRA_TYPE = "Zebra";
    public static final String MOUSE_TYPE = "Mouse";
    public static final String FOOD_TYPE_VEGETABLE = "Vegetable";
    public static final String FOOD_TYPE_MEAT = "Meat";

    public static final int TYPE_INDEX = 0;
    public static final int NAME_INDEX = 1;
    public static final int QUANTITY_INDEX = 1;
    public static final int WEIGHT_INDEX = 2;
    public static final int LIVING_REGION_INDEX = 3;
    public static final int BREED_INDEX = 4;

    public static final String MAMMAL_TO_STRING_PATTERN = "%s[%s, %s, %s, %d]";
    public static final String CAT_TO_STRING_PATTERN = "%s[%s, %s, %s, %s, %d]";
    public static final String DECIMAL_FORMAT_PATTERN = "##########.##";

    private ConfigConstants() {
    }
}
