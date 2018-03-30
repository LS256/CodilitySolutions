package pl.codeforfun;

import java.util.*;

public class Peaks {
    Peaks() {

    }

    /*
     *  This is second solution of peaks issue - and much more correct than first approach
     *  First we create a list wherewe add detected peaks. When we have peaks then we can start cheking
     *  how many flags we can take - in many cases taken flags will be not equal to detected peaks
     *  In main for loop we check possible taken flags by dividing length of given array by flags quantity
     *  and check if peaks are located in these flags intersection
     *  at the end there is another if condition for checking if in given iteration calculated flags quantitty is
     *  is bigger than previously calculated.
     */
    public int solution(int[] A) {
        List<Integer> peaks = getPeaks(A);

        int len = A.length;


        int maxFlags = 0;

        for (int i = 1; i <= (len / 2); i++) {
            int blockSize;

            if ((len % i) != 0) {
                continue;
            }else {
                blockSize = len / i;
            }

            int flagsOnPeaks = getFlagsOnPeaks(peaks, blockSize);

            if (flagsOnPeaks == i) maxFlags = Math.max(maxFlags, flagsOnPeaks);
        }

        return maxFlags;
    }

    public int getFlagsOnPeaks(List<Integer> peaks, int blockSize) {
        //  block start and blockStop describe intersection for searched peak valeu
        int blockStart = 0;
        int blockStop = blockSize;
        //  tempVariable to keep founded peaks
        int flagsOnPeaks = 0;

        for (Integer peak : peaks) {
            if (peak >= blockStart && peak < blockStop) {
                flagsOnPeaks++;
                blockStart += blockSize;
                blockStop += blockSize;
            }
        }
        return flagsOnPeaks;
    }

    /*
     *  Method to get values of peaks locations and add them to the list
     *  @param A - array with given values. In this array we will search for peaks
     *  @return peaks - list with values of peaks locations
     */
    public List<Integer> getPeaks(int[] A) {
        List<Integer> peaks = new ArrayList<Integer>();
        int len = A.length;

        for (int i = 1; i < len - 1; i++) {
            if ((A[i - 1] < A[i]) && (A[i] > A[i + 1])) {
                peaks.add(i);
            }
        }
        return peaks;
    }
}