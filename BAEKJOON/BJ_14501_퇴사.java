import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_14501_퇴사 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] T = new int[N];
		int[] P = new int[N];
		
		for(int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			T[n] = Integer.parseInt(st.nextToken());
			P[n] = Integer.parseInt(st.nextToken());
		}
		// 입력 끝
		
		// 시작 지점 반복
		int max = 0;
		for(int n = 0; n < N; n++) {
			int answ = 0;
			int pos = n;
			while(pos < N) {
				if(pos + T[pos]-1 < N) {
					answ += P[pos];
					pos += T[pos];
				}
				else
					break;
				System.out.println("pos: " + pos);

				System.out.println("answ: " + answ);
				System.out.println();
			}
			max = Math.max(max, answ);
		}
		
		System.out.println(max);
	}
}
