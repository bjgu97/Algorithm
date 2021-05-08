import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2846_오르막길 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 상근이가 측정한 높이의 수
		
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int n = 0; n < N; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
		}
		
		int max = 0;
		int num = 0;
		
		for(int n = 1; n < N; n++) {
			if((arr[n] > arr[n-1])) {
				num += arr[n] - arr[n-1];
			}
			else {
				max = Math.max(max, num);
				num = 0;
			}
			max = Math.max(max, num);

		}
		
		System.out.println(max);
	}
}
