import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_13164_행복유치원 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int n = 0; n < N; n++) {
			int num = Integer.parseInt(st.nextToken());
			arr[n] = num;
		}
		
		int[] diffArr = new int[N-1];
		for(int n = 0; n < N-1; n++) {
			diffArr[n] = arr[n+1] - arr[n];
		}
		
		Arrays.sort(diffArr);
		
		int answer= 0;
		for(int n = 0; n < N-K; n++) {
			answer += diffArr[n];
		}
		
		System.out.println(answer);
	}
}
