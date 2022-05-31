package com.imperva;

import com.imperva.exception.InvalidMoveException;
import com.imperva.model.*;

import java.util.Arrays;

public class RobotTraversal {

    Robot robot;
    Plane plane;

    public  RobotTraversal(Robot robot,Plane plane){
        this.robot = robot;
        this.plane = plane;
    }

    public void makeNextMove(Move move) throws InvalidMoveException {
        switch (move){
            case LEFT: {
                robot.turnLeft();
                robot.setNoOfLeftTurns(robot.getNoOfLeftTurns()+1);
                break;
            }
            case RIGHT: {
                robot.turnRight();
                robot.setNoOfRightTurns(robot.getNoOfRightTurns()+1);
                break;
            }
            case MAINTAIN:{
                int[] newPos = robot.getNextPosition();
                boolean isValidMove = plane.isValidPositionForMove(newPos[0],newPos[1]);
                if (isValidMove) {
                    plane.setVisited(newPos[0],newPos[1]);
                    robot.setCurrentPosition(newPos);
                }
                else throw new InvalidMoveException("Invalid Move");
                break;
            }
        }

    }

    public String traverse(String moves) throws InvalidMoveException {
        int[] startPos = robot.getCurrentPosition();
        if(startPos[0] > plane.getLargestRowIndex() || startPos[1] > plane.getLargestColIndex() || startPos[1] < 0 || startPos[0] < 0) {
            throw new InvalidMoveException("Invalid start position");
        }
        for(char c : moves.toCharArray()){
            Move move = Move.find(c);
            try{
                makeNextMove(move);
            }
            catch (InvalidMoveException e){
                return robot.getCurrentPosAndDir();
            }
        }
        return robot.getCurrentPosAndDir();
    }


}
