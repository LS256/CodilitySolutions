package pl.codeforfun;

public class MinPerimeterRectangle {

    MinPerimeterRectangle(){

    }

    /*
     * Codility Lesson 10 - Min Perimeter Rectangle
     * @param N - integer value for which we are searching min Perimeter
     * @return result - min perimeter
     */
    public int solution(int N){
        int result = 2 * (1 + N);

        if(N==0) return 0;
        else {
            for(int i=1; i<=N/i; i++){
                if(i*(N/i) == N ){
                    result = Math.min(result, 2 * ( i + N/i));
                }

            }
        }
        return result;
    }
}
