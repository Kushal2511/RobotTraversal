package com.imperva.model;

import com.imperva.exception.InvalidMoveException;

public class BottomLeftPlane extends Plane{



    public BottomLeftPlane(int M, int N) {
        super(M, N);

    }

    public void setParticlePosition(int row,int col) throws InvalidMoveException {
        checkValidPosition(row,col);
        plane[largestRowIdx-row][largestColIdx-col] = 1;
    }

    public void setParticlePosition(int[][] positions) throws InvalidMoveException {
        for(int i = 0 ; i < positions.length ; i++){
            checkValidPosition(positions[i][0],positions[i][1]);
            plane[largestRowIdx-positions[i][0]][largestColIdx-positions[i][1]] = 1;
        }
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
