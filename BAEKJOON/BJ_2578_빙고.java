import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2578_빙고 {
	static boolean[][] visited = new boolean[5][5]; 
	static int num;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 빙고 입력
		int[][] arr = new int[5][5];
		for(int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 5; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 사회자가 부르는 수 입력
		int[] command = new int[25];
		int idx = 0;
		for(int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 5; j++) {
				command[idx++] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 사회자가 수 부를 때 마다 표시
		for(int i = 0; i < 25; i++) {
			call(arr, command, i);	

			// 빙고인지 확인
			if(check()) {
				System.out.println(i+1);
				break;
			}
			
		}

	}
	
	
	static void call(int[][] arr, int[] command, int a) {
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				if(arr[i][j] == command[a]) {
					visited[i][j] = true;
				}
			}
		}
	}
	
	
	static boolean check() {
		int BingoNum = 0;
		boolean check = true;
		
		// 대각선 확인
		for(int i = 0; i < 5; i++) {
			if(visited[i][i] == false) {
				check = false;
			}
		}
		
		if(check)
			BingoNum++;

		if(BingoNum == 3)
			return true;
		
		// 또 다른 대각선 확인
		check = true;
		for(int i = 0; i < 5; i++) {
			if(visited[i][4-i] == false) {
				check = false;
			}
		}
		if(check)
			BingoNum++;

		if(BingoNum == 3)
			return true;
		
		// 각 세로줄 확인
		for(int i = 0; i < 5; i++) {
//			for(boolean[] a : visited)
//				System.out.println(Arrays.toString(a));
//			System.out.println();
			if(visited[i][0] == true && visited[i][1] == true && visited[i][2] == true && visited[i][3] == true && visited[i][4] == true) {
				BingoNum++;

				if(BingoNum == 3)
					return true;
			}
		}
		
		//각 가로줄 확인
		for(int i =0; i < 5; i++) {
			if(visited[0][i] == true && visited[1][i] == true && visited[2][i] == true && visited[3][i] == true && visited[4][i] == true) {
				BingoNum++;

				if(BingoNum == 3)
					return true;
			}
		}
		
		return false;
	}
}
