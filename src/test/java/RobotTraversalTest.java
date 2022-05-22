import com.imperva.RobotTraversal;
import com.imperva.exception.InvalidMoveException;
import com.imperva.model.BottomLeftPlane;
import com.imperva.model.Direction;
import com.imperva.model.Plane;
import com.imperva.model.Robot;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RobotTraversalTest {

    @Test
    void testNorth() throws InvalidMoveException {
        RobotTraversal traversal = new RobotTraversal(new Robot(Direction.NORTH,0,0),new BottomLeftPlane(4,4));
        String finalPos = traversal.traverse("MMMRMMLM");
        assertEquals("2 4 N",finalPos);
    }

    @Test
    void testEast()  throws InvalidMoveException{
        RobotTraversal traversal = new RobotTraversal(new Robot(Direction.EAST,0,0),new BottomLeftPlane(4,4));
        String finalPos = traversal.traverse("MMMRMMLM");
        assertEquals("3 0 S",finalPos);
    }

    @Test
    void testWest()  throws InvalidMoveException{
        RobotTraversal traversal = new RobotTraversal(new Robot(Direction.WEST,2,2),new BottomLeftPlane(4,4));
        String finalPos = traversal.traverse("MMMRMMLM");
        assertEquals("0 2 W",finalPos);
    }

    @Test
    void testSouth()  throws InvalidMoveException{
        RobotTraversal traversal = new RobotTraversal(new Robot(Direction.SOUTH,2,2),new BottomLeftPlane(4,4));
        String finalPos = traversal.traverse("MMMRMMLM");
        assertEquals("2 0 S",finalPos);
    }

    @Test
    void testSouthToWest()  throws InvalidMoveException{
        RobotTraversal traversal = new RobotTraversal(new Robot(Direction.SOUTH,2,2),new BottomLeftPlane(4,4));
        String finalPos = traversal.traverse("MMRMM");
        assertEquals("0 0 W",finalPos);
    }

    @Test
    void testSouthToEast()  throws InvalidMoveException{
        RobotTraversal traversal = new RobotTraversal(new Robot(Direction.SOUTH,2,2),new BottomLeftPlane(4,4));
        String finalPos = traversal.traverse("MMLMM");
        assertEquals("4 0 E",finalPos);
    }

    @Test
    void testInvalidStartPosGreaterThanTopRight()  throws InvalidMoveException{
        RobotTraversal traversal = new RobotTraversal(new Robot(Direction.SOUTH,5,5),new BottomLeftPlane(4,4));
        assertThrows(InvalidMoveException.class,()->{traversal.traverse("MMLMM");});
    }

    @Test
    void testInvalidStartPosNegative()  throws InvalidMoveException{
        RobotTraversal traversal = new RobotTraversal(new Robot(Direction.SOUTH,-1,-1),new BottomLeftPlane(4,4));
        assertThrows(InvalidMoveException.class,()->{traversal.traverse("MMLMM");});
    }

    @Test
    void testStopAtAlreadyTravelled()  throws InvalidMoveException{

        RobotTraversal traversal = new RobotTraversal(new Robot(Direction.NORTH,0,0),new BottomLeftPlane(4,4));
        String finalPos = traversal.traverse("MMRMRMRMMM");
        assertEquals("1 1 W",finalPos);
    }

   @Test
    void testStopAtParticlePosition()  throws InvalidMoveException{
        Plane plane = new BottomLeftPlane(4,4);
        plane.setParticlePosition(2,1);
        RobotTraversal traversal = new RobotTraversal(new Robot(Direction.NORTH,0,0),plane);
        String finalPos = traversal.traverse("MMRMRMRMMM");
        assertEquals("1 1 W",finalPos);
    }
}
