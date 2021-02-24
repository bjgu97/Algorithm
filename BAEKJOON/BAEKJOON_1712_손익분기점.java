

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEKJOON_1712_손익분기점 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		//판매량 출력
		// A: 고정 비용 B: 한대당 가변 비용 C: 노트북 가격
		// n: 판매량
		if(C-B==0 || A/(C-B) < 0)
			System.out.println(-1);
		else
			System.out.println(A/(C-B) + 1);
	}

}
