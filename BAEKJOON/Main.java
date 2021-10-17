import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static boolean[][] trains;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		trains = new boolean[N + 1][21];

		for (int idx = 0; idx < M; idx++) {
			st = new StringTokenizer(br.readLine(), " ");
			int command = Integer.parseInt(st.nextToken());
			System.out.println("command: " + command);
			int i = Integer.parseInt(st.nextToken());
			int x = -1;
			if (command == 1 || command == 2) {
				x = Integer.parseInt(st.nextToken());
			}

			if (command == 1) {
				trains[i][x] = true;
			} else if (command == 2) {
				trains[i][x] = false;
			} else if (command == 3) {
				for (int seat = 19; seat >= 1; seat--) {
					if (trains[i][seat]) {
						trains[i][seat + 1] = trains[i][seat];
						trains[i][seat] = false;
					}
					
					trains[i][0] = false;
				}
			} else if (command == 4) {
				for (int seat = 1; seat < 20; seat++) {
					trains[i][seat] = trains[i][seat + 1];
					trains[i][seat + 1] = false;
				}
			}
			for(boolean[] a : trains)
				System.out.println(Arrays.toString(a));
			System.out.println();
	}

		Set<String> set = new HashSet<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			sb.setLength(0);
			for (int j = 1; j <= 20; j++) {
				if (trains[i][j]) {
					sb.append(j);
				}
			}

			set.add(sb.toString());

		}
		System.out.println(set.size());
	}

}