import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class BJ_16200_해커톤 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int n = 0; n < N; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int idx = 0;
		int curr = 0;
		int answer = 0;
		while(true) {
			if(curr == N)
				break;
			for(int i = idx; i < idx + arr[idx]; i++) {
				curr++;
				
			}
			answer++;
			idx += curr;
		}
		
		System.out.println(answer);
	}
}
