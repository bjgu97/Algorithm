import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_17427_약수의합2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// f(A) : A의 모든 약수를 더한 값
		// x보다 작거나 같은 모든 자연수 y의 f(y)를 더한 값은 g(x)
		
		// N이 주어졌을 떄, g(N)
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		long sum = 0;
		for(int n = 1; n <= N; n++) {
			sum += (N/n) * n;
		}
		
		System.out.println(sum);
		
	}
}
