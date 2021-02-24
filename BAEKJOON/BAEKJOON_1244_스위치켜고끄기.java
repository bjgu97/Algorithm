

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEKJOON_1244_스위치켜고끄기 {
public static void main(String[] args) throws IOException {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	
	//스위치 수 입력받기
	int sN = Integer.parseInt(br.readLine());

	// 스위치 입력받기
	int[] arr = new int[sN];
	st = new StringTokenizer(br.readLine(), " ");

	for(int i = 0; i < sN; i++) {
		arr[i] = Integer.parseInt(st.nextToken());
	}
	
	
	//학생 수 입력받기
	int pN = Integer.parseInt(br.readLine());
		
	//학생 입력받기
	for(int i = 0; i < pN; i++) {
		st = new StringTokenizer(br.readLine(), " ");
		int sex = Integer.parseInt(st.nextToken());
		int num = Integer.parseInt(st.nextToken());
		
		// 남자면 
		if(sex == 1) {
			for(int k =1; k <= arr.length; k++) {
					if(k % num == 0) {
						arr[k-1] = arr[k-1] == 0 ? 1 : 0;
					}
			}
		}
		
		//여자면
		else if(sex == 2) {
			if(num == 1 || num == sN) { //숫자가 첫번쨰/마지막 인덱스이면
				arr[num-1] = arr[num-1] == 0 ? 1:0;
			}
			else {
				arr[num-1] = arr[num-1] == 0 ? 1:0;

				int l = num-2;
				int r = num;

				while(l >= 0 && r <= (sN-1)) {
					if(arr[l] == arr[r]) {
						arr[l] = arr[l] == 0 ? 1 : 0;
						arr[r] = arr[r] == 0 ? 1 : 0;
						l--;
						r++;

					}else {
						break;
					}
				}
				
			}
		}
		
	}
	for(int p = 1; p<= arr.length;p++) {
		System.out.print(arr[p-1]);
	 	if(p%20==0) 
	 		System.out.println();
	 	else 
	 		System.out.print(" ");
	}

}
}
