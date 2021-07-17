import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_13398_연속합2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int n = 0; n < N; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp1 = new int[N];
		int[] dp2 = new int[N];
		
		dp1[0] = arr[0];
		dp2[0] = arr[0];
		for(int n = 1; n < N; n++) {
			dp1[n] = Math.max(arr[n], dp1[n-1] + arr[n]);
			dp2[n]= Math.max(dp1[n-1], dp2[n-1] + arr[n]);
		}
		
//		System.out.println(Arrays.toString(dp1));
//		System.out.println(Arrays.toString(dp2));
		
		int max = Integer.MIN_VALUE;
		for(int n = 0; n < N; n++) {
			max = Math.max(max, dp1[n]);
			max = Math.max(max, dp2[n]);
		}
		System.out.println(max);
	}
}
