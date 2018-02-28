package pl.codeforfun;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class GenomicRangeQueryTest {
	GenomicRangeQuery grq;
	
	/*
	 * Before test which initiaize new object
	 */
	@Before
	public void initialization(){
		grq = new GenomicRangeQuery();
	}
	
	@Test
	public void getCharValueTest(){
		int[][]  testPrefixSums = {{0, 0, 1, 1, 1, 1, 1, 2},{0, 1, 1, 1, 2, 3, 3, 3},{0, 0, 0, 1, 1, 1, 1, 1}};	
//		assertArrayEquals(testPrefixSums, grq.getPrefixSums("CAGCCTA"));
		
		int[][] testPrefixSums2 = {{0, 1, 1, 1, 1, 2, 3, 3, 4, 4},{0, 0, 1, 1, 1, 1, 1, 1, 1, 1},{0, 0, 0, 0, 1, 1, 1, 2, 2, 2}};
	assertArrayEquals(testPrefixSums2, grq.getPrefixSums("ACTGAAGAT"));
		
		/*
		 * some more test to check if in case of change nucleide test will be false
		 */
		assertFalse(Arrays.deepEquals(testPrefixSums2, grq.getPrefixSums("CCTGAAGAT")));
		assertFalse(Arrays.deepEquals(testPrefixSums2, grq.getPrefixSums("CCTCAAGAT")));
		assertFalse(Arrays.deepEquals(testPrefixSums2, grq.getPrefixSums("CCTAAAGAT")));
		assertFalse(Arrays.deepEquals(testPrefixSums2, grq.getPrefixSums("ACTGAAGAA")));
	}

	@Test
	public void getMinValArrayTest(){
		int[] minValTest = {2, 4, 1};
		int[] P = {2, 5, 0};
		int[] Q = {4, 5, 6};
		int[][]  testPrefixSums = {{0,0,1,0,0,0,0,1},{0,1,0,0,1,1,0,0},{0,0,0,1,0,0,0,0}};	
		
		assertArrayEquals(minValTest, grq.getMinValArray(testPrefixSums, P, Q));
	}
}
