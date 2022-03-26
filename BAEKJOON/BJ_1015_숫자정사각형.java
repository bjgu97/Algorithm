import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1015_숫자정사각형 {
	static int N;
	static int M;
	static int[][] map;
	
	static int len;
	static int height;
	
	static int answer;
	public static void main(String[] args) throws IOException {
		// N * M 직사각형
		// 꼭짓점에 쓰여있는 수가 모두 같은 가장 큰 정사각형?
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int n = 0; n < N; n++) {
			String s = br.readLine();
			for(int m = 0; m < M; m++) {
				map[n][m] = s.charAt(m) - '0';
			}
		}
		
//		for(int[] a : map)
//			System.out.println(Arrays.toString(a));
		int max = 1;
		for(int n = 0; n < N; n++) {
			for(int m = 0; m < M; m++) {
				searchHor(n, m);
//				searchVer(n, m);
//				int size = searchDia(n, m);
//				max = Math.max(max, size);
			}
		}
		System.out.println(answer);
	}
	
	static void searchDia(int n, int m) {
		int size = 1;
		if(map[n][m] == map[n+height][m+len] && (height == len)) {
			size = (height+1) * (len+1);
		}
		
		answer = Math.max(answer, size);
//		return size;
	}
	static void searchVer(int n, int m) {
		height = 0;
		
		for(int i = 0; i < N; i++) {
			if(map[n][m] == map[i][m]) {
				height = i - n;
				searchDia(n, m);
			}
		}
	}
	static void searchHor(int n, int m) {
		len = 0;
		for(int j = m; j < M; j++) {
			if(map[n][m] == map[n][j]) {
				len = j - m;
				searchVer(n, m);
			}
		}		
	}
}
