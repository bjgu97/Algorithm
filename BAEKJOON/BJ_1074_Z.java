import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1074_Z {
	static int r;
	static int c;
	static int answ;
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		find(0, 0, (int)Math.pow(2, N));
		
		System.out.println(sb);
	}
	
	static void find(int row, int col, int len) {
		if(len == 1) {
			if(r == row && c == col) {
				sb.append(answ);
			}
			answ++;
			return;
		}
		
		if(!(row<=r && r<row+len && col <=c && c <col + len)) {
			answ +=len * len;
			return;
		}
		
		int nextLen = len/ 2;
		find(row, col, nextLen); // 첫번쨰 좌상 블록
		find(row, col + nextLen, nextLen); // 두번째 우상 블록
		find(row + nextLen, col, nextLen);
		find(row + nextLen, col + nextLen, nextLen);
	}
}
