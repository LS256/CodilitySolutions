package pl.codeforfun;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MushroomPickerTest {

	MushroomPicker mushroomPicker;
	/*
	 * Example array with mushrooms
	 */
	private int[] mushroomPath = {2,3,7,5,1,3,9};
	
	/*
	 * Array with prefix sums of given example array
	 */
	private int[] prefixSums = {0, 2, 5, 12, 17, 18, 21, 30};
	
	/*
	 * This method will run before all tests - will create new object for our tests
	 */
	@Before
	public void initTest(){
		mushroomPicker = new MushroomPicker();
	}
	
	/*
	 * Main test for whole code.
	 */
	@Test
	public void getMaxMushroomTest() {
		assertEquals( 2, mushroomPicker.getMaxMushroom(mushroomPath , 0, 0));
		assertEquals(30, mushroomPicker.getMaxMushroom(mushroomPath , 0, 7));
		assertEquals( 9, mushroomPicker.getMaxMushroom(mushroomPath , 6, 0));
		assertEquals(13, mushroomPicker.getMaxMushroom(mushroomPath , 2, 2));
		assertEquals(16, mushroomPicker.getMaxMushroom(mushroomPath , 2, 3));
		assertEquals(25, mushroomPicker.getMaxMushroom(mushroomPath , 2, 4));
		assertEquals(13, mushroomPicker.getMaxMushroom(mushroomPath , 6, 2));
		assertEquals(15, mushroomPicker.getMaxMushroom(mushroomPath , 1, 2));
		assertEquals(18, mushroomPicker.getMaxMushroom(mushroomPath , 3, 3));
		assertEquals(18, mushroomPicker.getMaxMushroom(mushroomPath , 3, 4));
		assertEquals(25, mushroomPicker.getMaxMushroom(mushroomPath , 4, 6));
	}
	
	/*
	 * Test for getting max value on mushroom path
	 */
	@Test
	public void getMaxResultTest(){
		assertEquals(13,mushroomPicker.getMaxResult(prefixSums, 2, 2));
		assertEquals(16,mushroomPicker.getMaxResult(prefixSums, 2, 3));
		assertEquals(25,mushroomPicker.getMaxResult(prefixSums, 2, 4));
		assertEquals(13,mushroomPicker.getMaxResult(prefixSums, 6, 2));
		assertEquals(15,mushroomPicker.getMaxResult(prefixSums, 1, 2));
		assertEquals(18,mushroomPicker.getMaxResult(prefixSums, 3, 3));
		assertEquals(18,mushroomPicker.getMaxResult(prefixSums, 3, 4));
		assertEquals(25,mushroomPicker.getMaxResult(prefixSums, 4, 6));
	}
	
	/*
	 * Test if prefixSums array is generated proper
	 */
	@Test
	public void getPrefixSumsTest(){
		int[] prefixSumsElement = mushroomPicker.getPrefixSums(mushroomPath);
		assertEquals(prefixSums[0], prefixSumsElement[0]);
		assertEquals(prefixSums[1], prefixSumsElement[1]);
		assertEquals(prefixSums[2], prefixSumsElement[2]);
		assertEquals(prefixSums[3], prefixSumsElement[3]);
		assertEquals(prefixSums[4], prefixSumsElement[4]);
		assertEquals(prefixSums[5], prefixSumsElement[5]);
		assertEquals(prefixSums[6], prefixSumsElement[6]);
		assertEquals(prefixSums[7], prefixSumsElement[7]);
	}
	
	/*
	 * Test if counting element on right side from picker works proper
	 */
	@Test
	public void rightSideMaxResultTest(){
		int[] prefixSums = mushroomPicker.getPrefixSums(mushroomPath);
		assertEquals(25, mushroomPicker.getRightSideMaxResult(prefixSums, 4, 6));
		assertEquals(19, mushroomPicker.getRightSideMaxResult(prefixSums, 4, 5));
		assertEquals(17, mushroomPicker.getRightSideMaxResult(prefixSums, 3, 3));
	}
	
	/*
	 * Test if counting element on the left side from picker works proper
	 */
	@Test
	public void leftSideMaxResultTest(){
		int[] prefixSums = mushroomPicker.getPrefixSums(mushroomPath );
		assertEquals(16, mushroomPicker.getLeftSideMaxResult(prefixSums, 1, 3));
		assertEquals(13, mushroomPicker.getLeftSideMaxResult(prefixSums, 2, 2));
		assertEquals(25, mushroomPicker.getLeftSideMaxResult(prefixSums, 4, 6));
	}
	
	
	
	/*
	 * Test if counting element on right side from picker works proper
	 */
	@Test
	public void getValueOfPrefixSumSliceTest(){
		int[] prefixSums = mushroomPicker.getPrefixSums(mushroomPath );
		assertEquals(30, mushroomPicker.getValueOfPrefixSumSlice(prefixSums, 0, 7));
		assertEquals(19, mushroomPicker.getValueOfPrefixSumSlice(prefixSums, 1, 6));
		assertEquals(13, mushroomPicker.getValueOfPrefixSumSlice(prefixSums, 2, 5));
		assertEquals(5, mushroomPicker.getValueOfPrefixSumSlice(prefixSums, 3, 4));
		assertEquals(0, mushroomPicker.getValueOfPrefixSumSlice(prefixSums, 4, 4));
		assertEquals(0, mushroomPicker.getValueOfPrefixSumSlice(prefixSums, 7, 7));
		assertEquals(0, mushroomPicker.getValueOfPrefixSumSlice(prefixSums, 0, 0));
	}
	
	/*
	 * Test if given starting position is in range of given mushroom path
	 */
	@Test
	public void checkPicekPositionTest(){
		assertEquals(true, mushroomPicker.checkPickerPosition(mushroomPath , 2));
		assertEquals(true, mushroomPicker.checkPickerPosition(mushroomPath , 0));
		assertEquals(false, mushroomPicker.checkPickerPosition(mushroomPath , mushroomPath .length));
		assertEquals(false, mushroomPicker.checkPickerPosition(mushroomPath , -1));
	}
}
