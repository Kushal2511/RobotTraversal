package com.imperva.model;

public enum Direction {

    NORTH('N'), SOUTH('S'), EAST('E'), WEST('W');

    private final char dir;

    Direction(final char dir) {
        this.dir = dir;
    }
    public char getDir(){
        return dir;
    }
}
