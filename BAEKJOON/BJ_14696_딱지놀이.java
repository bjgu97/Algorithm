import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class BJ_14696_딱지놀이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < TC; tc++) {
			
			// 각 딱지 모양 입력받기
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int[] AArr = new int[A];
			for(int a = 0; a < A; a++) {
				AArr[a] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			int B = Integer.parseInt(st.nextToken());
			int[] BArr = new int[B];
			for(int b = 0; b < B; b++) {
				BArr[b] = Integer.parseInt(st.nextToken());
			}
			
//			System.out.println(Arrays.toString(AArr));
//			System.out.println(Arrays.toString(BArr));
			
			// 각 딱지 개수 저장(1, 2, 3, 4)
			int[] AA = new int[5];
			int[] BB = new int[5];
			for(int a = 0; a < A; a++) {
				AA[AArr[a]]++;
			}
			
			for(int b = 0; b < B; b++) {
				BB[BArr[b]]++;
			}
			
//			System.out.println(Arrays.toString(AA));
//			System.out.println(Arrays.toString(BB));
			
			/*
			    [0, 0, 0, 0, 1]
				[0, 1, 1, 2, 0]
				
				[0, 1, 2, 1, 1]
				[0, 1, 0, 2, 1]
				
				[0, 2, 1, 1, 0]
				[0, 1, 2, 1, 0]
				
				[0, 1, 1, 1, 1]
				[0, 0, 1, 1, 1]
				
				[0, 1, 1, 1, 2]
				[0, 1, 1, 1, 2]
			 */
			
			boolean check = false;  // 동점 판별해내기 위해서 
			
			outer:for(int i = 4; i >0; i--) { //우선순위 큰 딱지부터 비교
				for(int j = 4; j >0; j--) {
					if(AA[i] > BB[i]) { // A가 B보다 큰 딱지가 나오면
						check = true;
						System.out.println("A"); // 출력하고
						break outer; //바로 종료
					}
					else if(AA[i] < BB[i]) { // B가 A보다 큰 딱지가 나오면 
						check = true; 
						System.out.println("B"); // 출력하고
						break outer; //바로 종료
					}
				}
			}
			
			if(!check)
				System.out.println("D");
		}

	}
}
