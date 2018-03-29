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