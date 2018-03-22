package pl.codeforfun;

public class CountNumbers {

    CountNumbers(){
    }

    /*
     *  Solution which is not optimal from performance point of view
     *  it received only 33% of performance - this solution implement not assumpted
     *  sqrt(n) but n/2
     *  @param N - number which is tested
     *  @return result - searched number of factors
     */
    public int solution(int N){
        int result =2;

        if(N==0) {
            result = 0;
        } else if(N == 1){
            result =1;
        } else {
            for (int i = N / 2; i > 1; i--) {
                if ((i * (N / i)) == N) {
                    result++;
                }
            }
        }
        return result;
    }




}
