import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_11501_주식 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int n = 0; n < N; n++) {
				arr[n] = Integer.parseInt(st.nextToken());
			}
			List<Integer> list = new ArrayList<>();
			long answer = 0;
			long max = -1;
			for(int n = N-1; n>= 0; n--) {
				max = Math.max(max, arr[n]);
				if(arr[n] < max) {
					answer += max - arr[n];
				}
			}
			
			System.out.println(answer);
		}
	}
}
