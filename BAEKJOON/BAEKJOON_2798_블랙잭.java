import java.util.Arrays;
import java.util.Scanner;

//N 범위 100까지므로, 시간복잡도 상관 노
public class BAEKJOON_2798_블랙잭 {
	static int sum = 0;
	static int max = 0;
	
	static int N;
	static int M;
	static int[] NArr;
	
public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	N = scan.nextInt(); //카드의 개수
	M = scan.nextInt(); //딜러가 외치는 숫자
	
	NArr = new int[N]; //각 카드 번호 저장되는 배열
	
	for(int n = 0; n < N; n++) {
		NArr[n] = scan.nextInt(); //각 배열에 숫자 저장 완료 
	}
	
	System.out.println(find());
	
}

public static int find() {

	for(int i = 0; i < N-2; i++) {
		for(int j = i+1; j < N-1; j++) {
			for(int k = j+1; k < N; k++) {
				sum = NArr[i] + NArr[j] + NArr[k];
				
				if(sum <= M && sum > max) { //합이 M을 넘지 않고, max 넘지 않는 더 큰 값을 찾으면
					max = sum;
				}
			}
		}
	}
	
	return max;
}


}
