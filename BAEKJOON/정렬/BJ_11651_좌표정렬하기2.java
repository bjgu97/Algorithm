package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_11651_좌표정렬하기2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] NArr = new int[N][2];
		for(int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			NArr[n][0] = Integer.parseInt(st.nextToken());
			NArr[n][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(NArr, (o1, o2) -> {
			if(o1[1] != o2[1]) { // y 좌표 다르면
				return Integer.compare(o1[1], o2[1]);
			}
			else { // y 좌표 같으면
				return Integer.compare(o1[0], o2[0]);
			}
		});
		
		for(int n = 0; n < N; n++) {
			System.out.print(NArr[n][0] + " ");
			System.out.println(NArr[n][1]);
		}
	}
}
