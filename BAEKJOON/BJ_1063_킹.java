import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1063_킹 {	
	static char[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String kingPos = st.nextToken();
		String stonePos = st.nextToken();
		int N = Integer.parseInt(st.nextToken());
		
		map = new char[8][8];
		
		// map에 stone과 king 위치 표시
		int kr = 8 - (kingPos.charAt(1) - '0');
		int kc = (kingPos.charAt(0)- 65);
		
		int sr = 8 - (stonePos.charAt(1) - '0');
		int sc = (stonePos.charAt(0)- 65);

		map[kr][kc] = 'o';
		map[sr][sc] = 'x';

		int nkr = kr;
		int nkc = kc;
		int nsr = sr;
		int nsc = sc;

		for(int n = 0; n < N; n++) {
			kr = nkr;
			kc = nkc;
			sr = nsr;
			sc = nsc;
			String s = br.readLine();
			if(s.equals("R")) {
				if(kr < 0 || kr >= 8 || kc < 0 || kc >= 8) continue; // 킹 현재
				if(kr < 0 || kr >= 8 || kc+1 < 0 || kc+1 >= 8) continue; // 킹 다음이동
				if(map[kr][kc+1] == 'x') {					
					if(sr < 0 || sr >= 8 || sc+1 < 0 || sc+1 >= 8) continue;	
					nkr=kr;nkc=kc+1;nsr=sr;nsc=sc+1;
					map[kr][kc] = ' ';
					map[nkr][nkc] = 'o';
					map[nsr][nsc] = 'x';	
				}
				else {
					nkr=kr;nkc=kc+1;
					map[kr][kc] = ' ';
					map[nkr][nkc] = 'o';
				}
			}
			else if(s.equals("L")) {
				if(kr < 0 || kr >= 8 || kc < 0 || kc >= 8) continue; // 킹 현재
				if(kr < 0 || kr >= 8 || kc-1 < 0 || kc-1 >= 8) continue;
				if(map[kr][kc-1] == 'x') {	
					if(sr < 0 || sr >= 8 || sc-1 < 0 || sc-1 >= 8) continue;	
					nkr=kr;nkc=kc-1;nsr=sr;nsc=sc-1;
					map[kr][kc] = ' ';
					map[nkr][nkc] = 'o';
					map[nsr][nsc] = 'x';	
				}
				else {
					nkr=kr;nkc=kc-1;
					map[kr][kc] = ' ';
					map[nkr][nkc] = 'o';
				}
			}
			else if(s.equals("B")) {
				if(kr < 0 || kr >= 8 || kc < 0 || kc >= 8) continue; // 킹 현재
				if(kr+1 < 0 || kr+1 >= 8 || kc < 0 || kc >= 8) continue;
				if(map[kr+1][kc] == 'x') {					
					if(sr+1 < 0 || sr+1 >= 8 || sc < 0 || sc >= 8) continue;	
					nkr=kr+1;nkc=kc;nsr=sr+1;nsc=sc;
					map[kr][kc] = ' ';
					map[nkr][nkc] = 'o';
					map[nsr][nsc] = 'x';	
				}
				else {
					nkr=kr+1;nkc=kc;
					map[kr][kc] = ' ';
					map[nkr][nkc] = 'o';
				}
			}
			else if(s.equals("T")) {
				if(kr-1 < 0 || kr-1 >= 8 || kc < 0 || kc >= 8) continue;
				if(map[kr-1][kc] == 'x') {					
					if(sr-1 < 0 || sr-1 >= 8 || sc < 0 || sc >= 8) continue;	
					nkr=kr-1;nkc=kc;nsr=sr-1;nsc=sc;
					map[kr][kc] = ' ';
					map[nkr][nkc] = 'o';
					map[nsr][nsc] = 'x';	
				}
				else {
					nkr=kr-1;nkc=kc;
					map[kr][kc] = ' ';
					map[nkr][nkc] = 'o';
				}
			}
			else if(s.equals("RT")) {
				if(kr-1 < 0 || kr-1 >= 8 || kc+1 < 0 || kc+1 >= 8) continue;
				if(map[kr-1][kc+1] == 'x') {					
					if(sr-1 < 0 || sr-1 >= 8 || sc+1 < 0 || sc+1 >= 8) continue;	
					nkr=kr-1;nkc=kc+1;nsr=sr-1;nsc=sc+1;
					map[kr][kc] = ' ';
					map[nkr][nkc] = 'o';
					map[nsr][nsc] = 'x';	
				}
				else {
					nkr=kr-1;nkc=kc+1;
					map[kr][kc] = ' ';
					map[nkr][nkc] = 'o';
				}
			}
			else if(s.equals("LT")) {
				if(kr-1 < 0 || kr-1 >= 8 || kc-1 < 0 || kc-1 >= 8) continue;
				if(map[kr-1][kc-1] == 'x') {					
					if(sr-1 < 0 || sr-1 >= 8 || sc-1 < 0 || sc-1 >= 8) continue;	
					nkr=kr-1;nkc=kc-1;nsr=sr-1;nsc=sc-1;
					map[kr][kc] = ' ';
					map[nkr][nkc] = 'o';
					map[nsr][nsc] = 'x';	
				}
				else {
					nkr=kr-1;nkc=kc-1;
					map[kr][kc] = ' ';
					map[nkr][nkc] = 'o';
				}
			}
			else if(s.equals("RB")) {
				if(kr+1 < 0 || kr+1 >= 8 || kc+1 < 0 || kc+1 >= 8) continue;
				if(map[kr+1][kc+1] == 'x') {					
					if(sr+1 < 0 || sr+1 >= 8 || sc+1 < 0 || sc+1 >= 8) continue;	
					nkr=kr+1;nkc=kc+1;nsr=sr+1;nsc=sc+1;
					map[kr][kc] = ' ';
					map[nkr][nkc] = 'o';
					map[nsr][nsc] = 'x';	
				}
				else {
					nkr=kr+1;nkc=kc+1;
					map[kr][kc] = ' ';
					map[nkr][nkc] = 'o';
				}
			}
			else if(s.equals("LB")) {
				if(kr+1 < 0 || kr+1 >= 8 || kc-1 < 0 || kc-1 >= 8) continue;
				if(map[kr+1][kc-1] == 'x') {					
					if(sr+1 < 0 || sr+1 >= 8 || sc-1 < 0 || sc-1 >= 8) continue;	
					nkr=kr+1;nkc=kc-1;nsr=sr+1;nsc=sc-1;
					map[kr][kc] = ' ';
					map[nkr][nkc] = 'o';
					map[nsr][nsc] = 'x';	
				}
				else {
					nkr=kr+1;nkc=kc-1;
					map[kr][kc] = ' ';
					map[nkr][nkc] = 'o';
				}
			}
		}
		String kingFinal = "";
		String stoneFinal = "";
		for(int r = 0; r < 8; r++) {
			for(int c = 0; c < 8; c++) {
				if(map[r][c] == 'o') {
					kingFinal = Character.toString((char) ('A'+c)) + Integer.toString(8-r); // (0, 0) -> A1
				}
				if(map[r][c] == 'x') {
					stoneFinal = Character.toString((char) ('A'+c)) + Integer.toString(8-r);
				}
			}
		}
		System.out.println(kingFinal);
		System.out.println(stoneFinal);
	}
}
