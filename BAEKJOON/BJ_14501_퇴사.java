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
		int[][] arr = new int[N][2];
		
		for(int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[n][0] = Integer.parseInt(st.nextToken()); // 일
			arr[n][1] = Integer.parseInt(st.nextToken()); // 비용
		}
		
		int[] temp = new int[N+1]; // n일부터 퇴사날까지 얻을 수 있는 최대 이익
		
		for(int i = 0; i < N; i++) {
			if(i + arr[i][0] < N+1) { // 날짜 범위 안넘어 갈 때
				temp[i + arr[i][0]] = Math.max(temp[i + arr[i][0]], temp[i] + arr[i][1]);
			}
			else
				temp[i+1] = Math.max(temp[i+1], temp[i]);
		}
	
		System.out.println(temp[N]);

	}
}
