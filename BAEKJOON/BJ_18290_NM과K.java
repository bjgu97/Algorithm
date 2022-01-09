import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_18290_NM과K {
	static int N, M, K;
	static int[][] map;
	static int[] numbers1;
	static int[] numbers2;
	
	public static void main(String[] args) throws IOException {
		// 크기가 N*M인 격자판
		// 칸 K개 선택
		// 선택한 칸에 들어있는 수를 모두 더한 값의 최댓값
		// 선택한 두 칸 인접하면 안됨
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		numbers1 = new int[K];
		numbers2 = new int[K];
		map = new int[N][M];
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for(int m = 0; m < M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		
		// x: 0 ~ N-1 중 K개 선택 (0, 1, 2) (0, 1, 3)
		// y: 0 ~ M-1 중 K개 선택 (
		// x들 서로 인접 여부 확인
		// y들 서로 인접 여부 확인
		// 서로 인접 아니면 들어있는 수 다 더한다.
		
		
		comb1(0, 0);
	}
	
	static void comb1(int cnt, int start) {
		if(cnt == K) {		
			comb2(0, 0, numbers1);
			return;
		}
		
		for(int i = start; i < N; i++) {
			numbers1[cnt] = i;
			comb1(cnt+1, i+1);
		}
	}
	
	static void comb2(int cnt, int start, int[] numbers1) {
		if(cnt == K) {
			System.out.println(Arrays.toString(numbers1));
			System.out.println(Arrays.toString(numbers2));
			
			for(int a : numbers1) {
				for(int b : numbers2) {
					System.out.println("a, b: " + a + "," + b);
				}
			}
			
			System.out.println();

			return;
		}
		
		for(int i = start; i < M; i++) {
			numbers2[cnt] = i;
			comb2(cnt+1, i+1, numbers1);
		}
	}
}
