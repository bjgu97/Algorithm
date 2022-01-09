import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2116_주사위쌓기 {
	static int upperSide; // 주사위 윗면 추적.
	static int sideSum; // 옆면 합
	static boolean[][] sides; // 옆면 최대 구하기 위해.
	static int answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 아래서부터 1번, 2번, .. 순서로 쌓는 것.
		// 서로 붙어있는 주사위에서 붙어잉ㅆ는 면 숫자 같아야함
		// 1번 주사위만 맘대로 놓을 수 있음
		// 4개의 긴 옆면
		// 4개 옆면 중 어느 한 면 숫자 합이 최대가 되도록
		// 한 옆면 숫자의 합 최댓값?
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] dices = new int[N][6];
		
		for(int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int m = 0; m < 6; m++)
				dices[n][m] = Integer.parseInt(st.nextToken());
		}
		
		// A(0) - F(5),
		// B(1) - D(3)
		// C(2) - E(4)
		for(int num = 1; num <= 6; num++) { // 첫번쨰 주사위 먼저 쌓고
			 sides = new boolean[N][6];
			 
			for(int i = 0; i < 6; i++) {
				if(dices[0][i] == num) {
					upperSide = dices[0][i];
					sides[0][i] = true; // 아랫면 기록
					sides[0][otherSide(i)] = true; // 윗면 기록
					break;
				}
			}
			
			for(int n = 1; n < N; n++) { // 나머지 주사위 쌓아가기
				for(int m = 0; m < 6; m++) {
					if(dices[n][m] == upperSide) {
						upperSide = dices[n][otherSide(m)];
						sides[n][m] = true; 
						sides[n][otherSide(m)] = true;
						break;
					}
				}
			}
			sideSum = findSideSum(N, sides, dices);
			answer = Math.max(answer, sideSum);
		}
		
		System.out.println(answer);
	}

	static int findSideSum(int N, boolean[][] sides, int[][] dices) {
		int sum = 0;
		for(int n = 0; n < N; n++) {
			int max = 0;
			for(int m = 0; m < 6; m++) {
				if(!sides[n][m]) {
					max = Math.max(max, dices[n][m]);
				}
			}
			sum += max;
		}
		return sum;
	}
	
	static int otherSide(int m) {
		int mm = 0;
		if(m == 0) mm = 5;
		else if(m == 1) mm = 3;
		else if(m == 2) mm = 4;
		else if(m == 3) mm = 1;
		else if(m == 4) mm = 2;
		else if(m == 5) mm = 0;
		return mm;
	}
}
