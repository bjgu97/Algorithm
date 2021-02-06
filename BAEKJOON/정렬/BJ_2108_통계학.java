package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ_2108_통계학 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //범위: 50만
		StringBuilder sb = new StringBuilder();
		//배열에 각 숫자 저장 완료
		int[] NArr = new int[N];
		
		for(int i = 0; i < N; i++) {
			int a = Integer.parseInt(br.readLine());
			NArr[i] = a;
		}
		
//		System.out.println(Arrays.toString(NArr));
		
		//// 산술평균 출력
		double sum = 0;
		for(int i = 0; i < N; i++) {
			sum += NArr[i];
		}
//		System.out.println(Math.round(sum/N));
		sb.append(Math.round(sum/N)).append("\n");
		
		//// 중앙값 출력
		int[] cntSort = new int[8001]; 
		for(int i = 0;i < cntSort.length; i++) {
			cntSort[i] = 0;
		} //0으로 값 초기화
		
		//카운팅정렬 수행 
		for(int i = 0; i < N; i++) {
			cntSort[4000 + NArr[i]]++;
		}
		
		//다시 리스트에 저장 
		List <Integer> list = new ArrayList<>();
		
	
		for(int i = 0; i < cntSort.length; i++) {
			while(cntSort[i] != 0) {
				list.add(i - 4000);
				cntSort[i]--;
				
				if(cntSort[i] == 0)
					break;
			}
			
				
		}
//		System.out.println(list.get(N/2));		
		sb.append(list.get(N/2)).append("\n");
		
		for(int i = 0;i < cntSort.length; i++) {
			cntSort[i] = 0;
		} //0으로 값 초기화
		
		//카운팅정렬 수행 
		for(int i = 0; i < N; i++) {
			cntSort[4000 + NArr[i]]++;
		}
		
		/// 최빈값 출력
		int mode = 0;
		boolean flag = false;
		int answ = 0;
		for(int i = 0; i < cntSort.length; i++) {
			if(cntSort[i] > mode) {
				mode = cntSort[i];
				flag = true;
				answ = i-4000;
			}
			else if(cntSort[i] == mode && flag == true) {
				flag = false;
				answ = i-4000;
				
			}
		}
//		System.out.println(answ);
		sb.append(answ).append("\n");
		
		/// 범위 출력
//		System.out.println(list.get(N-1) - list.get(0));
		sb.append(list.get(N-1) - list.get(0));
		
		System.out.println(sb);
	}
}
