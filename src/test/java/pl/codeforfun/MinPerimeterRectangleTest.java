package pl.codeforfun;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

public class MinPerimeterRectangleTest {

    private MinPerimeterRectangle mpr;

    @Before
    public void init(){
        mpr = new MinPerimeterRectangle();
    }

    @Test
    public void solutionTest(){
        assertEquals(22,mpr.solution(30));
        assertEquals(24,mpr.solution(36));
        assertEquals(4,mpr.solution(1));
    }
}
