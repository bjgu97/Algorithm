import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1436_영화감독숌 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 종말의 숫자: 6이 3개 이상 들어간 수
		// 666 1666 2666 ...
		// N번째 종말의 숫자?
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int n = 0;
		int num = 0;
		while(true) {
			num++;
			String s = Integer.toString(num);
			int cnt = 0;
			for(int c = 0; c < s.length()-2; c++) {
				if(s.charAt(c) == '6' && s.charAt(c+1) == '6' && s.charAt(c+2) == '6') {
					n++;
					break;
				}
			}
			
			if(n == N)
				break;
		}
		
		System.out.println(num);
	}
}
