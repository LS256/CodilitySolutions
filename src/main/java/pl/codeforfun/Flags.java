package pl.codeforfun;

import java.util.*;

public class Flags {
    public Flags() {

    }

    public int solution(int[] A){
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
