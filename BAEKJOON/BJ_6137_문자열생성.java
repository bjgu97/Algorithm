import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_6137_문자열생성 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String S = "";
		String T = "";
		
		for(int n = 0; n < N; n++) { //2000
			S += br.readLine();
		}
		
		System.out.println(S);
		
		int i = 0;
		int j = N-1;
		while(i >= 0 && j >= 0) {
			char front = S.charAt(i);
			char back = S.charAt(j);
			System.out.println("i, j: " + i + "," + j);
			System.out.println("front, back: " + front + "," + back);
			if(i > j)
				break;
			
			if(front > back) {
				T += back;
				S = S.substring(0, j);
				j--;
			}
			else if(front < back){
				T += front;
				S = S.substring(1,j+1);
				j--;
			}		
			else{
				int a = i;
				int b = j;
				while(a < b) {
					a++;
					b--;
					
					if(S.charAt(a) > S.charAt(b)) {
						T += S.charAt(j);
						S = S.substring(0,j);
						break;
					}
					else if(S.charAt(a) < S.charAt(b)) {
						T += S.charAt(i);
						S = S.substring(1,j+1);
						break;
					}
					
				}
				j--;
			}
			
			System.out.println("S: " + S);
			System.out.println("T: " + T);
			System.out.println();
		}
		T += S;
		System.out.println(T);
	}
}
