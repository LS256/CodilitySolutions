package pl.codeforfun;

public class Peaks {
    Peaks(){

    }

    public int solution(int[] A){
        int[] peaks = getPeaks(A);
        int peaksVolume = getPeaksVolume(peaks);



        return 1;
    }

    /*
     *  method to get max possible size of block base on founded peaks
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
