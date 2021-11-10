import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_9655_돌게임 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 탁자 위에 돌 N개
		// 돌은 1개, 3개 가져갈 수 있음
		// 마지막에 돌 가져가는 사람이 이김
		
		// 이기는 사람은?
		// 상근, 창영
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// 1 : 1 (상근)
		// 2 : 1 1 (창영)
		// 3 : 3 (상근)
		// 4 : 1 3 (창영)
		// 5 : 1 3 1 (상근)
		// 6 : 3 3, 1 3 1 1 (창영)
		// 7 : 1 3 3 (상근)
		if(N % 2 == 0)
			System.out.println("CY");
		else
			System.out.println("SK");
	}
}
