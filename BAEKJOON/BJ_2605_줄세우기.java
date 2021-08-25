

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_2605_줄세우기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// 포인트: 뒤집어서 생각해보기!
		
		// 배열에 입력 받기
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int n = 0; n < N; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
		}
		
		//해당 인덱스에 1부터 N까지 추가
		List<Integer> list = new LinkedList<Integer>();
		for(int n = 0; n < N; n++) {
			list.add(arr[n], n+1);
		}
		
		//거꾸로 출력
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(N-1-i) + " ");
		}
	}
}
