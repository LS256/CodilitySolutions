package pl.codeforfun;

/*
 * LS256
 * Codility lesson 5 "Prefix sums" : GenomicRangeQuery
 * it's solution base on making prefix sums of nucleides occurences.
 * first array with nucleoide occurence is build and in next step we use prefix sums to check if in given range in occurence array
 * vaue is higher than 0
 */
public class GenomicRangeQuery {

	/*
	 * get array with prefix sums for given nucleoide chain
	 * @param nuleoide - string representation of DNA chain
	 * @return prefixSums - array with occurence of given nuceoide
	 */
	public int[][] getPrefixSums(String nucleotide) {
		int[][] prefixSums = new int[3][nucleotide.length()+1];
		
		for(int i = 0 ; i <nucleotide.length(); i++){
			int a = 0, c=0, g=0;
			if(nucleotide.charAt(i) == 'A') a=1;	// prefixSums[0][i+1] =  prefixSums[0][i] + 1;
			if(nucleotide.charAt(i) == 'C') c=1;	// prefixSums[1][i+1] =  prefixSums[1][i] + 1;
			if(nucleotide.charAt(i) == 'G') g=1;	// prefixSums[2][i+1] =  prefixSums[2][i] + 1;
			
			prefixSums[0][i+1] =  prefixSums[0][i]+a;
			prefixSums[1][i+1] =  prefixSums[1][i]+c;
			prefixSums[2][i+1] =  prefixSums[2][i]+g;
		}	
		return prefixSums;
	}

	/*
	 * get min array with minimum values of given nucleoides
	 * @param prefixSums - array with check occurence of each nucleoide
	 * @param P - array with start index (from which position we will check min value)
	 * @param Q - array with end index (to which position we will check min value)
	 * @return minValueArray - array with minimum values of nuceoides in given range
	 */
	public int[] getMinValArray(int[][] prefixSums, int[] P, int[] Q) {
		int[] minValueArray = new int[P.length];
		int minVal=0;
		for(int i = 0 ; i<P.length;i++){
			if( (prefixSums[0][Q[i]+1] - prefixSums[0][P[i]] ) > 0) minVal=1;
			else if ( (prefixSums[1][Q[i]+1] - prefixSums[1][P[i]] ) > 0) minVal=2;
			else if ( (prefixSums[2][Q[i]+1] - prefixSums[2][P[i]] ) > 0) minVal=3;
			else minVal = 4;
			minValueArray[i]=minVal;
		}
		
		return minValueArray;
	}


}
