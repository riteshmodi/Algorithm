package sokrati;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Pythagoras {

	public static void main(String[] args) {
		BufferedReader bufferRead = new BufferedReader(new InputStreamReader(
				System.in));

		try {
			int totalLines = Integer.parseInt(bufferRead.readLine());

			for (int index = 0; index < totalLines; ++index) {
				int N = Integer.parseInt(bufferRead.readLine());
				int count = 0;

				//Euclid's formula: http://en.wikipedia.org/wiki/Pythagorean_triple#Generating_a_triple
				for (long i = 2; i < (Math.sqrt(N) + 1); ++i) {
					for (long j = 1; j < i; ++j) {
						if (gcd(i, j) == 1) {
							long x = i * i, y = j * j;
							if (((i - j) % 2 != 0) && (x + y <= N)) {
								long k = 1;
								long a = x - y;
								long b = 2 * i * j;
								long c = x + y;
								while ((k) * c <= N) {
									count++;
									k++;
								}
							}
						}
					}
				}

				/*
				 * for(long c = N;c>=3;c--){ for(long b=c-1;b>=2;b--){ for(long
				 * a = b-1;a>=1;a--){ if(a*a + b*b == c*c){ count++; } } } }
				 */

				System.out.println(count);
			}
			// System.out.println(Math.min(sum, minimum));
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private static long gcd(long x, long y) {
		while (x * y != 0) {
			if (x >= y)
				x = x % y;
			else
				y = y % x;
		}
		return (x + y);
	}

}
