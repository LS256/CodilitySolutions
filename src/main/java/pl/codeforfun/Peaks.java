<<<<<<< HEAD
package pl.codeforfun;

import java.util.*;

public class Peaks {
    Peaks(){

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
    public int solution2(int[] A) {
        List<Integer> peaks = new ArrayList<Integer>();
        int len = A.length;

        for(int i =1; i<len-1;i++) {
            if((A[i-1] < A[i]) && (A[i] > A[i+1])) {
                peaks.add(i);
            }
        }

        int maxFlags = 0;

        for(int i=1; i<=(len/2); i++) {
            int blockSize = 1;
            if((len % i) != 0) continue; else blockSize = len/i;

            int blockStart = 0;
            int blockStop = blockSize;

            int flagsOnPeaks = 0;

            for(Integer peak:peaks) {

                if(peak>=blockStart && peak<blockStop){
                    flagsOnPeaks++;
                    blockStart += blockSize;
                    blockStop += blockSize;
                }
            }
            if(flagsOnPeaks == i) maxFlags = Math.max(maxFlags, flagsOnPeaks);
        }

        return maxFlags;
    }


    //  TODO write a code to  search block size like 20%6 !=0

    public int solution(int[] A){
        int[] peaks = getPeaks(A);
        int peaksVolume = getPeaksVolume(peaks);
        int blockSize = getBlockSize(peaks, peaksVolume);

        int pos =0;
        int tempBlockSize = 0;
        while(pos < peaks.length){
            if((peaks[pos]>0) && (tempBlockSize < blockSize)){
               pos = ((peaks.length / blockSize) - ((peaks.length - pos - 1) / blockSize)) * blockSize;
               tempBlockSize = 0;
 //              System.out.println("blockSize: " + blockSize + "  pos: " + pos);
            } else {
                pos++;
                tempBlockSize++;
            }

            if(tempBlockSize >= blockSize){
                tempBlockSize = 0;
                pos = 0;
                blockSize++;
                while((peaks.length % blockSize) != 0) {
                    blockSize++;
                }
            }


        }
        return (peaks.length / blockSize);
    }


    /*
     *  getting possible size of block base on founded peaks
     *  @param
     *  @return
     */
    public int getBlockSize(int[] peaks, int peaksVolume){
        int preBlockSize = peaksVolume;

        while(( peaks.length % preBlockSize) != 0){
            preBlockSize--;
        }
        return (peaks.length / preBlockSize);
    }

    /*
     *
     *  @param peaks - array with peaks locations
     *  @return result - quantity of peaks
     */
    public int getPeaksVolume(int[] peaks){
        int result = 0;
            for(int i=0; i<peaks.length;i++) {
                if(peaks[i] == 1) result ++;
            }
        return result;
    }

    /*
     *  method to get peaks of checked array
     *  @param A - array where we search peaks
     *  @return peaks - array with peaks values
     */
    public int[] getPeaks(int[] A){
        int[] peaks = new int[A.length];
        int peaksSum =0;

        /*
         * loop where were we check if checked element is a peak.
        *  if yes then put into new array 1, if not put into new array 0
        */
        for(int i=1; i<A.length-1;i++) {
            if ((A[i - 1] < A[i]) && (A[i] > A[i + 1])) {
                peaks[i] = 1;
            } else {
                peaks[i] = 0;
            }
        }
        return peaks;
    }



}
=======
import java.util.*;

class Solution {
    public int solution(int[] A) {
        List<Integer> peaks = new ArrayList<Integer>();
        int len = A.length;
        
        for(int i =1; i<len-1;i++) {
            if((A[i-1] < A[i]) && (A[i] > A[i+1])) {
                peaks.add(i);
            }
        }
       if(peaks.size() == 0) return 0;
       
       int maxFlags = 0;
       
       for(int i=1; i<=(len/2); i++) {
           int blockSize = 1;
           if((len % i) != 0) continue; else blockSize = len/i;
           
           int blockStart = 0;
           int blockStop = blockSize;
           
           int flagsOnPeaks = 0;
           
           for(Integer peak:peaks) {

               if(peak>=blockStart && peak<blockStop){
                   flagsOnPeaks++;
                   blockStart += blockSize;
                   blockStop += blockSize;
               }
           }
           if(flagsOnPeaks == i) maxFlags = Math.max(maxFlags, flagsOnPeaks);
       }
   
       return maxFlags;
    }
} 
>>>>>>> b04aee93ac76c4da3ccf6d912724832029820022
