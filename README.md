# CodilitySolutions
In this repo I am going to upload my solutions for codility task - but only these where I got 100% in performance.

1. MashroomPicker - this solution is an answer for exercisec placed in explatanion of prefix sums to lesson 5. It was so addictive for that i couldn't stop thinking about it's solution. It's also learnt me one important think.. always try to analyze code and it's border conditions.

2. Lesson 6 - Number of Disc Intersecion
As this exercise took me some time and its solution is pretty easy there should be some words of explanation so, what Arrays.binarySearcg() is doing.. it check if in given array is asked key, if yes then its position is returned, otherwise is returned position on which this element could be placed in this array -1. In my soulion in each iteration of for loop I remove elements which are counted not correcly, In google there are solutions which at the end substract some mistake, but I prefer my solution and the way that I am aware from where code is comming

3. Lesson 7 - "Stone wall" - this allowed to make brain storm. This task traped me a while as I wanted to make it from another point of view - not create blocks when they appear but I wanted to create blocks when they disappear. But nevertheless It was really good brain storm exercise - that's why I appriciate codility.

4. Lesson 9 - "MaxDoubleSliceSum" - nice approach how to find max. sum of array elements with only one for loop. 


// you can also use imports, for example:
 import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        int results = 0;
        List<Integer> diff = new ArrayList<Integer>();
        int prevElement =0;
        int maxFlags =0;
        int tmp = 1;
        
        for(int i=1; i<A.length-1;i++){
            if(A[i-1]<A[i] && A[i] > A[i+1]){
                results++;
                diff.add(i-prevElement);
                prevElement = i;
            }
        }

        int finalResult = 0;
        for(int i=results; i>finalResult; i--){
            finalResult = Math.max(finalResult, getFlags(diff, i));
        }
        return finalResult;
    }
    
    private int getFlags(List<Integer> diff, int askedFlags) {
        int cnt=0;
        int flags = 1;

        for(int i=1; i<diff.size();i++){
            cnt+=diff.get(i);
            if(cnt >= askedFlags) {
                cnt=0;
                flags++;
            }
        }
        return flags;
    }
    
    
}
