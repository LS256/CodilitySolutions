package pl.codeforfun;
/*
 *  @author LS
 *  @date 2018-03-22
 *  lesson 10 - count Numbers
 */
public class CountNumbers {

    CountNumbers() {
    }

    /*
     *  Solution which is not optimal from performance point of view
     *  it received only 33% of performance - this solution implement not assumpted
     *  sqrt(n) but n/2
     *  @param N - number which is tested
     *  @return result - searched number of factors
     */
    public int solution(int N) {
        int result = 2;

        if (N == 0) {
            result = 0;
        } else if (N == 1) {
            result = 1;
        } else {
            for (int i = N / 2; i > 1; i--) {
                if ((i * (N / i)) == N) {
                    result++;
                }
            }
        }
        return result;
    }

    /*
     * Solution2 is optimal from performance point of view - got 100/100 on codility.com
     * In contrast to previous solution it uses min. amount of steps reducing variable from top and bottom
     * In else condition we have for loop where we know that factors cannot be bigger than N/2
     * and therefore we are not checking bigger values. from bottom we know that one always is included so that's why
     * we start checking from 2 incrementing in each next step this variable by one.
     * When we increment bottom variable then upper variable is equal to N/bottomValue - it gives us feature that upper variable
     * is decreasing not by one but usually by more. Crucial point of this code snippet are:
     * - when N is a prime number and we have situation that i == N/i in this case we shouldn't increment our result
     * - when N has integer sqrt value (like qrt of 36 is six) and then we should increment our result not by two but by one!\
     *  @param N - number which is tested
     *  @return result - searched number of factors
     */
    public int solution2(int N) {
        int result = 2;

        if (N == 0) {
            result = 0;
        } else if (N == 1) {
            result = 1;
        } else {
            for(int i=2; i<=(N/i); i++){
                if((i == (N/i)) && (i*i == N)){
                    result++;
                } else if((i*(N/i)) == N){
                    result +=2;
                }
            }
        }
        return result;
    }

}
