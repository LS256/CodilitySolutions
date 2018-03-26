package pl.codeforfun;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PeaksTest {
    private Peaks peaks;

    @Before
    public void setUp() throws Exception {
        peaks = new Peaks();
    }

    @Test
    public void solutionTest(){
        int[] A = {1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2};
        assertEquals(1, peaks.solution(A));

    }

    @Test
    public void getPeaksVolumeTest(){
        int[] APeaks =  {0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0};
        int[] A2Peaks = {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0};

        assertEquals(3, peaks.getPeaksVolume(APeaks));
        assertEquals(2, peaks.getPeaksVolume(A2Peaks));
    }
    @Test
    public void getPeaksTest(){
        int[] A = {1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2};
        int[] APeaks = {0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0};
        assertArrayEquals(APeaks, peaks.getPeaks(A));

        int[] A2 =      {1, 2, 3, 2, 1, 2, 3, 5, 3, 2, 1};
        int[] A2Peaks = {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0};
        assertArrayEquals(A2Peaks, peaks.getPeaks(A2));
    }
}