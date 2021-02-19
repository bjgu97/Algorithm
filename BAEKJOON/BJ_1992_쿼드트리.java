import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1992_쿼드트리 {
	static StringBuilder sb = new StringBuilder();
	static int[][] NArr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		NArr = new int[N][N];
		for(int n = 0; n < N; n++) {
			String s = br.readLine();
			for(int m = 0; m < N; m++) {
				NArr[n][m] = s.charAt(m) - '0';
			}
		}
		
		find(0, 0, N);
		
		System.out.println(sb);
	}
	
	static void dnc(int r, int c, int n) {
		// 기저조건 - 찾는 영역의 색이 모두 같으면 종료
		for(int r2 = r; r2 < r + n; r2++) {
			for(int c)
		}
	}
	static void find(int row, int col, int n) {
		// 길이가 1이 되면
		if(n == 1) {
			sb.append(NArr[row][col]);
			return;
		}
		// 길이가 1 아니면
		int first = NArr[row][col];
		boolean check = true;
		
		for(int r = row; r < row + n; r++) {
			for(int c = col; c < col + n; c++) {
				if(NArr[r][c] != first)
					check = false;
			}
		}
		// 모두 같으면
		if(check)
			sb.append(first);
		//다른거 존재하면
		else {
			sb.append("(");
			int nextLen = n / 2;
			find(row, col, nextLen);
			find(row, col + nextLen, nextLen);
			find(row + nextLen, col, nextLen);
			find(row + nextLen, col + nextLen, nextLen);
			sb.append(")");
			}
	}
}
