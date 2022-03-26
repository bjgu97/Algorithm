import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_14891_톱니바퀴_1 {
	static int[] arr1, arr2, arr3, arr4;
	static int[][] arr = new int[5][8];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 1. 톱니바퀴 만들기
		
		arr1 = new int[8];
		arr2 = new int[8];
		arr3 = new int[8];
		arr4 = new int[8];
		
		String s = br.readLine();
		for(int i = 0; i < 8; i++) {
			arr1[i] = s.charAt(i) - '0';
		}
		s = br.readLine();
		for(int i = 0; i < 8; i++) {
			arr2[i] = s.charAt(i) - '0';
		}
		
		s = br.readLine();
		for(int i = 0; i < 8; i++) {
			arr3[i] = s.charAt(i) - '0';
		}
		
		s = br.readLine();
		for(int i = 0; i < 8; i++) {
			arr4[i] = s.charAt(i) - '0';
		}
		
		arr[1] = arr1;
		arr[2] = arr2;
		arr[3] = arr3;
		arr[4] = arr4;
		
		int K = Integer.parseInt(br.readLine());
		
		for(int k = 0; k < K; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			
				if(d == 1) { // 시계방향
					if(arr[n%4][2] == arr[(n+1)%4][6]) arr2 = rotateClockwise(arr2); // 1 -2
					if(arr[(n+1)%4][2] == arr[(n+2)%4][6]) arr3 = rotateClock(arr3); // 2-3
					if(arr[(n+2)%4][2] == arr[(n+3)%4][6]) arr4 = rotateClockwise(arr4); // 3-4
				}
				else {
					if(arr[n%4][2] == arr[(n+1)%4][6]) arr2 = rotateClock(arr2); 
					if(arr[(n+1)%4][2] == arr[(n+2)%4][6]) arr3 = rotateClockwise(arr3);
					if(arr[(n+2)%4][2] == arr[(n+3)%4][6]) arr4 = rotateClock(arr4);
				}
			

			System.out.println(Arrays.toString(arr1));
			System.out.println(Arrays.toString(arr2));
			System.out.println(Arrays.toString(arr3));
			System.out.println(Arrays.toString(arr4));
			System.out.println();
		}
		
		int answer = 0;
		if(arr1[0] == 1) answer += 1;
		if(arr2[0] == 1) answer += 2;
		if(arr3[0] == 1) answer += 4;
		if(arr4[0] == 1) answer += 8;
		
		System.out.println(answer);
	}
	
	static int[] rotateClockwise(int[] arr) {
		int a = arr[7];
		for(int i = 1; i < 8; i++) {
			arr[i] = arr[i-1];
		}
		arr[0] = a;
		
		return arr;
	}
	static int[]  rotateClock(int[] arr) {
		int a = arr[0];
		for(int i = 0; i < 7; i++) {
			arr[i] = arr[i+1];
		}
		arr[7] = a;
		
		return arr;
	}
}
