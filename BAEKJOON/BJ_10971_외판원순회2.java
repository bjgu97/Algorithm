import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_10971_외판원순회2 {
	static int N;
	static int[][] W;
	static int[] numbers;
	static boolean[] selected;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 1번부터 N번까지 번호.
		// 한 도시에서 출발해 N개 도시 모주 거쳐 다시 원래 도시로 돌아오기
		// 한번 갔던 도시 갈수없음 visited
		// 가장 적은 비용 들여서
		
		// W : 드는 비용
		// 0이면 길 없음.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		numbers = new int[N];
		selected = new boolean[N];
		
		W = new int[N][N];
		for(int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int m = 0; m < N; m++) {
				W[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		
		perm(0);
		
		System.out.println(min);
	}
	
	static void perm(int cnt) {
		if(cnt == N) {
//			System.out.println(Arrays.toString(numbers));
			check(numbers);
			return;
		}
		for(int i = 0; i < N; i++) {
			if(selected[i])
				continue;
			numbers[cnt] = i;
			
			selected[i] = true;
			perm(cnt+1);
			selected[i] = false;
		}
	}
	static int min = Integer.MAX_VALUE;
	
	static void check(int[] numbers) {
		int len = numbers.length;
		int cost = 0;
		
		for(int i = 0; i < len-1; i++) {
			int start = numbers[i];
			int end = numbers[i+1];
			if(W[start][end] == 0)
				return;
			cost += W[start][end];
		}
		
		if(W[numbers[len-1]][numbers[0]] == 0)
			return;
		
		cost += W[numbers[len-1]][numbers[0]];
		
		min = Math.min(min, cost);
	}
}
