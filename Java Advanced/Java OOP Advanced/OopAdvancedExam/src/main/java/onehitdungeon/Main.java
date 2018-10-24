package onehitdungeon;

import onehitdungeon.constants.Commands;
import onehitdungeon.controller.DungeonManagerImpl;
import onehitdungeon.core.HeroTrainerImpl;
import onehitdungeon.interfaces.DungeonManager;
import onehitdungeon.interfaces.HeroTrainer;
import onehitdungeon.interfaces.InputReader;
import onehitdungeon.interfaces.OutputWriter;
import onehitdungeon.io.ConsoleInputReader;
import onehitdungeon.io.ConsoleOutputWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static onehitdungeon.constants.Commands.*;

public class Main {
    public static void main(String[] args) {

        OutputWriter writer = new ConsoleOutputWriter();
        InputReader reader = new ConsoleInputReader();
        HeroTrainer trainer = new HeroTrainerImpl();
        DungeonManager manager = new DungeonManagerImpl(trainer);

        String line;
        while (!QUIT.equalsIgnoreCase(line = reader.readLine())) {

            List<String> arguments =
                    Arrays.stream(line.split("\\s+"))
                            .collect(Collectors.toList());

            switch (arguments.get(0)){
                case HERO:
                    writer.println(manager.hero(arguments));
                    break;
                case SELECT:
                    writer.println(manager.select(arguments));
                    break;
                case STATUS:
                    writer.println(manager.status(arguments));
                    break;
                case FIGHT:
                    writer.println(manager.fight(arguments));
                    break;
                case ADVANCE:
                    writer.println(manager.advance(arguments));
                    break;
                case TRAIN:
                    writer.println(manager.train(arguments));
                    break;
            }
        }

        writer.print(manager.quit(new ArrayList<>()));
    }
}
