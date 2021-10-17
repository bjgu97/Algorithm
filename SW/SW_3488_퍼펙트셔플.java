/**
* @since 2021. 2. 5.
* @author bjgu9
* @see
* @mem
* @time
* @caution 큐
*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SW_3488_퍼펙트셔플 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		LinkedList<String> list = new LinkedList<>();
		
		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < Math.ceil((double)N/2); i++) {
				list.add(st.nextToken());
			}
			int p = 1;
			for(int i = 0; i < N/2; i++) {
				list.add(p, st.nextToken());
				p += 2;
			}
		
			sb.append("#").append(t+1).append(" ");
			for(String i : list) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			list.clear();
		}
		System.out.println(sb);
	}
}
//public class SW_3488_퍼펙트셔플 {
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int T = Integer.parseInt(br.readLine());
//		StringBuilder sb = new StringBuilder();
//
//		for(int t = 0; t < T; t++) {
//			int N = Integer.parseInt(br.readLine());
//			
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			String[] NArr = new String[N];
//			
//			for(int n= 0; n < N; n++) {
//				NArr[n] = st.nextToken();
//			}
//			
////			System.out.println(Arrays.toString(NArr));
//			
//			int mid = 0;
//			for(int i = 0; i < N; i++) {
//				if(N%2==0)
//					 mid =N/2; 
//				else
//					mid = N/2+1;
//			}
//			// mid까지가 앞부분.
//			String[] arr1 = new String[mid];
//			String[] arr2 = new String[mid];
//			
////			System.out.println("mid: " + mid);
////			System.out.println("N-mid: " + (N-mid));
//			for(int i = 0; i < mid; i++) {
//				arr1[i] = NArr[i];
//			}
//			for(int i= mid; i < N; i++) {
//				arr2[i-mid] = NArr[i];
//			}
//			
////			System.out.println(Arrays.toString(arr1));
////			System.out.println(Arrays.toString(arr2));
//			sb.append("#").append(t+1).append(" ");
//			for(int i = 0; i < mid-1; i++) {
//				sb.append(arr1[i]).append(" ").append(arr2[i]).append(" ");
//			}
//			
//			if(arr2[mid-1] == null)
//				sb.append(arr1[mid-1]).append("\n");
//			else
//				sb.append(arr1[mid-1]).append(" ").append(arr2[mid-1]).append("\n");
//		}
//		System.out.println(sb);
//	}
//}
