import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ_19583_싸이버개강총회 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String S = st.nextToken(); // 개강총회 시작 시간
		String E = st.nextToken(); // 개강총회 끝낸 시간
		String Q = st.nextToken(); // 스트리밍 끝낸 시간
		
		int SHour = Integer.parseInt(S.substring(0, 2));
		int SMin = Integer.parseInt(S.substring(3,5));
		int EHour = Integer.parseInt(E.substring(0,2));
		int EMin = Integer.parseInt(E.substring(3,5));
		int QHour = Integer.parseInt(Q.substring(0,2));
		int QMin = Integer.parseInt(Q.substring(3,5));
		
		HashMap<String, Boolean> map = new HashMap<>();
	
		int answer = 0;
		
		String ss = null;
		while(true) {
			String s = br.readLine();
			if(s==null && s.equals("")) break;
			
			st = new StringTokenizer(s);
			String time = st.nextToken();
			String name = st.nextToken();
			
			int timeHour = Integer.parseInt(time.substring(0,2));
			int timeMin = Integer.parseInt(time.substring(3,5));
			
			// 시작
			if(timeHour < SHour || (timeHour == SHour && timeMin <= SMin)) {
				map.put(name, true);
			}
			
			if((timeHour > EHour && timeHour < QHour) || (timeHour == EHour && timeMin >= EMin && timeHour != QHour) || (timeHour == QHour && timeMin <= QMin && timeHour != EHour)
					|| (timeHour == EHour && timeHour == QHour && timeMin >= EMin && timeMin <= QMin)) {
				if(map.containsKey(name) && map.get(name)) {
					map.put(name, false);
					answer++;
				}
			}
//			System.out.println("answer: " +answer);
		}
		
		System.out.println(answer);
	}
}
