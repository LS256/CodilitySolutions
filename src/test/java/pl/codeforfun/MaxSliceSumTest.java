package pl.codemakesfun;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaxSliceSumTest {

    MaxSliceSum mss;

    @Before
    public void setUp() throws Exception {
        mss = new MaxSliceSum();
    }

    @Test
    public void maxSliceSumTest(){
        int[] A = {3, 2, -6, 4, 0};
        int[] B = {-1, 1};
        int[] C = {3, 2, -5, -5, -2, 1, 2};
        int[] D = {5, -7, 3,  5, -2, 4, -1};

        assertEquals(5, mss.solution(A));
        assertEquals(1, mss.solution(B));
        assertEquals(5, mss.solution(C));
        assertEquals(10, mss.solution(D));

    }
}
