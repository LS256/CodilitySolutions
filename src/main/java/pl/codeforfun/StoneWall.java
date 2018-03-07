package pl.codeforfun;

import java.util.Stack;

/*
 * 	@author LS256 03.2018y.
 *	Lesson 6 "Stone wall"
 */
public class StoneWall {
	public void StoneWall(){
		
	}
	
	public int solution(int[] H){
		//	create new object of stack
        Stack<Integer> stack = new Stack<Integer>();
        int blocks = 0;
        
        for(int i=0; i<H.length; i++) {
        	/*
        	 * 	This is major point of the whole code. its task is that when stack is not empty (some elements are already 
        	 * in stack and previous value is higher than current value - then we remove previous element from stack. 
        	 * For previous element separated bloc was already created.
        	 */
			while(!stack.isEmpty() && stack.peek() > H[i]){
				stack.pop();
			}
            
			/*
			 * simple check of basic conditions.
			 */
           if(stack.isEmpty()) {
				blocks++;
				stack.push(H[i]);
			} else if(stack.peek() == H[i]) {
				//	do nothing
			} else if(stack.peek() < H[i]) {
				blocks++;
				stack.push(H[i]);
			} 
        }
        return blocks;
	}
}
