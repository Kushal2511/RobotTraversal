Robot Traversal Console Application responsible which will take plane co-ordinates , start position, moves and direction as input
and provide final position of robot as per input moves.

The robot's movement :
1. Its position is represented by x and y coordinates and a letter representing one of the four
   directions (N/S/E/W)<br />
2. It takes in commands in the form of single letters. The possible letters are 'L', 'R' and 'M'.<br />
   2.1 'L' and 'R' makes the robot turn 90 degrees left or right respectively, without moving from
   its current position.<br />
   2.2 'M' means move forward one position and maintain the same direction.<br />
3. It stops walking<br />
   3.1 If it finds any particle on its way<br />
   3.2 If it encounters any coordinate on its path which it had travelled earlier<br />
   3.3 If the next command leads to a position outside rectangular plane<br />


INPUT:
1. The first line of input is the top-right coordinates of the rectangular plan (M, N),<br />
2. Next two lines of input are about the robot<br />
   2.1 first line gives the robot's starting position, X,Y coordinates and a letter, all 3 separated by
   spaces<br />
   2.2 second line is a series of commands for the robot<br />


Test Input<br />
4 4<br />
0 0 N<br />
MMMRMMLM<br />

Test Output<br />
2 4 N