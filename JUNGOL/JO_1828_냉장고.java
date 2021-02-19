import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class JO_1828_냉장고 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] NArr = new int[N][2];
		
		// 입력 받기
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			NArr[n][0] = Integer.parseInt(st.nextToken());
			NArr[n][1] = Integer.parseInt(st.nextToken());
		}
		
		// 최고 온도로 정렬
		Arrays.sort(NArr, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return Integer.compare(a[1], b[1]);
			}
		});
		
//		Arrays.sort(NArr, (a, b) -> {
//			if(a[1] == b[1]) {
//				return Integer.compare(a[0],  b[0]);
//			}
//			else
//				return Integer.compare(a[1], b[1]);
//		});
		
		
		// 최고 온도로 비교해나가기
		int maxTemp = NArr[0][1];
		int answ = 1;
		
		for(int n = 1; n < N; n++) {
			if(maxTemp >= NArr[n][0] && maxTemp <= NArr[n][1]) {
				continue;
			}
			else {
				answ++;
				maxTemp = NArr[n][1];
			}
		}
		
		System.out.println(answ);
	}
	

}
