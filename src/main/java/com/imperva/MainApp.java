package com.imperva;

import com.imperva.exception.InvalidMoveException;
import com.imperva.model.*;

import java.util.Arrays;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        String[] topRightCoOrdinates = sc.nextLine().split(" ");
        String[] robotPos = sc.nextLine().split(" ");
        String moves = sc.nextLine();
        int topRightX = Integer.parseInt(topRightCoOrdinates[0]);
        int topRightY = Integer.parseInt(topRightCoOrdinates[1]);
        int startRow = Integer.parseInt(robotPos[0]);
        int startCol = Integer.parseInt(robotPos[1]);


        Direction direction = Direction.find(robotPos[2].charAt(0));

        var robot = new Robot(direction,startRow,startCol);
        Plane plane = new BottomLeftPlane(topRightX,topRightY);
        RobotTraversal traversal = new RobotTraversal(robot,plane);
        String finalPosition = null;
        try {
            finalPosition = traversal.traverse(moves);
        } catch (InvalidMoveException e) {
            e.printStackTrace();
        }
        System.out.println(robot.getNoOfLeftTurns()+":"+robot.getNoOfRightTurns());
        System.out.println(finalPosition);
    }
}
