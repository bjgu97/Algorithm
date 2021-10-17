import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BJ_3184_양 {
	public static void main(String[] args) throws IOException {
		// . : 빈 필드
		// # : 울타리
		// o : 양
		// V : 늑대
		
		// 영역 안의 양의 수가 늑대보다 많으면 이기고 늑대 쫓아낸다.
		// 그렇지 않으면 늑대가 양 모두 먹는다.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[R][C];
		for(int r = 0; r < R; r++) {
			String s = br.readLine();
			for(int c = 0; c < C; c++) {
				map[r] = s.toCharArray();
			}
		}
		
		
	}

}
