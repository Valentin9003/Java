package panzer.models.miscellaneous;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import panzer.contracts.Assembler;
import panzer.contracts.AttackModifyingPart;
import panzer.contracts.DefenseModifyingPart;
import panzer.contracts.HitPointsModifyingPart;

import java.math.BigDecimal;

public class VehicleAssemblerTest {

    private static final String DEFAULT_MSG = "Test failed. Wrong result: ";
    private static final int DEFAULT_ATTACK_MODIFIER = 123123;
    private static final int DEFAULT_DEFENSE_MODIFIER = 350;
    private static final int DEFAULT_HIT_POINTS_MODIFIER = 1250;
    private static final int DEFAULT_TOTAL_PRICE = 21;
    private static final double DEFAULT_DELTA = 0.1;
    private static final double DEFAULT_TOTAL_WEIGHT = 45D;
    private static final double DEFAULT_ATTACK_WEIGHT = 10D;
    private static final double DEFAULT_DEFENSE_WEIGHT = 15D;
    private static final double DEFAULT_HIT_POINTS_WEIGHT = 20D;

    private Assembler assembler;
    private AttackModifyingPart fakeAttModifyingPart;
    private DefenseModifyingPart fakeDefModifyPart;
    private HitPointsModifyingPart fakeHitPtModifyPart;

    @Before
    public void initializer() {
        this.assembler = new VehicleAssembler();

        this.fakeAttModifyingPart = Mockito.mock(AttackModifyingPart.class);
        this.fakeDefModifyPart = Mockito.mock(DefenseModifyingPart.class);
        this.fakeHitPtModifyPart = Mockito.mock(HitPointsModifyingPart.class);

        assembler.addArsenalPart(this.fakeAttModifyingPart);
        assembler.addShellPart(this.fakeDefModifyPart);
        assembler.addEndurancePart(this.fakeHitPtModifyPart);
    }

    @Test
    public void getTotalWeight() {
        Mockito.when(this.fakeAttModifyingPart.getWeight()).thenReturn(DEFAULT_ATTACK_WEIGHT);
        Mockito.when(this.fakeDefModifyPart.getWeight()).thenReturn(DEFAULT_DEFENSE_WEIGHT);
        Mockito.when(this.fakeHitPtModifyPart.getWeight()).thenReturn(DEFAULT_HIT_POINTS_WEIGHT);

        double actual = this.assembler.getTotalWeight();
        double expected = DEFAULT_TOTAL_WEIGHT;

        Assert.assertEquals(DEFAULT_MSG, expected, actual, DEFAULT_DELTA);
    }

    @Test
    public void getTotalPrice() {
        Mockito.when(this.fakeAttModifyingPart.getPrice()).thenReturn(BigDecimal.TEN);
        Mockito.when(this.fakeDefModifyPart.getPrice()).thenReturn(BigDecimal.ONE);
        Mockito.when(this.fakeHitPtModifyPart.getPrice()).thenReturn(BigDecimal.TEN);

        BigDecimal actual = this.assembler.getTotalPrice();
        BigDecimal expected = BigDecimal.valueOf(DEFAULT_TOTAL_PRICE);

        Assert.assertEquals(DEFAULT_MSG, expected, actual);
    }

    @Test
    public void getTotalAttackModification() {
        AttackModifyingPart mockAttModify = Mockito.mock(AttackModifyingPart.class);
        this.assembler.addArsenalPart(mockAttModify);
        Mockito.when(mockAttModify.getAttackModifier()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(this.fakeAttModifyingPart.getAttackModifier()).thenReturn(Integer.MAX_VALUE);

        long actual = this.assembler.getTotalAttackModification();
        long expected = (long) Integer.MAX_VALUE + Integer.MAX_VALUE;

        Assert.assertEquals(DEFAULT_MSG, expected, actual);
    }

    @Test
    public void getTotalDefenseModification() {
        DefenseModifyingPart mockDefModify = Mockito.mock(DefenseModifyingPart.class);
        this.assembler.addShellPart(mockDefModify);
        Mockito.when(mockDefModify.getDefenseModifier()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(this.fakeDefModifyPart.getDefenseModifier()).thenReturn(Integer.MAX_VALUE);

        long actual = this.assembler.getTotalDefenseModification();
        long expected = (long)Integer.MAX_VALUE * 2;

        Assert.assertEquals(DEFAULT_MSG, expected, actual);
    }

    @Test
    public void getTotalHitPointModification() {
        HitPointsModifyingPart mockHitPtModify = Mockito.mock(HitPointsModifyingPart.class);
        this.assembler.addEndurancePart(mockHitPtModify);
        Mockito.when(mockHitPtModify.getHitPointsModifier()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(this.fakeHitPtModifyPart.getHitPointsModifier()).thenReturn(Integer.MAX_VALUE);

        long actual = this.assembler.getTotalHitPointModification();
        long expected = (long)Integer.MAX_VALUE * 2;

        Assert.assertEquals(DEFAULT_MSG, expected, actual);
    }

    @Test
    public void addArsenalPart() {
        AttackModifyingPart mockAttModifyPart = Mockito.mock(AttackModifyingPart.class);
        this.assembler.addArsenalPart(mockAttModifyPart);
        Mockito.when(mockAttModifyPart.getAttackModifier()).thenReturn(DEFAULT_ATTACK_MODIFIER);
        Mockito.when(this.fakeAttModifyingPart.getAttackModifier()).thenReturn(DEFAULT_ATTACK_MODIFIER);

        long actual = this.assembler.getTotalAttackModification();
        long expected = DEFAULT_ATTACK_MODIFIER * 2;

        Assert.assertEquals(DEFAULT_MSG, expected, actual);
    }

    @Test
    public void addShellPart() {
        DefenseModifyingPart mockDefModifyPart = Mockito.mock(DefenseModifyingPart.class);
        this.assembler.addShellPart(mockDefModifyPart);
        Mockito.when(mockDefModifyPart.getDefenseModifier()).thenReturn(DEFAULT_DEFENSE_MODIFIER);
        Mockito.when(this.fakeDefModifyPart.getDefenseModifier()).thenReturn(DEFAULT_DEFENSE_MODIFIER);

        long actual = this.assembler.getTotalDefenseModification();
        long expected = DEFAULT_DEFENSE_MODIFIER * 2;

        Assert.assertEquals(DEFAULT_MSG, expected, actual);
    }

    @Test
    public void addEndurancePart() {
        HitPointsModifyingPart mockHitPoints = Mockito.mock(HitPointsModifyingPart.class);
        this.assembler.addEndurancePart(mockHitPoints);
        Mockito.when(mockHitPoints.getHitPointsModifier()).thenReturn(DEFAULT_HIT_POINTS_MODIFIER);
        Mockito.when(this.fakeHitPtModifyPart.getHitPointsModifier()).thenReturn(DEFAULT_HIT_POINTS_MODIFIER);

        long actual = this.assembler.getTotalHitPointModification();
        long expected = DEFAULT_HIT_POINTS_MODIFIER * 2;

        Assert.assertEquals(DEFAULT_MSG, expected, actual);
    }
}