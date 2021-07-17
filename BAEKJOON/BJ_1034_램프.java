import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1034_램프 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 행의 개수
		int M = Integer.parseInt(st.nextToken()); // 열의 개수
		
		int[][] map = new int[N][M];
		for(int n = 0; n < N; n++) {
			String s = br.readLine();
			for(int m = 0; m < M; m++) {
				map[n][m] = s.charAt(m) - '0';
			}
		}
		
		for(int[] a : map)
			System.out.println(Arrays.toString(a));
		
		
	}
}
