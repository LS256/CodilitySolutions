package pl.codeforfun;

import java.util.Stack;

/*
 * Solution to Codility Lesson 7 - Fish exercise
 * @autor LS256
 */
public class Fish {
	public Fish(){
	
	}
	/*
	 * main function
	 * @param A - array with fish size
	 * @param B - array with swimming direction
	 * @return - ammount of fishes which were not eaten
	 */
	public int solution(int[]A, int[] B){
		Stack<Integer> stack = new Stack<Integer>();
		/*
		 * 	Loop where fish are checked
		 */
		for(int i=0;i<A.length;i++) {
			/*
			 * 	first step if no fish added to stack then add one
			 */
			if(stack.empty()){
				stack.push(i);
			}
			/*
			 * 	if min. one fish exists on our stack then:
			 */
			else {
				/*
				 * we have min. one fish stored on the stack and new fish which is under our tests. So we check:
				 * - if any fish exists on the stack (because stack.pop() may return empty stack
				 * - size of new fish is bigger than last fish on the stack
				 * - check swimming direction  
				 *  if above conditions are fullfield then new fish eats fisk from the stack (pop operation)
				 */
				while(!stack.empty() && (A[i]-A[stack.peek()] > 0) && ((B[i]-B[stack.peek()]) == -1)) {
					System.out.println("eats i:"+i+" with value:"+stack.peek());
					stack.pop();
				}
				/*
				 * 	if new fish eat all fishes from the stack then it's mean that it is big fish and you should add to the stack
				 */
				if(stack.empty()){
					stack.push(i);
				/*
				 * check if swimming directions are the same, if yes then put fish to the stack
				 */
				} else if((B[i]-B[stack.peek()]) != -1){
					stack.push(i);
				}

			}
		}
		return stack.size();
	}
}
