import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_13458_시험감독 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		
		for(int n = 0; n < N; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
		}
		
		
		st = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		long cnt = 0; // 최소 감독관 수
		for(int n = 0; n < N; n++) {
			cnt++;
			arr[n] = arr[n] - B;
		}
		
		for(int n = 0; n < N; n++) {
			if(arr[n] < C && arr[n] > 0) {
				cnt++;
			}
			else if(arr[n] > 0) {
				if(arr[n] % C == 0) {
					cnt += arr[n] / C;
				}
				else {
					cnt += (arr[n] / C + 1);
				}
			}
		}
		
		System.out.println(cnt);
		
	}
}
