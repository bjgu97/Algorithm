import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_4892_숫자맞추기게임 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// n0 주어짐
		// n1 = 3 * n0 계산한 뒤 n1 짝수인지 홀수인지.
		// n1 짝수면 n2 = n1/2
		// n1 홀수면 n2 = (n1 + 1) / 2
		// n3 = 3 * n2
		// n4 = n3 / 9
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int idx = 1;
		while(true) {
			int n0 = Integer.parseInt(br.readLine());
			if(n0 == 0)
				break;
			sb.append(idx).append(". ");
			int n1 = 3 * n0;
			int n2;
			if(n1 % 2 == 0) {
				sb.append("even ");
				n2 = n1 / 2;
			}
			else {
				n2 = (n1 + 1) / 2;
				sb.append("odd ");
			}
			int n3 = 3 * n2;
			int n4 = n3 / 9;
			sb.append(n4).append("\n");
			idx++;	
		}
		System.out.println(sb);
	}
}
