

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BAEKJOON_2443_별찍기6 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < i; j++) { //0 1 2 3 4
				bw.write(' ');
			}
			for(int j = 2*N-1; j > 2*i; j--) { //9 7 5 3 1
				bw.write('*');
			}
//			for(int j = 0; j > )
			bw.newLine();
		}
		bw.flush();
	}

}
