package 워밍업;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BAEKJOON_2445_별찍기8 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {  // 0 1 2 3 4
			//첫번째 별: 1 2 3 4 5
			for(int j = 0; j <= i; j++) {
				bw.write('*');
			}
			
			//공백: 8 6 4 2 0
			for(int j = (2*N-2) - 2*i; j > 0; j--) {
				bw.write(' ');
			}
			
			//별: 1 2 3 4
			for(int j = 0; j <= i; j++) {
				bw.write('*');
			}			
			bw.newLine();
		}

		for(int i = 1; i < N; i++) { // 1 2 3 4
			for(int j = N-i; j >0; j--) { //4 3 2 1
				bw.write('*'); 
			}
			// 2 4 6 8
			for(int j = 0; j < 2*i; j++) {
				bw.write(' ');
			}
			for(int j = N-i; j >0; j--) { //4 3 2 1
				bw.write('*'); 
			}
			
			bw.newLine();
		}
		bw.flush();
	}

}
