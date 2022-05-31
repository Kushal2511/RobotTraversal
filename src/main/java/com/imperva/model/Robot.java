package com.imperva.model;

public class Robot {

    public Direction direction;

    private int[] currentPosition;
    private int noOfRightTurns = 0;
    private int noOfLeftTurns = 0;

    public int getNoOfRightTurns() {
        return noOfRightTurns;
    }

    public void setNoOfRightTurns(int noOfRightTurns) {
        this.noOfRightTurns = noOfRightTurns;
    }

    public int getNoOfLeftTurns() {
        return noOfLeftTurns;
    }

    public void setNoOfLeftTurns(int noOfLeftTurns) {
        this.noOfLeftTurns = noOfLeftTurns;
    }

    public Robot(Direction direction, int row, int col){
        this.direction = direction;
        int[] tempPos = new int[2];
        tempPos[0] =row;
        tempPos[1] = col;
        this.currentPosition = tempPos;
    }

    public void turnLeft(){
        if(direction == Direction.NORTH) direction = Direction.WEST;
        else if(direction == Direction.WEST) direction = Direction.SOUTH;
        else if(direction == Direction.SOUTH) direction = Direction.EAST;
        else if(direction == Direction.EAST) direction = Direction.NORTH;
    }

    public void turnRight(){
        if(direction == Direction.NORTH) direction = Direction.EAST;
        else if(direction == Direction.EAST) direction = Direction.SOUTH;
        else if(direction == Direction.SOUTH) direction = Direction.WEST;
        else if(direction == Direction.WEST) direction = Direction.NORTH;
    }

    public int[] getNextPosition(){
        int[] position = new int[2];
        position[0] = currentPosition[0];
        position[1] = currentPosition[1];
        if(direction == Direction.NORTH) {
            position[1] =  position[1]+1;
        }
        else if(direction == Direction.SOUTH) {
            position[1] =  position[1]-1;
        }
        else if(direction == Direction.EAST) {
            position[0] =  position[0]+1;
        }
        else if(direction == Direction.WEST) {
            position[0] =  position[0]-1;
        }
        return position;
    }

    public void printPosAndDir(){
        System.out.println(String.format("%d %d %s", currentPosition[0],currentPosition[1],direction.getDir()));
    }

    public String getCurrentPosAndDir(){
        return String.format("%d %d %s", currentPosition[0],currentPosition[1],direction.getDir());
    }



    public void setCurrentPosition(int[] pos) {
        this.currentPosition = new int[]{pos[0],pos[1]};
    }

    public int[] getCurrentPosition() {
        return this.currentPosition;
    }


}
