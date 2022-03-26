import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_2160_그림비교 {
	static int[] numbers;
	static int[][] answer;
	static char[][][] arr;
	static int min;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		arr = new char[N][5][7];
		
		for(int n = 0; n < N; n++) {
			char[][] map = new char[5][7];
			for(int i = 0; i < 5; i++) {
				String s = br.readLine();
				for(int j = 0; j < 7; j++) {
					map[i][j] = s.charAt(j);
				}
			}
			arr[n] = map;
		}
		
		numbers = new int[2];
		answer = new int[N+1][N+1];
		comb(0, 0, arr, N);
		
		outer:for(int i = 0; i <= N; i++) {
			for(int j = i+1; j <= N; j++) {
				if(answer[i][j] == min) {
					System.out.println((Math.min(i, j)+1) + " " + (Math.max(i, j)+1));
					break outer;
				}
			}
		}
	}

	static void comb(int cnt, int start, char[][][] arr, int N) {
		if(cnt == 2) {
			int answ = 0;
			System.out.println(Arrays.toString(numbers));
			for(int i = 0; i < 5; i++) {
				for(int j = 0; j < 7; j++) {
					if(arr[numbers[0]][i][j] == arr[numbers[1]][i][j]) {
						answ++;
					}
				}
			}
			answer[numbers[0]][numbers[1]] = answ;
			min = Math.max(min, answ);
			return;
		}
		
		for(int i = start; i < N; i++) {
			numbers[cnt] = i;
			comb(cnt+1, i+1, arr, N);
		}
	}
}
