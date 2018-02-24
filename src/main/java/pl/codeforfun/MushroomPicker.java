package pl.codeforfun;

/*
 * @author LS256
 * Exercise from Lesson 5 "Prefix Sums" on codility.com
 * This is exercise example to present how prefix sums are increasing code performance from O(n*m) to O(n+m)
 */

public class MushroomPicker {
	/*
	 * Method to obtain max possible ammount of mushroms in given steps
	 * @param A - array with mushrooms ammount on certain positions
	 * @param startPOsition - position from which mushroom picker starts to collect mushrooms
	 * @param maxSteps - max ammount of steps which mushrooms picker can make
	 * @return result - max ammount of mushrooms which can be collected in given steps
	 */
	public int getMaxMushroom(int[] A, int startPosition, int maxSteps){
		if(checkPickerPosition(A, startPosition)){
			int len = A.length+1;
			int[] prefixSums = new int[len];
			prefixSums = getPrefixSums(A);	
			int maxResult = getMaxResult(prefixSums, startPosition, maxSteps); 
			return maxResult;
		} else {
			return 0;
		}
	}
	
	/*
	 * Method to calculate find max value between moves of mushroom picker to the right or to the left
	 * 
	 */
	protected int getMaxResult(int[] prefixSums, int positionLeft, int positionRight){
		return Math.max(getRightSideMaxResult(prefixSums, positionLeft, positionRight), getLeftSideMaxResult(prefixSums, positionLeft, positionRight));
	}
	
		
	/*
	 * Method to create array with prefix sums - complexity O(n)
	 * @param A - source array from which prefixSums array will be generated
	 * @return prefixSums - array with generated prefixSums
	 */
	protected int[] getPrefixSums(int[] A){
		int[] prefixSums = new int[A.length+1];
		prefixSums[0] = 0;
		
		for(int i = 1 ; i < prefixSums.length; i++){
			prefixSums[i] = prefixSums[i-1]+A[i-1];
		}
		
		return prefixSums;
	}
	
	/*
	 * Method to check condition that mushroom picker is moving to the right direction and then return to the left,so steps which were done to the left are counted twice
	 * First we check condition 0 which tells: from start position make all steps in opposite direction (0 steps to the right direction, all to the left direction) and then
	 * how many mushrooms picker can collect moving in right direction to the end of mushroom path
	 * @param prefixSums - array with prefix sums for given mushroom array
	 * @param startPosition - position from which mushroom picker starts to collect mushrooms
	 * @param maxSteps - max possible steps which mushroom picker can make
	 * @return result - max. quantity of mushroom which can be collected by mushroom picker
	 */
	protected int getRightSideMaxResult(int[] prefixSums, int startPosition, int maxSteps) {
		int calculationLimit = prefixSums.length - startPosition;
		int result = 0;
		for(int i = 0 ; i<calculationLimit; i++) {
			int positionLeft = Math.max(0, Math.min(prefixSums.length-1, startPosition - (maxSteps - i*2)));
			int positionRight = Math.min(prefixSums.length-1, startPosition + i+1);
			result = Math.max(result, getValueOfPrefixSumSlice(prefixSums, positionLeft, positionRight));
		}
		return result;
	}
	
	/*
	 * Method to check condition that mushroom picker is moving to the left direction and then return to the right, so steps which were done to the right are counted twice
	 * First we check condition 0 which tells: from start position make all steps in opposite direction (0 steps to the left direction, all to the right direction) and then
	 * how many mushrooms picker can collect moving in left direction to the end of mushroom path
	 * @param prefixSums - array with prefix sums for given mushroom array
	 * @param startPosition - position from which mushroom picker starts to collect mushrooms
	 * @param maxSteps - max possible steps which mushroom picker can make
	 * @return result - max. quantity of mushroom which can be collected by mushroom picker
	 */	
	protected int getLeftSideMaxResult(int[] prefixSums, int startPosition, int maxSteps) {
		int calculationLimit = startPosition+1;
		int result = 0;
		for(int i = 0 ; i<calculationLimit; i++) {
			int positionRight = Math.max(0, Math.min(prefixSums.length-1, startPosition + (maxSteps - i*2) + 1));
			int positionLeft = Math.min(prefixSums.length-1, startPosition - i);
			result = Math.max(result, getValueOfPrefixSumSlice(prefixSums, positionLeft, positionRight));
		}
		return result;
	}
	
	/*
	 * Method to get difference between to given position of array - in this case in prefixSums array
	 * @param prefixSums - array with prefixSums of mushroom array
	 * @param positionLeft - first element of calculated difference
	 * @param positionRight - second element of calculated difference
	 * @return difference between to given array elements (between to slices)
	 */
	protected int getValueOfPrefixSumSlice(int[] prefixSums, int positionLeft, int positionRight){
		return prefixSums[positionRight] - prefixSums[positionLeft];
	}

	/*
	 * Check if given mushhrom position is in range of given mushroom path
	 * @param prefixSums - array with prefixSums of mushroom array
	 * @param pickerPosition - position from which mushroom picker starts to collect mushrooms
	 * @return true if pickerPoistion is in range of mushroom path
	 * @return false if pickerPosition is not in range of mushroom path
	 */
	public boolean checkPickerPosition(int[] prefixSums, int pickerPosition) {
		if(pickerPosition >=0  && pickerPosition < prefixSums.length) {
			return true;
		}
		return false;
	}

}
