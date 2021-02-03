/**
* @since 2021. 2. 1.
* @author bjgu9
* @see https://swexpertacademy.com/main/talk/solvingClub/problemView.do?contestProbId=AV19AcoKI9sCFAZN&solveclubId=AXdbYpT6xskDFAUO&problemBoxTitle=0201&problemBoxCnt=1&probBoxId=AXdbYpUKxsoDFAUO+
* @mem 19.140
* @time 100ms
* @caution 구현 & string을 char로 접근하기?
*/

package Algorithm.sw.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Solution_1289_원재의메모리복구하기 {
	// 입력과 출력에 필요한 요소들
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		//테케 개수
		int T = Integer.parseInt(br.readLine());
		
		//알고리즘
		for(int t = 1; t <= T; t++) {
			String line = br.readLine();
			int answer = 0;
			char num = '0';
			
			char[] cArr = line.toCharArray();
			
			for(int i = 0; i < line.length(); i++) {
				if(cArr[i] != num) {
					answer++;
					num =cArr[i];
				}
			}
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		
		//정답 출력
		System.out.println(sb);
	}
	
	static int solution1(String line) {
		// 데이터를 1/0으로만 관리하고 서로 바꿔야한다...
		boolean[] datas = new boolean[line.length()];
		for(int i = 0; i < datas.length; i++) {
			datas[i] = line.charAt(i) == '1'; //1이면 true, 아니면 false 들어감
		} //데이터 초기화 완료
		
		int cnt = 0;
		
		for(int i = 0; i < datas.length; i++) {
			if(datas[i]) { //1이면 true
				cnt++;
				for(int j = i+1; j < datas.length; j++) {
					datas[j] = !datas[j];
				}
			}
		}
		return cnt;
	}
}
