

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEKJOON_2869_달팽이는올라가고싶다 {
	public static void main(String[] args) throws IOException {
		//높이가 V인 막대
		//낮에 A미터 올라가고
		//밤에 B미터 떨어진다
		//정상 도착하면 미끄러지지 않는다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		// 2 1 / 3 2 / 4 3 / 5
		// 5 4/ 9
		int h = A ;
		double day = 1 + Math.ceil((double)(V-A)/(double)(A-B));
		
		// O(1) 이 되도록!
		System.out.printf("%d", (int)day);
	}
}
