import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_14499_주사위굴리기 {
	static 		int[] dice;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 지도 세로 크기
		int M = Integer.parseInt(st.nextToken()); // 지도 가로 크기
		int x = Integer.parseInt(st.nextToken()); // 주사위 좌표 x
		int y = Integer.parseInt(st.nextToken()); // 주사위 좌표 y
		int K = Integer.parseInt(st.nextToken()); // 명령어 개수 k
		
		int[][] map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		for(int[] a : map)
//			System.out.println(Arrays.toString(a));
		dice = new int[6];
		
		int[] command = new int[K];
		st = new StringTokenizer(br.readLine());
		for(int k = 0; k < K; k++) {
			command[k] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < K; i++) {
			int dir = command[i];
			
			if(dir == 1) {
				if(y + 1 >= M)
					continue;
				y++;
				change(dice);
			}
			else if(dir == 2) {
				if(y - 1 < 0)
					continue;
				y--;
				change(dice);
			}
			else if(dir == 3) {
				if(x - 1 < 0)
					continue;
				x--;
				change(dice);
				
			}
			else if(dir == 4) {
				if(x + 1 >= N)
					continue;
				x++;
				change(dice);
			}
			
			if(map[x][y] == 0)
				map[x][y] = dice[1];
			else {
				dice[1] = map[x][y];
				map[x][y] = 0;
			}
			System.out.println(dice[0]);
		}
		
	}

	static void change(int[] dice) {
		int temp = dice[1];
		dice[1] = dice[5];
		dice[5] = dice[0];
		dice[0] = dice[4];
		dice[4] = temp;
		
	}

	
}
