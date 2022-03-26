import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1100_하얀칸 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[][] arr = new char[8][8];
		
		for(int i = 0; i < 8; i++) {
			String s= br.readLine();
			for(int j = 0; j < 8; j++) {
				arr[i][j] = s.charAt(j);
			}
		}
		int answer = 0;
		for(int i = 0; i < 8; i ++) {
			if(i%2 == 0) {
				for(int j = 0; j < 8; j += 2) {
					if(arr[i][j] == 'F') {
						answer++;
					}
				}
			}
			else {
				for(int j = 1; j < 8; j += 2) {
					if(arr[i][j] == 'F') {
						answer++;
					}
				}
			}
		}
		
		System.out.println(answer);
	}
}
