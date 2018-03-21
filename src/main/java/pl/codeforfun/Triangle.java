package pl.codeforfun;

import java.util.Arrays;

/*
 * Triangle
 * Determine whether a triangle can be built from a given set of edges.
 * Solution got 100% of performance
 */
public class Triangle {
	public Triangle() {

	}

	public int doTriangleExist(int[] A) {
		Arrays.sort(A);

		for (int i = 0; i < A.length - 3; i++) {
			int P = A[i];
			int Q = A[i + 1];
			int R = A[i + 2];

			if ((P + Q > R) && (Q + R > P) && (R + P > Q))
				return 1;
		}
		return 0;
	}
}
