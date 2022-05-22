package com.imperva.model;

public class BottomLeftPlane extends Plane{



    public BottomLeftPlane(int M, int N) {
        super(M, N);

    }

    public void setParticlePosition(int row,int col){
        plane[largestRowIdx-row][largestColIdx-col] = 1;
    }

    public boolean isValidPositionForMove(int row,int col){
        if(row < 0 || row > plane.length-1) return false;
        if(col < 0 || col > plane[0].length-1) return false;
        return plane[largestRowIdx - row][largestColIdx - col] == 0;
    }

    public void setVisited(int row,int col){
        plane[largestRowIdx - row][largestColIdx - col] = 2;
    }


}
