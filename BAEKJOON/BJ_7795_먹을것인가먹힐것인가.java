import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_7795_먹을것인가먹힐것인가 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// A는 자기보다 작은거만
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[] A = new int[N];
			int[] B = new int[M];
			
			st = new StringTokenizer(br.readLine());
			for(int n = 0; n < N; n++) {
				A[n] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int m = 0; m < M; m++) {
				B[m] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(A);
			Arrays.sort(B);
			
			int answer = 0;
			
			for(int n = 0; n < N; n++) {
				for(int m = 0; m < M; m++) {
					if(A[n] > B[m]) {
						answer++;
					}
					else {
						break;
					}
				}
			}
			
			System.out.println(answer);
		}
	}
}
