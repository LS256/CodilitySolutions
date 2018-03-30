package pl.codeforfun;

import org.junit.Before;
import org.junit.Test;
import java.util.*;


import static org.junit.Assert.*;

public class PeaksTest {
    private Peaks peaks;

    int[] A = {1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2};
    int[] A2 = {1, 5, 1, 5, 1, 5, 1, 5, 4, 3, 2, 1, 2, 3, 4, 5, 4, 3, 2, 1};
    int[] A3 = {1, 5, 1, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    int[] A4 = {3,4,3};
    int[] A5 = {1, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2};
    int[] A6 = {1, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 2, 3, 2};

    List<Integer> AList = new ArrayList<Integer>(Arrays.asList(3,5,10));
    List<Integer> A2List = new ArrayList<Integer>(Arrays.asList(1, 3, 5, 7, 15));
    List<Integer> A3List = new ArrayList<Integer>(Arrays.asList(1, 3));
    List<Integer> A4List = new ArrayList<Integer>(Arrays.asList(1));
    List<Integer> A5List = new ArrayList<Integer>(Arrays.asList(1, 3, 5, 7, 9, 11, 13, 15));
    List<Integer> A6List = new ArrayList<Integer>(Arrays.asList(1, 3, 5, 7, 9, 11, 13, 16));

    @Before
    //  Inform JUnit that this method should run before each test
    public void setUp() throws Exception {
        peaks = new Peaks();
    }

    @Test
    public void solutionTest() {
        assertEquals(3, peaks.solution(A));
        assertEquals(2, peaks.solution(A2));
        assertEquals(1, peaks.solution(A3));
        assertEquals(1,peaks.solution(A4));
        assertEquals(1,peaks.solution(A5));
        assertEquals(6,peaks.solution(A6));
    }

    @Test
    public void getPeaksTest(){


        assertEquals(AList, peaks.getPeaks(A));
        assertEquals(A2List, peaks.getPeaks(A2));
        assertEquals(A3List, peaks.getPeaks(A3));
        assertEquals(A4List, peaks.getPeaks(A4));
        assertEquals(A5List, peaks.getPeaks(A5));
        assertEquals(A6List, peaks.getPeaks(A6));

    }

    @Test
    public void getFlagsOnPeaksTest() {
        assertEquals(3, peaks.getFlagsOnPeaks(AList, 4));
        assertEquals(2, peaks.getFlagsOnPeaks(AList, 6));
        assertNotEquals(2, peaks.getFlagsOnPeaks(AList, 4));


        assertEquals(2, peaks.getFlagsOnPeaks(A2List, 10));
        assertEquals(1, peaks.getFlagsOnPeaks(A2List, 20));
        assertNotEquals(1, peaks.getFlagsOnPeaks(A2List, 4));

        assertEquals(1, peaks.getFlagsOnPeaks(A3List, 12));
        assertNotEquals(2, peaks.getFlagsOnPeaks(A3List, 12));

        assertEquals(1, peaks.getFlagsOnPeaks(A4List, 3));
        assertNotEquals(2, peaks.getFlagsOnPeaks(A4List, 3));

        assertEquals(1, peaks.getFlagsOnPeaks(A5List, 17));
        assertNotEquals(2, peaks.getFlagsOnPeaks(A4List, 17));

        assertEquals(6, peaks.getFlagsOnPeaks(A6List, 3));
        assertEquals(3, peaks.getFlagsOnPeaks(A6List, 6));
        assertNotEquals(2, peaks.getFlagsOnPeaks(A6List, 6));
    }

}