package pl.codeforfun;

public class MaxDoubleSliceSum {

    public int soution(int[] A){
    //  K1 - array where are kept prefixSums in forward direction
    int[] K1 = new int[A.length];
    //  K2 - array where are kept prefixSums in backward direction
    int[] K2 = new int[A.length];

    /*
     *  Loop for calculation prefix sums array in forward direction of given Array A
     */
    for(int i=1; i<A.length-1; i++){
        K1[i] = K1[i-1] + A[i];
    }

    /*
     *  Loop for calculation prefix sums array in backward direction of given Array A
     */
    for(int i=A.length-2; i>0; i--){
        K2[i] = K2[i+1] + A[i];
    }


    for(int i:K1){
        System.out.print(i + " ");
    }

    //  Empty line
        System.out.println();

    for(int i:K2){
        System.out.print(i + " ");
    }

    return 1;
    }

}
