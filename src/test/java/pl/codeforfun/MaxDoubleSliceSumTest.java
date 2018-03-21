package pl.codeforfun;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaxDoubleSliceSumTest {

    private MaxDoubleSliceSum mdss;

    @Before
    public void init(){
        mdss = new MaxDoubleSliceSum();
    }

    @Test
    public void solutionTest(){
        int[] A = {3, 2, 6, -1, 4, 5, -1, 2};
        int[] B = {3, 2, 6, -1, 4, -1, 5, 2};



        assertEquals(1, mdss.soution(A));
        assertEquals(1, mdss.soution(B));

    }

}
