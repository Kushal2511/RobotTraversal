package com.imperva.model;

import java.util.HashMap;
import java.util.Map;

public enum Direction {

    NORTH('N'), SOUTH('S'), EAST('E'), WEST('W');

    private final char dir;
    Direction(final char dir) {
        DirectionMap.MAP.put(dir,this);
        this.dir = dir;
    }

    public char getDir(){
        return dir;
    }

    private static class DirectionMap {
        static Map<Character, Direction> MAP = new HashMap();
    }

    public static Direction find(char val) {
        Direction dir = DirectionMap.MAP.get(Character.toUpperCase(val));
        if(dir == null) {
            throw new IllegalStateException(String.format("Unsupported direction type %s.", val));
        }
        return dir;
    }
}
