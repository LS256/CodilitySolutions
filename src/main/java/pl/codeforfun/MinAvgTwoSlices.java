package pl.codeforfun;

/*
 * Codilitycom - Lesson 4 - MinAvgTwoSlice
 * Find the minimal average of any slice containing at least two elements.
 * The most tricky thnig was to find out that length with min average can has 2 or max. 3 slices lenght
 * This solution present performace O(n)
 */
public class MinAvgTwoSlices {
	
	public MinAvgTwoSlices(){
		
	}
	
	/*
	 * get min position of slice with minValue
	 * @param A - array with values of slices
	 * @return minAvgPos - position with min value of slice
	 */
	public int getMinSlicePos(int[] A) {
		
        double minAvgVal = (A[0] + A[1]) / 2.0;
        int minAvgPos = 0;
        
        for(int i=1; i<A.length-2; i++) {
            if(((A[i]+A[i+1])/2.0) < minAvgVal ) {
                minAvgVal = (A[i]+A[i+1])/2.0;
                minAvgPos = i;
            }
            
            if(((A[i] + A[i+1] + A[i+2]) / 3.0) < minAvgVal) {
                minAvgVal = (A[i] + A[i+1] + A[i+2]) / 3.0;
                minAvgPos = i;
            }
        }
        
        if(((A[A.length-1]+A[A.length-2])/2.0) < minAvgVal){
            minAvgVal = ((A[A.length-1]+A[A.length-2])/2.0);
            minAvgPos = A.length-2;
        }
        
        return minAvgPos;
    }
}