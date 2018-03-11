package pl.codeforfun;

import java.util.*;

/*
 * @author LS256
 * Codility lesson 8 - Dominator
 * This solution implement stack to store values but it is also possible to do without stack implementation
 */

public class Dominator {
    public int solution(int[] H) {
        Stack<Integer> stack = new Stack<Integer>();
        /*
         * if give array is empty (ghost array) then there is no dominator and code should return -1 in this situation
         */
		if(H.length ==0) return -1;
			for(int i=0;i<H.length;i++) {
				/*
				 * if no value is stored in stack the add next value from checked array
				 */
				if(stack.empty()){
			        stack.push(i);
				} else {
					/*
					 * check if last value stored in stack is equal to current element in checked array H
					 * if no then eements are not equal and we should remove last value from stack
					 * if yes the add value to the stack
					 */
					if(H[stack.peek()] != H[i]){
						stack.pop();
					} else {
						stack.push(i);
    				}
				}
			}
			
			/*
			 * cnt stors element which will be returned by the code
			 * x stores size/ammount of dominator occurence
			 */
			int cnt=-1;
			int x =0;
			
			if(stack.size()>0){
	    		for(int i=0; i<H.length;i++){
	       			if(H[i] == H[stack.peek()]){
		   				cnt=i;
		   		        x++;
		   				}
		   		}
			} else return cnt;
		/*
		 * if dominator occurence is bigger that half of given array length then return founded dominator value
		 */
		if(x > H.length/2) return cnt; else return -1;
	}
}