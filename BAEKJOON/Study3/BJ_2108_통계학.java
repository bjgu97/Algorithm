/**
* @since 2021. 2. 5.
* @author bjgu9
* @see
* @mem
* @time
* @caution
* 산술평균, 중앙값, 최빈값, 범위 구하기. 
*/
package Study3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ_2108_통계학 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// N: 수의 개수
		int N = Integer.parseInt(br.readLine()); //범위: 500,000 -> 2중for문 X
		StringBuilder sb = new StringBuilder();
		
		// 배열에 각 숫자 저장 완료
		int[] NArr = new int[N];
		for(int i = 0; i < N; i++) {
			int a = Integer.parseInt(br.readLine());
			NArr[i] = a;
		}
		
		
		
		
		
		// 1. 산술평균 출력
		double sum = 0;
		for(int i = 0; i < N; i++) {
			sum += NArr[i];
		}
		sb.append(Math.round(sum/N)).append("\n");
		
		
		
		
		
		// 2. 중앙값 출력
		int[] cntSort = new int[8001]; //정수 절댓값 4000 이하이므로,
		for(int i = 0;i < cntSort.length; i++) {
			cntSort[i] = 0;
		} // 배열 0으로 초기화
		
		// 카운팅정렬 수행 
		for(int i = 0; i < N; i++) {
			cntSort[4000 + NArr[i]]++; //음수 고려
		}
		
		//다시 리스트에 저장 
		List <Integer> list = new ArrayList<>();
	
		//리스트에 정렬된 수 저장됨. 
		for(int i = 0; i < cntSort.length; i++) {
			while(cntSort[i] != 0) {
				list.add(i - 4000);
				cntSort[i]--;
				
				if(cntSort[i] == 0)
					break;
			}
		}
		sb.append(list.get(N/2)).append("\n");
		
		
		
		
		
		
		
		/// 3. 최빈값 출력
		for(int i = 0;i < cntSort.length; i++) {
			cntSort[i] = 0;
		} //0으로 값 초기화
		
		// 각 숫자 몇번 등장했는지 알려주는 cntSort 배열 (오름차순)
		for(int i = 0; i < N; i++) {
			cntSort[4000 + NArr[i]]++;
		}
		
		int mode = 0;
		boolean flag = false; //최빈값 여러개면 두번쨰 작은 값 출력 조건
		int answ = 0;
		
		for(int i = 0; i < cntSort.length; i++) { // CntSOrt 배열에서 
			if(cntSort[i] > mode) { // 배열 값들의 최댓값을 찾기
				mode = cntSort[i];
				flag = true; //찾으면 true
				answ = i-4000; //해당 인덱스 = answer
			}

			else if(cntSort[i] == mode && flag == true) {  //두번쨰 최빈값 찾으면
				flag = false;
				answ = i-4000; //반환 
				
			}
		}
		sb.append(answ).append("\n");
		
		
		
		
		
		
		/// 4. 범위 출력
		//정렬된 리스트에서 (최댓값 - 최솟값)
		sb.append(list.get(N-1) - list.get(0));
		
		
		
		
		
		
		System.out.println(sb);
	}
}
