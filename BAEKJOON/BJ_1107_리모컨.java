import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1107_리모컨 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 버튼이 0~9, +, -
		// 채널 N으로 이동하기 위해서 버튼 몇번?
		// 현재 채널은 100
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 이동하려는 채널
		int M = Integer.parseInt(br.readLine()); // 고장난 버튼 개수
		
//		int curr = 100;
//		int answ = Integer.MAX_VALUE;
		int answ= Math.abs(N - 100);
		
		if(M == 0) {
			answ = Math.min(Integer.toString(N).length(), answ);
		}
		else {
			StringTokenizer	st = new StringTokenizer(br.readLine());
			
			boolean[] arr = new boolean[10];
			
			for(int m = 0; m < M; m++) {
//				arr[m] = Integer.parseInt(st.nextToken()); // arr: 고장난 버튼들 담기
				arr[Integer.parseInt(st.nextToken())] = true;
			}

				String chann;
				boolean flag;
				for(int i = 0; i <= 1000000; i++) { // 100만
					chann = String.valueOf(i);
					
					// 고장난 버튼 포함되어있는지 확인
					flag = true;
					for(int c = 0; c <chann.length(); c++) {
							if(arr[chann.charAt(c) - '0']) {
								flag = false;
								break;
							}
						
					}
					
					if(flag) { // 고장난버튼 포함 안되어있다면
						answ = Math.min(answ, Math.abs(N - Integer.parseInt(chann)) + chann.length());
					}
				}
			}
		

		
		
		
		System.out.println(answ);
	}
}
