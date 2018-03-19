package pl.codemakesfun;

public class MaxSliceSum {

    /*
     *   Empty constructor
     */
    MaxSliceSum(){

    }

    /*
     *  This method represent solution with O(n) time complexity
     *  @param A - array where we are looking for max Slice sum
     *  @return maxSlice - maxSlice calcuated in our for loop
     */
    public int solution(int[] A) {
        int maxEnding = A[0];
        int maxSlice  = A[0];

        for(int i=1; i<A.length;i++){
            maxEnding = Math.max(A[i], maxEnding+A[i]);
            maxSlice = Math.max(maxEnding, maxSlice);
        }

        return maxSlice;
    }
}
