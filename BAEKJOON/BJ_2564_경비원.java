import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2564_경비원 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int width = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());
		
		int numStore = Integer.parseInt(br.readLine());
				
		// 각 상점들
		int[][] temp = new int[numStore][2];
		for(int n = 0; n < numStore; n++) {
			st = new StringTokenizer(br.readLine());
			temp[n][0] = Integer.parseInt(st.nextToken());
			temp[n][1] = Integer.parseInt(st.nextToken());
		}
		
		// 동근 위치
		int[][] dong = new int[1][2];
		st = new StringTokenizer(br.readLine());
		dong[0][0] = Integer.parseInt(st.nextToken());
		dong[0][1] = Integer.parseInt(st.nextToken());
		
		int answer = 0;
		
		// 각 상점 위치
		for(int n =0; n < numStore; n++) {
			int[] arr= new int[width * 2 + height * 2];

			switch(dong[0][0]) {
			case 1:
				arr[dong[0][1]] = 2;
				break;
			case 2:
				arr[width + height + (width - dong[0][1])] = 2;
				break;
			case 3:
				arr[width*2 + height + (height - dong[0][1])] = 2;
				break;
			case 4:
				arr[width + dong[0][1]] = 2;
			}
			
			switch(temp[n][0]) {
			case 1:
				arr[temp[n][1]] = 1;
				break;
			case 2:
				arr[width + height + (width - temp[n][1])] = 1;
				break;
			case 3:
				arr[width*2 + height + (height - temp[n][1])] = 1;
				break;
			case 4:
				arr[width + temp[n][1]] = 1;
			}
//			System.out.println(Arrays.toString(arr));
			
			int num1 = 0;
			int num2 = 0;
			for(int i= 0; i < arr.length; i++) {
				if(arr[i] == 1) {
					num1 = i;
				}
				else if(arr[i] == 2) {
					num2 = i;
				}
			}
			
			answer += Math.min(Math.abs(num1 - num2) , arr.length - Math.abs(num1 - num2));
		}
		
		System.out.println(answer);
		
	}
}
