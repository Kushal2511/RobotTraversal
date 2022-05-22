package com.imperva.model;

public class Plane {

    protected int[][] plane;
    protected int largestRowIdx ;
    protected int largestColIdx ;

    public Plane(int M,int N){
        plane = new int[M+1][N+1];
        this.largestColIdx = N;
        this.largestRowIdx = M;
    }

    public void setParticlePosition(int row,int col){
        plane[row][col] = 1;
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
