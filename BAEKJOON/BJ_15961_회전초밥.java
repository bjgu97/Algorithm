import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_15961_회전초밥{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 접시의 수
		int D = Integer.parseInt(st.nextToken()); // 초밥의 가짓수
		int K = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수
		int C = Integer.parseInt(st.nextToken()); // 쿠폰 번호
		
		int[] dishes = new int[N];
		int[] kinds = new int[D+1];
		
		for(int n = 0; n < N; n++) {
			dishes[n] = Integer.parseInt(br.readLine());
		}
		
		// 0 ~ K 먼저 초밥 담기
		int cnt = 1; // 쿠폰 있으므로 1부터 시작
		kinds[C]++;
		for(int k = 0; k < K; k++) {
			if(kinds[dishes[k]] == 0) { // 처음에 비어 있다면
				kinds[dishes[k]]++; // 초밥 추가
				cnt++; // 종류 추가
			}
			else
				kinds[dishes[k]]++; // 그냥 초밥 추가
		}
		
		int answ = 0;
		for(int n = 0; n < N; n++) {
			kinds[dishes[n]]--; // 앞에 초밥 뺴고
			if(kinds[dishes[n]] == 0) { // 0이 되면
				cnt--; // 초밥 종류 빼주기
			}
			kinds[dishes[(n+K)%N]]++; // 뒤에 초밥 더하고(순환 -> %)
			if(kinds[dishes[(n+K)%N]] == 1) { // 0에서 1이 되면
				cnt++;
			}
			answ = Math.max(answ, cnt);
		}
		
		System.out.println(answ);
	}
}
