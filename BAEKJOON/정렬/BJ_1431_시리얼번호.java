package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;


public class BJ_1431_시리얼번호 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		//N개 입력받기
		String [] arr = new String[N];

		for(int n = 0; n < N; n++) {
			String s = br.readLine();
			arr[n] = s;
		}
		
		
		Arrays.sort(arr, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if(o1.length() < o2.length())
					return -1;//음수 리턴되면 o2 -- o1 순 정렬
				else if(o1.length() > o2.length()) { 
					return 1; // 양수 리턴되면 o1 -- o2 순
				}
				// 길이 같으면
				else if(o1.length() == o2.length()) {
					int sum1 = 0;
					int sum2 = 0;
					for(int i= 0; i < o1.length(); i++) {
						if(o1.charAt(i) >= '0' && o1.charAt(i) <= 0)
							sum1 += o1.charAt(i) - '0';
					}
					
					for(int i= 0; i < o2.length(); i++) {
						if(o2.charAt(i) >= '0' && o2.charAt(i) <= 0)
							sum2 += o2.charAt(i) - '0';
					}
					if(sum1 == sum2) {
						return o1.compareTo(o2);
					}
					else
						return Integer.compare(sum1, sum2);
				}
				return 1;
			}
		});
		
		System.out.println(Arrays.toString(arr));
	}
}
