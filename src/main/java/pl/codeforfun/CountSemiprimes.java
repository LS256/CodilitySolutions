
package pl.codeforfun;

public class CountSemiprimes {


    public int[] solution(int N, int[] P, int[] Q){
        boolean[] primes = getPrimes(N);
        boolean[] semiprimes = getSemiprimes(N, primes);
        int[] factors = getFactors(N, semiprimes);

        int[] results = new int[P.length];
        for(int i=0; i<P.length;i++){
            results[i] = factors[Q[i]] - factors[P[i]-1];
        }
        return results;
    }

    public int[] getFactors(int N, boolean[] semiprimes){
        int[] factors = new int[N+1];

        int tempVal =0;
        for(int i =0; i<=N;i++){
            if(semiprimes[i]){
                tempVal++;
            }
            factors[i] = tempVal;
        }
        return factors;
    }


    public boolean[] getSemiprimes(int N, boolean[] primes){
        boolean[] semiprimes = new boolean[N+1];

        for(int i=2; i<=N/2; i++) {
            if (!primes[i]) {
                int j = i;
                while (i * j <= N) {
                    if (!primes[j]) {
                        semiprimes[j * i] = true;
                    }
                    j++;
                }
            }
        }
        return semiprimes;
    }



    public boolean[] getPrimes(int N) {
        boolean[] primes = new boolean[N];

        int i =2;

        while(i*i < N){
            int k = i+i;
            while(k<N){

                primes[k] = true;
                k+=i;
            }

            i++;
            while(primes[i]){
                i++;
            }
        }

        return primes;
    }


}
