import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_3029_경고 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String time1 = br.readLine();
		String time2 = br.readLine();
		
		String[] arr1 = time1.split(":");
		String[] arr2 = time2.split(":");
		
		int[] diff = new int[3];
		int[] answer = new int[3];
		
		for(int i = 0; i < 3; i++) {
			diff[i] = Integer.parseInt(arr2[i]) - Integer.parseInt(arr1[i]);
		}
		
//		System.out.println(Arrays.toString(diff));
		
		int second = 0;
		int minute = 0;
		int hour = 0;
		
		// 초 계산
		if(diff[2] < 0) {
			second = 60 + diff[2];
			diff[1]--;
		}
		else {
			second = diff[2];
		}
//		System.out.println(Arrays.toString(diff));
		
		// 분 계산
		if(diff[1] < 0) {
			minute = 60 + diff[1];
			diff[0]--;
		}
		else {
			minute = diff[1];
		}
		
		// 시간 계산
		if(diff[0] < 0) {
			hour = 24 + diff[0];
		}
		else {
			hour = diff[0];
		}
		
//		System.out.println(hour);
//		System.out.println(minute);
//		System.out.println(second);
		
		if(hour == 0 && minute == 0 && second == 0) 
			System.out.printf("%02d:%02d:%02d", 24, 0, 0);
		else
			System.out.printf("%02d:%02d:%02d", hour, minute, second);
	}
}
