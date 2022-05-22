package com.imperva.model;


public enum Move{

    LEFT('L'), RIGHT('R'), MAINTAIN('M');

    private final char moveCh;

    Move(final char move) {
        this.moveCh = move;
    }
    public char getMove(){
        return moveCh;
    }

}
