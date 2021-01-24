package CLASS1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BAEKJOON_2444_별찍기7 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		//1번째줄 ~ 5번째줄
		for(int i = 1; i <= N; i++) {
			// 공백: 4 3 2 1 0
			for(int j = N; j > i; j--) 
				bw.write(' ');
			// 별: 1 3 5 7 9
			for(int j = 1; j <= 2*i-1; j++) 
				bw.write('*');
			bw.newLine();
		}
		
		//6번째줄 ~ 10번쨰줄
		for(int i = 1; i <= N-1; i++) {
			// 공백: 1 2 3 4
			for(int j = 1; j <=i; j++) 
				bw.write(' ');
			// 별: 7 5 3 1
			for(int j = 2*N-(2*i+1); j > 0; j--) {
				bw.write("*");
			}
			bw.newLine();
		}
		bw.flush();
	}

}
