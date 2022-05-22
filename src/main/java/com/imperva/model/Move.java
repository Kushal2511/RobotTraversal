package com.imperva.model;


import java.util.HashMap;
import java.util.Map;

public enum Move{

    LEFT('L'), RIGHT('R'), MAINTAIN('M');

    private final char moveCh;

    Move(final char move) {
        MoveMap.MAP.put(move,this);
        this.moveCh = move;
    }
    public char getMove(){
        return moveCh;
    }

    private static class MoveMap {
        static Map<Character, Move> MAP = new HashMap();
    }

    public static Move find(char val) {
        Move move = Move.MoveMap.MAP.get(Character.toUpperCase(val));
        if(move == null) {
            throw new IllegalStateException(String.format("Unsupported move type %s.", val));
        }
        return move;
    }

}
