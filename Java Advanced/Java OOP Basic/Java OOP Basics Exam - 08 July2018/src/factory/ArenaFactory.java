package factory;

import entity.arenaDto.ArenaImpl;
import entity.interfaces.Arena;

public final class ArenaFactory {

    private ArenaFactory() {
    }

    public static Arena createArena(String arenaName, int capacity) {
        return new ArenaImpl(arenaName, capacity);
    }
}
