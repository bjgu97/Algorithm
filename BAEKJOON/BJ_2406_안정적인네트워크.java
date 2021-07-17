import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2406_안정적인네트워크 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int X = Integer.parseInt(st.nextToken()); // 컴퓨터개수
		int K = Integer.parseInt(st.nextToken()); // 연결되어있는 지사 컴퓨터 쌍 개수
		int[][] arr = new int[K][2];
		for(int k = 0;k < K; k++) {
			st = new StringTokenizer(br.readLine());
			arr[k][0] = Integer.parseInt(st.nextToken());
			arr[k][1] = Integer.parseInt(st.nextToken());
		}
		
		int[][] map = new int[X][X];
		for(int x = 0; x < X; x++) {
			st = new StringTokenizer(br.readLine());
			for(int y = 0; y < X; y++) {
				map[x][y] = Integer.parseInt(st.nextToken()); // 연결 드는 비용
			}
		}
		
		
	}
}
