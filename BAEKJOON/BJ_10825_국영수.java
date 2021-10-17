import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_10825_국영수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[][] arr = new String[N][4];
		for(int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[n][0] = st.nextToken();
			arr[n][1] = st.nextToken();
			arr[n][2] = st.nextToken();
			arr[n][3] = st.nextToken();
		}
		
		Arrays.sort(arr, (a, b) -> {
			if(Integer.parseInt(a[1]) != Integer.parseInt(b[1])) { // 국어 점수
				return Integer.parseInt(b[1]) - Integer.parseInt(a[1]);
			}
			else {
				if(Integer.parseInt(a[2]) != Integer.parseInt(b[2])) {
					return Integer.parseInt(a[2]) - Integer.parseInt(b[2]);
				}
				else {
					if(Integer.parseInt(a[3]) != Integer.parseInt(b[3])) {
						return Integer.parseInt(b[3]) - Integer.parseInt(a[3]);
					}
					else {
						return a[0].compareTo(b[0]);
					}
				}
			}
			
		});
		
		for(String[] a : arr)
			System.out.println(a[0]);
	}
}
