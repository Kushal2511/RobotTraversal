package com.imperva.model;

import com.imperva.exception.InvalidMoveException;

public class Plane {

    protected int[][] plane;
    protected int largestRowIdx ;
    protected int largestColIdx ;

    public Plane(int M,int N){
        plane = new int[M+1][N+1];
        this.largestColIdx = N;
        this.largestRowIdx = M;
    }

    public void setParticlePosition(int row,int col) throws InvalidMoveException {
        checkValidPosition(row,col);
        plane[row][col] = 1;
    }

    public void setParticlePosition(int[][] positions) throws InvalidMoveException {
        for(int i = 0 ; i < positions.length ; i++){
            checkValidPosition(positions[i][0],positions[i][1]);
            plane[positions[i][0]][positions[i][1]] = 1;
        }
    }

    protected void checkValidPosition(int row,int col) throws InvalidMoveException {
        if(row < 0 || row > plane.length-1) throw new InvalidMoveException("Invalid row:"+row);
        if(col < 0 || col > plane[0].length-1) throw new InvalidMoveException("Invalid column provided:"+col);
    }

    public boolean isValidPositionForMove(int row,int col){
        if(row < 0 || row > plane.length-1) return false;
        if(col < 0 || col > plane[0].length-1) return false;
        return plane[row][col] == 0;
    }

    public void setVisited(int row,int col){
        plane[row][col] = 2;
    }

    public int getLargestRowIndex(){
        return largestRowIdx;
    }

    public int getLargestColIndex(){
        return largestColIdx;
    }



}
