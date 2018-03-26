package pl.codeforfun;

public class Peaks {
    Peaks(){

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
