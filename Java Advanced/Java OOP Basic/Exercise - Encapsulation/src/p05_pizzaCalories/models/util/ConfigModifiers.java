package p05_pizzaCalories.models.util;

import java.util.HashMap;
import java.util.Map;

public final class ConfigModifiers {

    public static final Map<String, Double> DOUGH_MODIFIERS = new HashMap<>() {{
        put("White", 1.5);
        put("Wholegrain", 1.0);
        put("Crispy", 0.9);
        put("Chewy", 1.1);
        put("Homemade", 1.0);
    }};

    public static final Map<String, Double> TOPPINGS_MODIFIERS = new HashMap<>() {{
        put("Meat", 1.2);
        put("Veggies", 0.8);
        put("Cheese", 1.1);
        put("Sauce", 0.9);
    }};

    private ConfigModifiers() {
    }
}
