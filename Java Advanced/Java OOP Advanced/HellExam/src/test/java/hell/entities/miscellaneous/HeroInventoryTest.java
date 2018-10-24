package hell.entities.miscellaneous;

import hell.interfaces.Inventory;
import hell.interfaces.Item;
import hell.interfaces.Recipe;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HeroInventoryTest {

    private static final int MAX_INT_VALUE = Integer.MAX_VALUE;
    private static final String STRENGTH_MESSAGE = "Strength is not correct";
    private static final String AGILITY_MESSAGE = "Agility is not correct";
    private static final String INTELLIGENCE_MESSAGE = "Intelligence is not correct";
    private static final String HIT_POINTS_MESSAGE = "HitPoints is not correct";
    private static final String DAMAGE_MESSAGE = "Damage is not correct";

    private Inventory inventory;

    @Before
    public void setUp() throws Exception {
        this.inventory = new HeroInventory();
    }

    private Item createMockCommonItem() {
        Item commonItem = Mockito.mock(Item.class);

        Mockito.when(commonItem.getAgilityBonus()).thenReturn(MAX_INT_VALUE);
        Mockito.when(commonItem.getDamageBonus()).thenReturn(MAX_INT_VALUE);
        Mockito.when(commonItem.getHitPointsBonus()).thenReturn(MAX_INT_VALUE);
        Mockito.when(commonItem.getIntelligenceBonus()).thenReturn(MAX_INT_VALUE);
        Mockito.when(commonItem.getStrengthBonus()).thenReturn(MAX_INT_VALUE);

        return commonItem;
    }

    private void seedCommonItems() {
        Item commonItemMock1 = this.createMockCommonItem();
        Mockito.when(commonItemMock1.getName()).thenReturn("commonItemMock1");

        Item commonItemMock2 = this.createMockCommonItem();
        Mockito.when(commonItemMock2.getName()).thenReturn("commonItemMock2");

        Item commonItemMock3 = this.createMockCommonItem();
        Mockito.when(commonItemMock3.getName()).thenReturn("commonItemMock3");

        this.inventory.addCommonItem(commonItemMock1);
        this.inventory.addCommonItem(commonItemMock2);
        this.inventory.addCommonItem(commonItemMock3);
    }

    private void seedRecipeItem() {
        Recipe recipeMock = Mockito.mock(Recipe.class);

        List<String> requiredItems = new ArrayList<>();
        requiredItems.add("commonItemMock1");
        requiredItems.add("commonItemMock2");
        requiredItems.add("commonItemMock4");

        Mockito.when(recipeMock.getRequiredItems()).thenReturn(requiredItems);

        this.inventory.addRecipeItem(recipeMock);
    }

    @Test
    public void getTotalStrengthBonus() {
        // Arrange
        this.seedCommonItems();

        // Act
        long actual = this.inventory.getTotalStrengthBonus();
        long expected = 3L * MAX_INT_VALUE;

        // Assert
        Assert.assertEquals(STRENGTH_MESSAGE, expected, actual);
    }

    @Test
    public void getTotalAgilityBonus() {
        // Arrange
        this.seedCommonItems();

        // Act
        long actual = this.inventory.getTotalAgilityBonus();
        long expected = 3L * MAX_INT_VALUE;

        // Assert
        Assert.assertEquals(AGILITY_MESSAGE, expected, actual);
    }

    @Test
    public void getTotalIntelligenceBonus() {
        // Arrange
        this.seedCommonItems();

        // Act
        long actual = this.inventory.getTotalIntelligenceBonus();
        long expected = 3L * MAX_INT_VALUE;

        // Assert
        Assert.assertEquals(INTELLIGENCE_MESSAGE, expected, actual);
    }

    @Test
    public void getTotalHitPointsBonus() {
        // Arrange
        this.seedCommonItems();

        // Act
        long actual = this.inventory.getTotalHitPointsBonus();
        long expected = 3L * MAX_INT_VALUE;

        // Assert
        Assert.assertEquals(HIT_POINTS_MESSAGE, expected, actual);
    }

    @Test
    public void getTotalDamageBonus() {
        // Arrange
        this.seedCommonItems();

        // Act
        long actual = this.inventory.getTotalDamageBonus();
        long expected = 3L * MAX_INT_VALUE;

        // Assert
        Assert.assertEquals(DAMAGE_MESSAGE, expected, actual);
    }

    @Test
    public void addCommonItem() {
        // Arrange
        this.seedCommonItems();
        this.seedRecipeItem();
        Item commonItemMock4 = Mockito.mock(Item.class);
        Mockito.when(commonItemMock4.getName()).thenReturn("commonItemMock4");

        // Act
        this.inventory.addCommonItem(commonItemMock4);
        int actualCountOfCommonItems = 0;

        try {
            Field commonItemsField = this.inventory.getClass().getDeclaredField("commonItems");
            commonItemsField.setAccessible(true);
            Map<String, Item> commonItemsMap = (Map<String, Item>) commonItemsField.get(this.inventory);
            actualCountOfCommonItems = commonItemsMap.size();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        int expectedCountOfCommonItems = 2;

        // Assert
        Assert.assertEquals(expectedCountOfCommonItems, actualCountOfCommonItems);
    }

    @Test
    public void addRecipeItem() {
        // Arrange
        Recipe recipeMock = Mockito.mock(Recipe.class);

        // Act
        this.inventory.addRecipeItem(recipeMock);
        int actualCountOfRecipes = 0;

        try {
            Field recipesField = this.inventory.getClass().getDeclaredField("recipeItems");
            recipesField.setAccessible(true);
            Map<String, Recipe> recipesMap = (Map<String, Recipe>) recipesField.get(this.inventory);
            actualCountOfRecipes = recipesMap.size();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        int expectedCountOfRecipes = 1;

        // Assert
        Assert.assertEquals(expectedCountOfRecipes, actualCountOfRecipes);
    }
}