import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14500_테트로미노_1 {
	static int[][][] tetros = {
			{{0, 1}, {0, 2}, {0, 3}}, // ㅡ
			{{1, 0}, {2, 0}, {3, 0}}, // |
			{{0, 1}, {1, 0}, {1, 1}}, // ㅁ
			{{1, 0}, {2, 0}, {2, 1}}, // ㄴ
			{{1, 0}, {2, 0}, {2, -1}}, // ㄴ 뒤집
			{{0, 1}, {0, 2}, {1, 2}}, // ㄱ
			{{1, 0}, {0, 1}, {0, 2}}, // ㄱ 뒤집
			{{1, 0}, {1, 1}, {1, 2}}, // ㄴ
			{{1, 0}, {1, -1}, {1, -2}},
			{{0, 1}, {1, 0}, {2, 0}},
			{{0, 1}, {1, 1}, {2, 1}},
			{{1, 0}, {1, 1}, {2, 1}},
			{{1, 0}, {1, -1}, {2, -1}},
			{{0, 1}, {1, 0}, {1, -1}},
			{{0, 1}, {1, 1}, {1, 2}},
			{{0, 1}, {0, 2}, {1, 1}},
			{{1, 0}, {2, 0}, {1, 1}},
			{{1, 0}, {2, 0}, {1, -1}},
			{{1, 0}, {1, -1}, {1, 1}}
		};
	static int answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for(int m = 0; m < M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		
		findMax(map, N, M);
		
		System.out.println(answer);
	}
	
	static void findMax(int[][] map, int N, int M) {
		int tetrosLen = tetros.length;
		
		for(int n = 0; n < N; n++) {
			for(int m = 0; m < M; m++) {
				for(int t = 0; t < tetrosLen; t++) {
					int sum = map[n][m];
					for(int i = 0; i < 3; i++) {
						int nr = n + tetros[t][i][0];
						int nc = m + tetros[t][i][1];
						
						if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
						sum += map[nr][nc];
					}
					
					answer = Math.max(answer, sum);
				}
			}
		}
	}
}
