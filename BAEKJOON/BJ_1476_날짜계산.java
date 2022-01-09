import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BJ_1476_날짜계산 {
	public static void main(String[] args) throws IOException {
		// 지구 E, 태양 S, 달 M
		// 1년은 1 1 1
		// 수 범위 넘어가면 1 된다.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int e = 1;
		int s = 1;
		int m = 1;
		
		int cnt = 1;
		while(true) {
			if(e == E && s == S && m == M)
				break;
			else {
				e++;
				s++;
				m++;
				
				if(e > 15) e = 1;
				if(s > 28) s = 1;
				if(m > 19) m = 1;
				
				cnt++;
			}
			
			
		}
		
		System.out.println(cnt);
	}
}
