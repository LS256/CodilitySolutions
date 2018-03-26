package pl.codeforfun;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FlagsTest {

    private Flags flags;

    @Before
    public void setUp() throws Exception {
        flags = new Flags();
    }

    @Test
    public void solutionTest(){
        int[] A = {1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2};
        assertEquals(3,flags.solution(A));

        int[] A2 = {2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2};
        assertEquals(4,flags.solution(A2));

        int[] A3 = {1,5,1};
        assertEquals(1,flags.solution(A3));

        int[] A4 = {1};
        assertEquals(0,flags.solution(A4));

        int[] A5 = {0, 1, 0, 0, 1, 0, 0, 1, 0};
        assertEquals(3,flags.solution(A5));
    }
}