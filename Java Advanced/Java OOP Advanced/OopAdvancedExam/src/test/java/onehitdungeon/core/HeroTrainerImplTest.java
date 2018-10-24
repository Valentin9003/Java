package onehitdungeon.core;

import javafx.beans.binding.When;
import onehitdungeon.interfaces.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class HeroTrainerImplTest {

    private Hero hero;
    private HeroTrainer trainer;

    @Before
    public void setUp() {
        this.trainer = new HeroTrainerImpl();
    }

    @Test
    public void trainHero() {
//        Hero mockHero = Mockito.mock(Hero.class);
//        Mockito.when(mockHero.getTotalBattlePower()).thenReturn(50);
//
//        this.trainer.trainHero(mockHero);
    }

}