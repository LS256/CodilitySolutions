package pl.codeforfun;

import java.util.Arrays;

/*
 * Codility Lesson 6 - Number of Disc Intersections
 * As this exercise took me some time and its solution is pretty easy there should be some words of explanation
 * so, what Arrays.binarySearcg() is doing.. it check if in given array is asked key, if yes the its position is returned,
 * otherwise is returned position on which this element could be placed in this array -1.
 * In my soulion in each iteration of for loop I remove elements which are counted not correcly, In net there are solutions 
 * which at the end substract some mistake, but I prefer my solution and the way that I am aware from where code is comming
 * 
 * @param array wint N elements
 * @return counter - variable where occurence will be coubted
 */

public class NumberOfDiscIntersections {

	NumberOfDiscIntersections(){
		
	}

 public int solution(int[] A) {
	long[] A1 = new long[A.length];
	long[] A2 = new long[A.length];
	
	for(int i=0;i<A.length;i++){
		A1[i] = (long)A[i]+i;
		A2[i] = i-(long)A[i];
	}
		
	Arrays.sort(A1);
	Arrays.sort(A2);
		
	long counter=0;
	for(int i=0;i<A.length;i++){
		int pos = Arrays.binarySearch(A2, A1[i]);
		if(pos<0){
			counter += -(pos) - 2 -i;
		} else {
			while(pos<A.length && A1[i] == A2[pos]){
				pos++;
			}
			counter += pos-1-i;
	        if(counter>1e7){
	            return -1;
	        }
		}	
	}
	return (int) counter;
	}
}