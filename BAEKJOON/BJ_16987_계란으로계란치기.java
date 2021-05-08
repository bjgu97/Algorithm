import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_16987_계란으로계란치기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 계란 수
		int[][] arr = new int[N][2];
		for(int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[n][0] = Integer.parseInt(st.nextToken()); // 계란의 내구도
			arr[n][1] = Integer.parseInt(st.nextToken()); // 계란의 무게
		}
		// 입력 끝
		
		dfs(0);
	}
	
	static void dfs(int count) {
		
	}
}
