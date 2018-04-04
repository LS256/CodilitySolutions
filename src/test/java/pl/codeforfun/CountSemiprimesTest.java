package pl.codeforfun;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class CountSemiprimesTest {

    private CountSemiprimes countSemiprimes;

    @Before
    public void testInit(){
        countSemiprimes = new CountSemiprimes();
    }

    @Test
    public void getPrimesTest(){
        boolean[] A = {false, false, false, false, true, false, true, false, true, true, true, false};
        assertArrayEquals(A, countSemiprimes.getPrimes(12));
    }

    @Test
    public void getSemiprimesTest(){
        boolean[] A = { false, false, false,false,true, false, true, false, false, true, true, false,
                        false, false, true, true, false, false, false, false, false, true, true, false,
                        false, true, true};
        boolean[] A2 = {false, false, false, false, true, false, true, false, true, true, true, false,
                        true, false, true, true, true, false, true, false, true, true, true, false, true, true};
        assertArrayEquals(A, countSemiprimes.getSemiprimes(26, A2));
    }

    @Test
    public void getFactorsTest(){
        int[] A = {0,0,0,0,1,1,2,2,2,3,4,4,4,4,5,6,6,6,6,6,6,7,8,8,8,9,10};
//        boolean[] A2 = {false, false, false, false, true, false, true, false, true, true, true, false,
//                true, false, true, true, true, false, true, false, true, true, true, false, true, true};

        boolean[] A2 = {false, false, false, false, true, false, true, false, false, true, true, false, false, false, true, true,
                false, false, false, false, false, true, true, false, false, true, true};

        assertArrayEquals(A, countSemiprimes.getFactors(26, A2));
    }

    @Test
    public void solutionTest(){
        int[] P = { 1, 4, 16};
        int[] Q = {26,10, 20};
        int   N = 26;
        int[] testResult = {10,4,0};

        assertArrayEquals(testResult, countSemiprimes.solution(N, P, Q));
    }

}


