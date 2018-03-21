package pl.codeforfun;

public class MaxDoubleSliceSum {

    public int soution(int[] A){
    int[] K1 = new int[A.length+1];

    for(int i=1; i<A.length-1; i++){
        K1[i] = K1[i-1] + A[i];
    }

    for(int i:K1){
        System.out.println(i);
    }

    return 1;
    }

}
