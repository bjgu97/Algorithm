

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BAEKJOON_2446_별찍기9 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		//오르막길,,
		for(int i = 0; i < N; i++) { //0 1 2 3 4
			//공백
			for(int j = 0; j <i; j++) {
				bw.write(' ');
			}
			//9 7 5 3 1
			for(int j = 2*N-(2*i+1); j > 0; j--) {
				bw.write('*');
			}
			bw.newLine();
		}
		
		//내리막길,,
		for(int i = 0; i < N-1; i++) { //0 1 2 3
			for(int j = N-2-i; j > 0;  j--) {
				bw.write(' ');
			}
			//3 5 7 9
			for(int j = 0; j < 2*i + 3; j++) {
				bw.write('*');
			}
			bw.newLine();
		}
		bw.flush();
	}

}
