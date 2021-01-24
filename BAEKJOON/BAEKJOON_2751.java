import java.util.Arrays;
import java.util.Scanner;

public class BAEKJOON_2751 {
	// N:  ~1,000,000
	static int N;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt(); //N: 수의 개수
		int[] NArr = new int[N]; //수 저장 배열
		
		for(int i = 0; i < N; i++) {
			NArr[i] = scan.nextInt();
		}
		
		int[] NArr_merged = mergeSort(NArr);
		
		for(int i = 0; i < N; i++) {
			System.out.println(NArr_merged[i]);
		}	
		
	}

	static int[] mergeSort(int[] arr) {
		if(arr.length == 1)
			return arr;
		
		int mid = N / 2;
		int[] arr_low = Arrays.copyOfRange(arr, 0, mid);
		int[] arr_high = Arrays.copyOfRange(arr, mid, N);
 
 
	    return arr;
	}
}
	 