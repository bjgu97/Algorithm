package 실버;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1057_토너먼트 {
public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());
	
	int N = Integer.parseInt(st.nextToken()); // 참가자 수
	int kim = Integer.parseInt(st.nextToken()); //김지민 1
	int yim = Integer.parseInt(st.nextToken()); //임한수 2
	
	int round = 0; // 총 라운드 수
	int maxRound = (int)Math.sqrt(N) + 1;
	
	while(maxRound-- > 0) {
		round++;
		kim = (kim + 1) / 2; // kim 다음 번호
		yim = (yim + 1) / 2; // yim 다음 번호
		
		if(kim == yim) { // 종료조건: 두 사람 번호가 같아지면(만나면)
			break;
		}
	}

	System.out.println(round);
	}
}
