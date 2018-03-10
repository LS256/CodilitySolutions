package pl.codeforfun;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FishTest {

	Fish fish;
	
	@Before
	public void setUpBefore(){
		fish = new Fish();
	}

	@Test
	public void test() {
		int[] A = {4, 3, 2, 1, 5};
		int[] B = {0, 1, 0, 0, 0};
		assertEquals(2, fish.solution(A, B));
		
		int[] A1 = {3, 2, 4, 1, 5};
		int[] B1 = {1, 1, 0, 0, 0};
		assertEquals(3, fish.solution(A1, B1));
	
		int[] A2 = {4, 3, 2, 1, 5};
		int[] B2 = {1, 1, 0, 0, 0};
		assertEquals(1, fish.solution(A2, B2));
		
		int[] A3 = {7, 6, 5, 4, 3, 2, 1, 8};
		int[] B3 = {0, 0, 0, 1, 1, 0, 1, 1};
		assertEquals(7, fish.solution(A3, B3));
		
		int[] A4 = {7, 6, 5, 4, 3, 2, 1, 8, 9};
		int[] B4 = {0, 0, 0, 1, 1, 0, 1, 1, 0};
		assertEquals(4, fish.solution(A4, B4));
		
		int[] A5 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int[] B5 = {0, 0, 0, 0, 0, 0, 0, 0, 0};
		assertEquals(9, fish.solution(A5, B5));
		
		int[] A6 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int[] B6 = {1, 1, 1, 1, 1, 1, 1, 1, 1};
		assertEquals(9, fish.solution(A6, B6));
		
		int[] A7 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int[] B7 = {1, 1, 1, 1, 1, 1, 1, 1, 0};
		assertEquals(1, fish.solution(A7, B7));
	}

}
 