import hu.adventofcode2019.common.Coordinate;
import hu.adventofcode2019.day03.Wire;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class WireTaskTest {
    @Test
    public void Task1Test1() {
        int test1Distance = getClosestIntersectManhattamDistance("R8,U5,L5,D3", "U7,R6,D4,L4");
        Assert.assertEquals(6,test1Distance);
    }

    @Test
    public void Task1Test2() {
        int test1Distance = getClosestIntersectManhattamDistance("R75,D30,R83,U83,L12,D49,R71,U7,L72", "U62,R66,U55,R34,D71,R55,D58,R83");
        Assert.assertEquals(159,test1Distance);
    }

    @Test
    public void Task1Test3() {
        int test1Distance = getClosestIntersectManhattamDistance("R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51", "U98,R91,D20,R16,D67,R40,U7,R15,U6,R7");
        Assert.assertEquals(135,test1Distance);
    }

    @Test
    public void Task2Test1() {
        int test1Distance = getClosestIntersectStepDistance("R8,U5,L5,D3", "U7,R6,D4,L4");
        Assert.assertEquals(30,test1Distance);
    }

    @Test
    public void Task2Test2() {
        int test1Distance = getClosestIntersectStepDistance("R75,D30,R83,U83,L12,D49,R71,U7,L72", "U62,R66,U55,R34,D71,R55,D58,R83");
        Assert.assertEquals(610,test1Distance);
    }

    @Test
    public void Task2Test3() {
        int test1Distance = getClosestIntersectStepDistance("R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51", "U98,R91,D20,R16,D67,R40,U7,R15,U6,R7");
        Assert.assertEquals(410,test1Distance);
    }

    public int getClosestIntersectManhattamDistance(String wire1String, String wire2String) {
        Wire wire1 = new Wire(wire1String);
        Wire wire2 = new Wire(wire2String);
        return Wire.getClosestManhattamDistanceOfIntersectPoint(wire1, wire2);
    }

    public int getClosestIntersectStepDistance(String wire1String, String wire2String) {
        Wire wire1 = new Wire(wire1String);
        Wire wire2 = new Wire(wire2String);
        return Wire.getClosestStepNumberOfIntersecPoint(wire1, wire2);
    }
}
