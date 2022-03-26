import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_1009_분산처리 {
	public static void main(String[] args) throws IOException {
		// 1-1 2-2 3-3 ...10-10 11-1
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int N = 1;
			

			for(int b = 0; b < B; b++) {
				N = N * A;
				N = N % 10;
			}
			if(N == 0) System.out.println(10);
			else System.out.println(N);
			
		}
	}
}
