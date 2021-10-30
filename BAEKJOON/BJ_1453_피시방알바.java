import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1453_피시방알바 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 1번부터 100번까지.
		// 자리에 사람 없으면 컴퓨터 가능.
		// 거정당하는 사람 수
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 손님 수
		
		boolean[] seats = new boolean[101];
		Arrays.fill(seats, false);
		seats[0] = true;
		
		int answer = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int n = 0; n < N; n++) {
			int num = Integer.parseInt(st.nextToken());
			if(seats[num] == true) {
				answer++;
			}
			else {
				seats[num] = true;
			}
		}
		
		System.out.println(answer);
	}
}
