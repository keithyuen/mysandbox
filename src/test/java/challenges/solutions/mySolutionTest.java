package challenges.solutions;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import java.util.HashMap;
import java.util.Hashtable;

public class mySolutionTest {
    private mySolution solution;

    @Before
    public void SetUp() {
        solution = new mySolution();
    }

    @Test
    public void filpBit() {
        // 5.3 Flip bit to create longest sequence of 1s
        System.out.println(solution.filpBit(1775));

        Assert.assertEquals(8, solution.filpBit(1775));
    }

    @Test
    public void printBinary() {
        // 5.2 Non-integer binary to String
        double val = 0.5;
        System.out.println(solution.printBinary(10.0));
        System.out.println(solution.printBinary(val));
        System.out.println(solution.printBinary(0.75));
        System.out.println(solution.printBinary(0.625));
        System.out.println(solution.printBinary(0.325));

        Assert.assertEquals("0.101", solution.printBinary(0.625));
    }


}

